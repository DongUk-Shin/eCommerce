package donguk.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 외부 파일에 접근하기 위한 설정
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void  addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**") // image/ ~ 로 요청이 오묜 
                .addResourceLocations("file:///C:/Git/eCommerce/image/"); //이쪽으로 가세요
    }
}
