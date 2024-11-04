package com.ohgiraffers.lifecycle.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class LifeCycleTestServlet extends HttpServlet {

    /* comment. 각 메소드의 호출 횟수 카운트 할 필드 작성 */
    private int initCount = 1;
    private int serviceCount = 1;
    private int destoryCount = 1;

    public LifeCycleTestServlet() {
        System.out.println("기본생성자 호출됨...");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        /* comment. 최초 요청 시 동작하는 메소드
        *   서블릿 컨테이너에 의해 호출이 되며, 두 번째
        *   요청부터는 호출되지 않는다.
        *  */
        System.out.println("xml 매핑 init() 메소드 호출 : " + initCount++);
    }

    @Override
    public void destroy() {
        /* comment.
        *     서블릿 컨테이너가 종료될 때 호출되는 메소드
        *  */
        System.out.println("xml 매핑 destroy() 메소드 호출 : " + destoryCount++);
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        /* comment.
        *   서블릿 컨테이너에 의해 호출되며, 최초 요청 시
        *   init() 메소드 동작 후에 동작
        *   두 번재 요청부터는 init() 호출 없이 바로 호출됨
        *  */
        System.out.println("xml 매핑 service() 메소트 호출됨 : " + serviceCount++);
    }
}
