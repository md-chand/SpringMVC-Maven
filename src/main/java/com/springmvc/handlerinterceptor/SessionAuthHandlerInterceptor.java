package com.springmvc.handlerinterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.UserDetails;

public class SessionAuthHandlerInterceptor implements HandlerInterceptor
{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception
	{
		System.out.println("SessionAuthHandlerInterceptor.preHandle called");
		UserDetails userDetails = (UserDetails) request.getSession().getAttribute("LOGGEDIN_USER");
		boolean result = false;
		if (userDetails != null)
		{
			result = true;
		}
		else
		{
			response.sendRedirect("/springmvc/services/application/sessionExpired");
		}
		return result;
	}

}
