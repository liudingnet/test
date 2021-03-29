package com.horse.identifier.util.token;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
    //关键，将拦截器作为bean写入配置中
    @Bean
    public AuthInterceptor myAuthInterceptor() {
        return new AuthInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(myAuthInterceptor());

        // 配置拦截的路径
        ir.addPathPatterns("/**");

        // 配置不拦截的路径
        ir.excludePathPatterns("**/swagger-ui");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
    }

    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }
}
