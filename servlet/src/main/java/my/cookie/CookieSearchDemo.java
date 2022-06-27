package my.cookie;

import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author liu peng bo
 * @date 2022/6/18 02:14
 */
public class CookieSearchDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().getId();
        Cookie[] cookies = req.getCookies();
        String sessionId = null;
        PrintWriter printWriter = resp.getWriter();
        if (cookies != null && cookies.length > 0) {
            System.out.println("cookies:");
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + ":" + value);
                if (name.equals("JSESSIONID")) {
                    sessionId = value;
                }
            }
        }
        if (sessionId != null && sessionId.equals(req.getSession().getId())) {
            printWriter.write("hello:" + req.getSession().getAttribute("user"));
        } else {
            printWriter.write("请先登录");
        }
        printWriter.flush();
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req,resp);
    }
}
