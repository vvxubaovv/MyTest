package com.xubao.test.simpleTest.swaggerTest;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author xubao
 * @version 1.0
 * @since 2019/3/5
 */
public class SwaggerTest
{
	public static void main(String[] args)
	{
		//依赖springmvc
		Docket docket = createRestApi();
		docket.host("192.168.1.52:11152");
	}

	public static Docket createRestApi()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.paths(PathSelectors.any())
				.build();
	}

	private static ApiInfo apiInfo()
	{
		return new ApiInfoBuilder()
				.title("web-service rest api")
				.description("提供游戏服务器对外调用接口")
				.version("1.0")
				.build();
	}
}
