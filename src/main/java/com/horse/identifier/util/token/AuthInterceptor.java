package com.horse.identifier.util.token;

import com.horse.identifier.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.*;
import java.lang.reflect.Method;

public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String requestPath = request.getRequestURI();
        if (requestPath.contains("/v3/api-docs") || requestPath.contains("/swagger") || requestPath.contains("/configuration/ui")) {
            return true;
        }
        if (requestPath.contains("/error")) {
            return true;
        }
        if (requestPath.contains("/login") || requestPath.contains("/bslogin")) {
            return true;
        }
        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return true;
        }

        String token = request.getHeader("Authorization");
        Claim claim = tokenService.getEmployeeNoByToken(token);
        request.setAttribute("currentUser", claim);

        //检查会话是否过期
        if(redisTemplate.hasKey(claim.getEmployeeName() + claim.getDeviceTypeEnum()))
            return true;

        return false;
    }
}




