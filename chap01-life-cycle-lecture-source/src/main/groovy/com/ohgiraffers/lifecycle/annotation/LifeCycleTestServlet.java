package com.ohgiraffers.lifecycle.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
//어노테이션(annotation) 을 사용하면 서블릿 매칭을 더 간한하고 직관적으로 설정할 수 있다.
@WebServlet(value = "/annotation-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {
    private int initCount = 1;
    private int serviceCount =1;
    private int destoryCount =1;

    public LifeCycleTestServlet(){
        System.out.println("기본생성자 호출");
    }

    @Override
    public void init(ServletConfig config) throws ServletException { // init 은 초기화 라는 단어이다.
        System.out.println("annotation 방식 init() :" + initCount++);
    }

    @Override  //service 메서드는  doGet ,doPost 등 메서드로 분기요청을 해서 해결한다.
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("annotation 방식 service() :" + serviceCount++);

    }

    @Override // destroy 메서드는 서블릿이 종료될때 호출이 된다. 리소스 정리 작업
    public void destroy() {
        System.out.println("annotation 방식 destroy() :" + destoryCount++);
    }
}
