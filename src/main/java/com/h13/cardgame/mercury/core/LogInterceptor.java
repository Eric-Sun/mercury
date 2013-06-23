package com.h13.cardgame.mercury.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Created with IntelliJ IDEA.
 * User: sunbo
 * Date: 13-6-17
 * Time: 下午6:54
 * To change this template use File | Settings | File Templates.
 */
public class LogInterceptor implements HandlerInterceptor {
    private Log LOG = LogFactory.getLog(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String name = (String) SecurityUtils.getSubject().getSession().getAttribute("name");
        String uri = request.getRequestURI();
        Enumeration<String> e = request.getParameterNames();
        StringBuilder sb = new StringBuilder();
        while (e.hasMoreElements()) {
            String key = e.nextElement();
            String value = request.getParameter(key);
            sb.append("|" + key + "=" + value);
        }
        LOG.info(name + "|" + uri + "|" + sb.toString());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
