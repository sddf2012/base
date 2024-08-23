package my.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import my.demo.domain.entity.ChatSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author liu peng bo
 * @date 2024/08/16 16:36
 */
@RestController
@RequestMapping("/chat")
public class ChatController extends BaseController {

    @GetMapping("/create")
    public ChatSession createChat(HttpServletRequest request, String targetUser) {
        return null;
    }
}
