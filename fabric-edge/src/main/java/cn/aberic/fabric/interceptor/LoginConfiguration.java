/*
 * Copyright (c) 2018. Aberic - All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.aberic.fabric.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor());
        // 拦截路径
        loginRegistry.addPathPatterns("/league/*");
        loginRegistry.addPathPatterns("/org/*");
        loginRegistry.addPathPatterns("/orderer/*");
        loginRegistry.addPathPatterns("/peer/*");
        loginRegistry.addPathPatterns("/channel/*");
        loginRegistry.addPathPatterns("/chaincode/*");
        loginRegistry.addPathPatterns("/app/*");
        loginRegistry.addPathPatterns("/ca/*");
        loginRegistry.addPathPatterns("/user/*");
        loginRegistry.addPathPatterns("/index");

    }

    // 注册拦截器
    @Bean
    LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

}
