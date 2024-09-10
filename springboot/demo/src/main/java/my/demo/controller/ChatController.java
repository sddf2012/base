package my.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import my.demo.config.BusinessException;
import my.demo.config.CommonVo;
import my.demo.domain.bo.SendMessageBo;
import my.demo.domain.vo.LoginInfo;
import my.demo.domain.vo.MessageVo;
import my.demo.domain.vo.SessionInfo;
import my.demo.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * @author liu peng bo
 * @date 2024/08/16 16:36
 */
@RestController
@RequestMapping("/chat")
public class ChatController extends BaseController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @PostMapping("/getSessionById")
    public CommonVo<SessionInfo> getSessionById(HttpServletRequest request, @RequestParam("sessionId") Long sessionId) {
        LoginInfo loginInfo = getCurrentUser(request, true);
        return CommonVo.success(chatService.getSessionById(loginInfo, sessionId));
    }

    @PostMapping("/getOrCreateSession")
    public CommonVo<SessionInfo> getOrCreateSession(HttpServletRequest request, @RequestParam("targetUser") Long targetUser) {
        LoginInfo loginInfo = getCurrentUser(request, true);
        return CommonVo.success(chatService.getOrCreateSession(loginInfo, targetUser));
    }

    @PostMapping("/getUserSession")
    public CommonVo<List<SessionInfo>> getUserSession(HttpServletRequest request) {
        LoginInfo loginInfo = getCurrentUser(request, true);
        return CommonVo.success(chatService.getUserSession(loginInfo));
    }

    @PostMapping("/querySessionMessage")
    public CommonVo<List<MessageVo>> querySessionMessage(HttpServletRequest request, @RequestParam Long sessionId,
                                                         @RequestParam(required = false) Long maxMessageId) {
        LoginInfo loginInfo = getCurrentUser(request, true);
        return CommonVo.success(chatService.querySessionMessage(loginInfo, sessionId,maxMessageId));
    }

    @PostMapping("/sendMessage")
    public CommonVo<MessageVo> sendMessage(HttpServletRequest request, @RequestBody SendMessageBo messageBo) {
        LoginInfo loginInfo = getCurrentUser(request, true);
        messageBo.setSenderId(loginInfo.getId());
        return CommonVo.success(chatService.sendMessage(messageBo));
    }

    @PostMapping("/longPollingQueryMessageByUser")
    public DeferredResult<CommonVo<Map<String, List<MessageVo>>>> longPollingQueryMessageByUser(HttpServletRequest request) {
        LoginInfo loginInfo = getCurrentUser(request, true);
        DeferredResult<CommonVo<Map<String, List<MessageVo>>>> result = new DeferredResult<>(10000L, CommonVo.success(null));
        threadPoolExecutor.submit(() -> {
            int i = 0;
            while (i < 7) {
                Map<String, List<MessageVo>> messageMap = chatService.queryCacheMessageByUser(loginInfo);
                if (!CollectionUtils.isEmpty(messageMap)) {
                    result.setResult(CommonVo.success(messageMap));
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new BusinessException("business error");
                }
                i++;
            }
        });
        return result;
    }
}
