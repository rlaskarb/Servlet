package com.ohgiraffers.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName= req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
        // cookie  사용전 redirect 구문
        //   resp.sendRedirect("redirect");

        /*comment 쿠키 사용방법
        * 1. 쿠키를 만든다
        * 2. 만든 쿠키의 만료 시간을 설정한다.
        * 3. 응답 헤더에 쿠키를 담는다.
        * 4. 응답을 보낸다.
        * */

        // 1.  쿠키 생성하기.
        Cookie firstNameCookie = new Cookie("firstName",firstName);
        Cookie lastNameCookie = new Cookie("lostName",lastName);

        // 2. 쿠키 만료시간 설정
        firstNameCookie.setMaxAge(60*60*24); // 초 단위 설정(하루)
        lastNameCookie.setMaxAge(60*60*24); // 초 단위 설정(하루)

        // 3. 응답 헤더에 쿠키 담기
        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        // 4. 이제 리다이렉트 시키기
        resp.sendRedirect("redirect");
    }
}


