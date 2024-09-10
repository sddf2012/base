package my.demo.service;

import my.demo.config.BusinessException;
import my.demo.domain.bo.SendMessageBo;
import my.demo.domain.cnst.ChatConst;
import my.demo.domain.entity.ChatMessage;
import my.demo.domain.entity.ChatSession;
import my.demo.domain.entity.ChatSessionUser;
import my.demo.domain.entity.User;
import my.demo.domain.vo.LoginInfo;
import my.demo.domain.vo.MessageVo;
import my.demo.domain.vo.SessionInfo;
import my.demo.mapper.ChatMapper;
import my.demo.repository.ChatMessageRepository;
import my.demo.repository.ChatSessionRepository;
import my.demo.repository.ChatSessionUserRepository;
import my.demo.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author liu peng bo
 * @date 2024/08/16 17:24
 */
@Service
public class ChatService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatSessionRepository sessionRepository;

    @Autowired
    private ChatMessageRepository messageRepository;

    @Autowired
    private
    ChatSessionUserRepository sessionUserRepository;

    @Autowired
    private ChatMapper chatMapper;

    private static final ConcurrentHashMap<Long, Map<String, List<MessageVo>>> messageMap = new ConcurrentHashMap<>();

    public SessionInfo getSessionById(LoginInfo loginInfo, Long sessionId) {
        ChatSession chatSession = sessionRepository.findById(sessionId).orElse(null);
        if (chatSession == null) {
            return null;
        }
        List<ChatSessionUser> chatSessionUsers = sessionUserRepository.findBySessionIdAndUserIdNot(chatSession.getId(), loginInfo.getId());
        User target = null;
        for (ChatSessionUser chatSessionUser : chatSessionUsers) {
            if (!chatSessionUser.getUserId().equals(loginInfo.getId())) {
                target = userRepository.findById(chatSessionUser.getUserId()).orElse(null);
                break;
            }
        }
        if (target == null) {
            return null;
        }
        return generateSessionInfo(chatSession, target);
    }

    public SessionInfo getOrCreateSession(LoginInfo loginInfo, Long targetUserId) {
        User target = userRepository.findById(targetUserId).orElse(null);
        if (target == null) {
            throw new BusinessException("target user not exist");
        }
        String userUnitedId = loginInfo.getId() <= targetUserId ? loginInfo.getId() + "_" + targetUserId : targetUserId + "_" + loginInfo.getId();
        List<ChatSession> chatSessions = sessionRepository.findByUserUnitedId(userUnitedId);
        if (!CollectionUtils.isEmpty(chatSessions)) {
            return generateSessionInfo(chatSessions.get(0), target);
        }

        ChatSession chatSession = new ChatSession();
        chatSession.setName(target.getName());
        chatSession.setType(ChatConst.SessionType.SINGLE_CHAT.getCode());
        chatSession.setUserUnitedId(userUnitedId);
        chatSession.setCreateAt(new Date());
        chatSession = sessionRepository.save(chatSession);

        return generateSessionInfo(chatSession, target);
    }

    private SessionInfo generateSessionInfo(ChatSession chatSession, User target) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.setSessionId(String.valueOf(chatSession.getId()));
        sessionInfo.setName(chatSession.getName());
        sessionInfo.setType(chatSession.getType());
        sessionInfo.setUserUnitedId(chatSession.getUserUnitedId());
        sessionInfo.setTargetUserId(target.getId());
        sessionInfo.setTargetUserName(target.getName());
        sessionInfo.setTargetUserPhone(target.getPhone());
        return sessionInfo;
    }

    public List<SessionInfo> getUserSession(LoginInfo loginInfo) {
        return chatMapper.querySingleChatSession(loginInfo.getId());
    }

    public List<MessageVo> querySessionMessage(LoginInfo loginInfo, Long sessionId, Long maxMessageId) {
        List<ChatMessage> messages;
        if (maxMessageId == null) {
            messages = messageRepository.findBySessionIdOrderBySendAtAsc(sessionId);
        } else {
            messages = messageRepository.findBySessionIdAndIdGreaterThanOrderBySendAtAsc(sessionId, maxMessageId);
        }
        if (CollectionUtils.isEmpty(messages)) {
            return Collections.emptyList();
        }
        return messages.stream().map(a -> {
            MessageVo messageVo = new MessageVo();
            BeanUtils.copyProperties(a, messageVo);
            return messageVo;
        }).collect(Collectors.toList());
    }

    public MessageVo sendMessage(SendMessageBo messageBo) {
        //查询session
        Long sessionId = messageBo.getSessionId();
        ChatSession chatSession = sessionRepository.findById(sessionId).orElse(null);
        if (chatSession == null) {
            throw new BusinessException("session not exist");
        }
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSessionId(messageBo.getSessionId());
        chatMessage.setSenderId(messageBo.getSenderId());
        chatMessage.setReceiverId(messageBo.getReceiverId());
        chatMessage.setContent(messageBo.getContent());
        chatMessage.setContentType(messageBo.getContentType());
        chatMessage.setSendAt(new Date());
        chatMessage.setReadFlag(ChatConst.YesAndNo.NO.getCode());
        chatMessage = messageRepository.save(chatMessage);

        MessageVo messageVo = new MessageVo();
        BeanUtils.copyProperties(chatMessage, messageVo);
        messageMap.compute(chatMessage.getReceiverId(), (k, v) -> {
            if (v == null) {
                v = new ConcurrentHashMap<>();
            }
            List<MessageVo> messages = v.computeIfAbsent(String.valueOf(sessionId), k1 -> new ArrayList<>());
            messages.add(messageVo);
            return v;
        });
        return messageVo;
    }

    public Map<String, List<MessageVo>> queryCacheMessageByUser(LoginInfo loginInfo) {
        Map<String, List<MessageVo>> result = messageMap.get(loginInfo.getId());
        if (!CollectionUtils.isEmpty(result)) {
            messageMap.remove(loginInfo.getId());
        } else {
            result = null;
        }
        return result;
    }
}
