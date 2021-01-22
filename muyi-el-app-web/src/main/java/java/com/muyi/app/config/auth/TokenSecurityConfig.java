package java.com.muyi.app.config.auth;

import com.demo.config.SedissonManage;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: muyi
 * @date: 2021-01-16 21:19
 */
@Configuration
public class TokenSecurityConfig implements WebMvcConfigurer {
    private static Logger LOGGER = LoggerFactory.getLogger(TokenSecurityConfig.class);


    @Autowired
    private SedissonManage sedissonManage;

    @Bean
    public AppSecurityInterceptor getAppSecurityInterceptor(){
        return new AppSecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration appInterceptorRegistry = registry.addInterceptor(getAppSecurityInterceptor());
        appInterceptorRegistry.addPathPatterns("/app/**");
    }

    private class AppSecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            return super.preHandle(request, response, handler);
        }
    }
}
