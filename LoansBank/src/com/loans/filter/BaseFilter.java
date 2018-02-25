package com.loans.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.loans.util.StringUtil;

/**
 * 过滤器，用于解决中文乱码和登录权限控制
 * @date 2017年10月4日上午11:36:01
 * @author Marshal
 */
public class BaseFilter implements Filter {

    /**
     * Default constructor. 
     */
    public BaseFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		
		//设置登录权限
		String uri = httpReq.getRequestURI();
		if (uri.endsWith(".js") || uri.contains(".css") || uri.contains(".png") || uri.contains(".jpg") || uri.contains(".gif") || uri.contains(".jsp")) {
			//对以上文件放行
			chain.doFilter(request, response);

		} else if (uri.contains("log") || uri.contains("isLogin") || uri.contains("index") || uri.contains("register") || uri.contains("upload")|| uri.contains("table") || uri.contains("perfact"))  {
			//对以上界面，直接放行(list首页index.jsp需要调用的Servlet所以给予放行)
			chain.doFilter(request, response);
		} else {
			//除了前面的页面，都需要登陆后才可以访问
			HttpSession session = httpReq.getSession(false);
			//如果用户没登录，则跳转到登录界面
			if (session == null || StringUtil.strIsEmpty((String) session.getAttribute("loginuser"))) {
				//判断是否是ajax请求
				if (httpReq.getHeader("x-requested-with") != null && 
						"XMLHttpRequest".equalsIgnoreCase(httpReq.getHeader("x-requested-with"))) {
					//向shttp头添加状态sessionStatus
					httpResp.setHeader("sessionstatus", "timeout");
					//403 没有访问权限
					httpResp.setStatus(403);
					//向http头添加登录的url
					httpResp.addHeader("loginPath", httpReq.getContextPath() + "/weiTime/html/login.jsp");
				} else {
					httpResp.sendRedirect(httpReq.getContextPath() + "/weiTime/html/login.jsp");
				}
			} else {
				chain.doFilter(request, response);
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
