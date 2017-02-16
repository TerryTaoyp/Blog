package com.pandawork.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Taoyongpan on 2017/2/6.
 */
public class BasicFilter  implements Filter {

    public void destroy() {

    }

    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterchain)
            throws IOException, ServletException {

        HttpServletResponse response = (HttpServletResponse) servletResponse;
//  HttpServletRequest request = (HttpServletRequest) servletRequest;
//  HttpSession session = request.getSession();


// 指定允许其他域名访问
        System.out.print("mmmmmm");
        response.addHeader("Access-Control-Allow-Origin", "*");

        // 响应类型  响应方法

        response.addHeader("Access-Control-Allow-Methods", "POST, OPTIONS");

        // 响应头设置

        response.addHeader("Access-Control-Allow-Headers", "POWERED-BY-FANTONG");

        response.addHeader("Access-Control-Max-Age", "30");


        // 需要过滤的代码
        filterchain.doFilter(servletRequest, servletResponse);
    }

    public void init(FilterConfig config) throws ServletException {

    }
}
