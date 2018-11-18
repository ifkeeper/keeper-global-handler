package com.mingrn.keeper.global.handle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 RestFul API
 * 访问地址:http://ip:port/projectname/swagger-ui.html
 * 如:http://127.0.0.1:8080/swagger-ui.html
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 11/11/2018 13:41
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	@Value("${restful.api.title}")
	private String apiTitle;

	@Value("${restful.api.version}")
	private String apiVersion;

	@Value("${restful.api.web.base.package}")
	private String basePackage;

	@Value("${restful.api.contact.url}")
	private String contactUrl;

	@Value("${restful.api.description}")
	private static String apiDescription;

	@Value("${restful.api.contact.name}")
	private String contactName;

	@Value("${restful.api.contact.email}")
	private String contactEmail;

	@Value("${restful.api.termsOfServiceUrl}")
	private String apiTermsOfServiceUrl;

	@Bean
	public Docket createRestAip() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(basePackage))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(apiTitle)
				.version(apiVersion)
				.description(apiDescription)
				.termsOfServiceUrl(apiTermsOfServiceUrl)
				.contact(new Contact(contactName, contactUrl, contactEmail))
				.build();
	}
}