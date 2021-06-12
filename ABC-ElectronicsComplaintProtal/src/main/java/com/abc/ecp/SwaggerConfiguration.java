package com.abc.ecp;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import static springfox.documentation.builders.PathSelectors.regex;
	import com.google.common.base.Predicate;
	import static com.google.common.base.Predicates.or;

	import springfox.documentation.builders.ApiInfoBuilder;
	import springfox.documentation.service.ApiInfo;
	import springfox.documentation.spi.DocumentationType;
	import springfox.documentation.spring.web.plugins.Docket;
	import springfox.documentation.swagger2.annotations.EnableSwagger2;

	@EnableSwagger2
	@Configuration
	public class SwaggerConfiguration {

		@Bean
		public Docket postsApi() {
			return new Docket(DocumentationType.SWAGGER_2).groupName("customer-api").apiInfo(apiInfo()).select()
					.paths(postPaths()).build();
		}

		private Predicate<String> postPaths() {
			return or(regex("/client/.*"),regex("/engineer/.*"), regex("/admin/.*"),regex("/product/.*"),regex("/complaint/.*"));
		}

		private ApiInfo apiInfo() {
			return new ApiInfoBuilder().title("ABC-Electronics Complaints Portal API")
					.description("A portal to Book complaints related to Electronics")
					.termsOfServiceUrl("http://abcelectronics.com").license("ABC License")
					.licenseUrl("abcelectronicscompany@gmail.com").version("1.0").build();
		}

}
