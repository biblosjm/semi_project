package kr.co.iei;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//이제 클라우디너리를 사용하므로 로컬 이미지 리소스 핸들러가 필요하지 않습니다.
@Configuration 
public class WebConfig implements WebMvcConfigurer { 
	// @Value("${file.root}")
	// private String root;
	
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 클라우디너리 도입으로 로컬 파일 서빙 중단
	}
}
