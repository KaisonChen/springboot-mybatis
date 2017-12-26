# Spring Boot + Mybatis
- 前后端分离
- maven项目管理
- spring-boot + Mybatis + Swagger2

API访问地址：http://localhost:8081/risksyun_server/swagger-ui.html#/

本项目为SpringBoot+Mybatis+Swagger2基础框架

### SpringBoot几个常用的注解
- @RestController和@Controller指定一个类，作为控制器的注解 ，@RestController相当于@Controller + @ResponseBody
- @RequestMapping方法级别的映射注解，这一个用过Spring MVC的小伙伴相信都很熟悉
- @Configuration类级别的注解，一般这个注解，我们用来标识main方法所在的类,完成元数据bean的初始化。
- @ComponentScan类级别的注解，自动扫描加载所有的Spring组件包括Bean注入，一般用在main方法所在的类上 
- @Autowired注解，一般结合@ComponentScan注解，来自动注入一个Service或Dao级别的Bean 
- @Component类级别注解，用来标识一个组件，比如我自定了一个filter，则需要此注解标识之后，Spring Boot才会正确识别。


### 常见swagger注解一览与使用
- @Api：修饰整个类，描述Controller的作用
- @ApiOperation：描述一个类的一个方法，或者说一个接口
- @ApiParam：单个参数描述
- @ApiModel：用对象来接收参数
- @ApiProperty：用对象接收参数时，描述对象的一个字段
- @ApiImplicitParams 用在方法上包含一组参数说明
- @ApiImplicitParam 用来注解来给方法入参增加说明

其它若干

- @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
- @ApiIgnore：使用该注解忽略这个API 

