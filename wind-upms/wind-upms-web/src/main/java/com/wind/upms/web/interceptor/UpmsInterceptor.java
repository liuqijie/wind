package com.wind.upms.web.interceptor;

import com.wind.common.util.PropertiesFileUtil;
import com.wind.upms.dao.model.UpmsUser;
import com.wind.upms.rpc.api.UpmsApiService;
import com.wind.upms.web.controller.manage.UpmsOrganizationController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录信息拦截器
 * Created by liuqijie on 2017/7/5.
 */
public class UpmsInterceptor extends HandlerInterceptorAdapter {

    private static Logger _log = LoggerFactory.getLogger(UpmsInterceptor.class);
    private static final String WIND_OSS_ALIYUN_OSS_POLICY = PropertiesFileUtil.getInstance("wind-oss-client").get("wind.oss.aliyun.oss.policy");

    @Autowired
    UpmsApiService upmsApiService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("WIND_OSS_ALIYUN_OSS_POLICY", WIND_OSS_ALIYUN_OSS_POLICY);
        // 过滤ajax
        if (null != request.getHeader("X-Requested-With") && request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        }
        // 登录信息
        Subject subject = SecurityUtils.getSubject();
        String username = (String) subject.getPrincipal();
        UpmsUser upmsUser = upmsApiService.selectUpmsUserByUsername(username);
        request.setAttribute("upmsUser", upmsUser);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
