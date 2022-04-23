package com.zcy.fruitshop.config;


import com.zcy.fruitshop.enumrate.RestResponseCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2//开启Swagger
public class SwaggerConfig {

    /*配置多个分组，只需要配置多个Docket即可，设置不同分组扫描不同的包*/
    @Bean
    public Docket docketA() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    @Bean
    public Docket docketB() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    @Bean
    public Docket docketC() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置Swagger的bean实例
    @Bean
    public Docket docket(Environment environment) {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        Arrays.stream(RestResponseCode.values()).forEach(stateCodeEnum ->
        {
            responseMessageList.add(
                    /*new ResponseMessageBuilder()
                            .code(stateCodeEnum.getCode())
                            .message(stateCodeEnum.getMsg())
                            .responseModel(new ModelRef(stateCodeEnum.getMsg()))
                            .build());//这种形式swagger提示自定义返回msg找不到*/
                    new ResponseMessageBuilder()
                            .code(stateCodeEnum.getCode())
                            .message(stateCodeEnum.getMsg())
                            .build());
        });
        /*//设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");
        //获取项目环境：是生产环境还是发布环境
        boolean flag = environment.acceptsProfiles(profiles);*/
        return new Docket(DocumentationType.SWAGGER_2)
                //添加全局状态码
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .apiInfo(apiInfo())
                .groupName("梓清")
                .enable(true)//是否启用swagger，如果为false则swagger不能再浏览器中访问
                .select()//通过select()方法配置扫描接口,RequestHandlerSelectors配置如何扫描接口
                //指定扫描的api包
                .apis(RequestHandlerSelectors.basePackage("com.zcy.fruitshop.controller"))
                //.paths(PathSelectors.ant("/sys/**"));//通过paths()方法配置扫描接口,PathSelectors配置如何扫描接口
                .build();
        /*
         * RequestHandlerSelectors除了设置basePackage外还可以配置其他方式扫描接口
         * any():扫描所有，项目中的所有接口都会被扫描到
         *
         * none():不扫描接口
         *
         * 通过方法上的注解扫描，如withMethodAnnotation(GetMapping.class)只扫描get请求
         * withMethodAnnotation(final Class<? extends Annotation> annotation):
         *
         * // 通过类上的注解扫描，如.withClassAnnotation(Controller.class)只扫描有controller注解的类中的接口
         * withClassAnnotation(final Class<? extends Annotation> annotation)
         *
         * basePackage(final String basePackage):根据包路径扫描接口
         * */
        /*
         * PathSelectors的可选值有以下几种
         * any()：任何请求都扫描
         * none()：任何请求都不扫描
         * regex(final String pathRegex)：通过正则表达式控制
         * ant(final String antPattern)：通过ant()控制
         * */
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("刘梓清", "", "liukang23113@163.com");
        return new ApiInfo(
                "梓清的SwaggerAPI文档",
                "不断学习，不断进步",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


}
