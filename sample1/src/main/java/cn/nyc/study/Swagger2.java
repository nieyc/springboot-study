package cn.nyc.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * http://localhost:8080/swagger-ui.html
 * 可以实现良好的文档，方便app，各种平台调用
 * 
 * @author nyc
 * @version 0.1 (2017年12月24日 下午6:54:13)
 * @since 0.1
 * @see
 */



@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.nyc.study"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("中软万维网络技术上海分公司")
                .termsOfServiceUrl("http://www.cssweb.sh.cn/")
                .contact("nieyc@cssweb.sh.cn")
                .version("1.0")
                .build();
    }

}