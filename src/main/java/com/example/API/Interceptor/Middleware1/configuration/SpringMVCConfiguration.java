package com.example.API.Interceptor.Middleware1.configuration;

import com.example.API.Interceptor.Middleware1.interceptors.ApiLogginInterceptor;
import com.example.API.Interceptor.Middleware1.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMVCConfiguration implements WebMvcConfigurer {

    @Autowired
    private ApiLogginInterceptor apiLogginInterceptor;

    @Autowired
    private LegacyInterceptor legacyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLogginInterceptor);
        registry.addInterceptor(legacyInterceptor).addPathPatterns("/legacy");
    }
}

