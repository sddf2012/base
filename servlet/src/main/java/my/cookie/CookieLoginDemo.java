package my.cookie;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liu peng bo
 * @date 2022/6/18 上午12:35
 */
//@WebServlet(value = {"/login,/search"})
public class CookieLoginDemo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        System.out.println("sessionId:" + session.getId());
        session.setAttribute("user", user);
        resp.sendRedirect("/loginsuccess.html");
    }
}
