package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: 我的袜子都是洞
 * @description:
 * @path: PropertyManagement-servlet-CharactorFilter
 * @date: 2019-04-30 16:34
 */
@WebFilter(filterName="encodingFilter",urlPatterns="/*")
public class CharactorFilter implements Filter{

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 请求字符集
        servletRequest.setCharacterEncoding("UTF-8");
        // 设置相应头
        servletResponse.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
