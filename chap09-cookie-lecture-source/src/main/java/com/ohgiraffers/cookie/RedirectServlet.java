package com.ohgiraffers.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jboss.jdeparser.JComment;
import org.jboss.weld.context.http.Http;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        /*comment
         * Redirect 시에는 URL 을 재작성하게 되며,
         * URL 을 통해서 요청하는 방식이기 때문에
         * POST 방식이 아닌 GET 방식으로 처리해야 한다.
         * 따라서 Redirect 되는 서블릿은 doGet 메소드를 사용해서 처리해야 한다.
         * */

        String firstName = req.getParameter("firstName");
        String lastName =req.getParameter("lostName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);


        /*comment
        * 출력을 했을 때, null 값이 나오는거 확인
        * 따라서 redirect 시에는 request 가 2번 이루어지기 때문에
        * 첫번째 request 와 두번째 request 는 전혀 다른 객체가 된다. => 값 공유 불가능*/

        /*comment
        * 쿠키를 사용하는 방법
        * 1.request 에서 쿠키 목록을 배열 형태로 꺼낸다.
        * 2. 쿠키의 getName(),getValue() 를 이용해서 꺼낸다.
        * */


        Cookie[] cookies = req.getCookies();

        for(int i = 0; i < cookies.length; i++){
            System.out.println("cookie :" + cookies[i].getName() + "-" + cookies[i].getValue());

            if("firstName".equals(cookies[i].getName())){
                firstName = cookies[i].getValue();
            }else if ("lastName".equals(cookies[i].getName())){
                lastName = cookies[i].getValue();
            }
        }

        StringBuilder responseText = new StringBuilder();
        responseText.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h3>")
                .append(firstName)
                .append(lastName)
                .append("님 하위~</h3>")
                .append("</body>\n")
                .append("</html>\n");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(responseText.toString());

        out.flush();
        out.close();

        /*comment
        * 쿠키의 경우 text 파일 형태로 클라이언트 컴퓨터에 저장이 된다.
        * 그렇기 때문에 개인 pc는 상관이 없지만 공용 pc의 경우
        * 윔험 탈취 위험에 노출이 된다.
        * 따라서 민감한 정보는  session 을 이용하게 되며
        * 서버 컴퓨터 (톰켓서버에) 관리가 되기 때문에 보안에 더 우수하다.
        * */

    }
}
