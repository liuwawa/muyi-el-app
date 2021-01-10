package java.com.muyi.app.config;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: muyi
 * @Date: 2021/1/10 18:58
 */
@SpringBootApplication(scanBasePackages = {
        "com.muyi.*"
})
@MapperScan("com.muyi.core.dao")
@EnableMethodCache(basePackages = "com.muyi")
@EnableCreateCacheAnnotation
@NacosPropertySource(dataId = "muyi-el-app.yaml", autoRefreshed = true, type = ConfigType.YAML)
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
