package com.ohgiraffers.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import javax.xml.crypto.dsig.spec.XPathType;
import java.io.IOException;

@WebFilter(value = "/first/*")
public class FirstFilter implements Filter {

    public FirstFilter(){
        System.out.println("필터 기본 생성자 호출");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("치치칮 -Filter 여기는 턴스 턴스 응답하라");
    }



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*comment
        * doFilter 메소드는 request 가 전달 되기 전에
        * 가로채어 무엇인 가 할 이을 작성한다.
        * */
        System.out.println("doFilter 치치칮ㅋ Filter 여기도 응답하라");

        // 필터에서 싱행 할 코드 작성영역

        //실행할 코드 실행 후 다음 필터 혹은 서블릿으로 doGet/doPost 호출
        filterChain.doFilter(servletRequest,servletResponse);

        // 서블릿에서 처리 후 다시 수행 할 내용 있으면 작성하는 영역
        System.out.println("Servlet 치치칰 여기는 Filter 그동안 수고 많았다 임무는 완료되었다 성공적으로 적을 처리했다.");

    }

    @Override
    public void destroy() {
        System.out.println("destroy filter 치치치치칰 여기도 성공적으로 적을 처리 했다.(정지버튼)");

    }
}
