package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", //컴포넌트 스캔의 대상
        //만약 지정안하면 AutoAppConfig의 클래스의 패키지의 모든 하위 클래스를 스캔한다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  Configuration.class)
)
public class AutoAppConfig {
}
