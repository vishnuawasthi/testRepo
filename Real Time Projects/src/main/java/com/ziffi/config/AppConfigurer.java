/**
 * 
 */
package com.ziffi.config;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.ziffi.util.ZiffiGenericUtils;

/**
 * @author vawasthi
 * 
 */
@Configuration
@EnableWebMvc
@Import(value = HibernateConfigurer.class)
@PropertySources({@PropertySource("classpath:database.properties"),@PropertySource("classpath:messages.properties")})
@ComponentScan(basePackages = {"com.ziffi.controller", "com.ziffi.config", "com.ziffi.dao", "com.ziffi.dao.impl", "com.ziffi.service",
		"com.ziffi.service.impl","com.ziffi.rest","com.ziffi.util","com.ziffi.rest.provider"})
public class AppConfigurer extends WebMvcConfigurerAdapter {
	private static final Logger logger = Logger.getLogger(AppConfigurer.class);

	private static final Integer RESOURCE_CACHE_PERIOD_SECONDS = new Integer(10);
	@Autowired
	@Qualifier(value = "ziffiGenericUtils")
	private ZiffiGenericUtils ziffiGenericUtils;

	@Bean
	public InternalResourceViewResolver viewResolver() {
		ziffiGenericUtils.doLogging(logger, "viewResolver", true);
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
		internalResourceViewResolver.setSuffix(".jsp");
		internalResourceViewResolver.setViewClass(JstlView.class);
		ziffiGenericUtils.doLogging(logger, "viewResolver", false);
		return internalResourceViewResolver;
	}

	@Bean(name = "ziffiGenericUtils")
	public ZiffiGenericUtils getZiffiGenericUtils() {
		return new ZiffiGenericUtils();
	}
	/**
	 * This Bean configuration allow us to upload multipart files.
	 * @return MultipartResolver
	 */
	@Bean
	public  MultipartResolver  multipartResolver(){
		CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
		commonsMultipartResolver.setMaxUploadSize(86246223);
		return commonsMultipartResolver;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RequestFilter());
	}

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
		registry.addResourceHandler("/script/**").addResourceLocations("/script/");
		registry.addResourceHandler("/images/**").addResourceLocations("/images/");
		registry.addResourceHandler("/uploadedImages/**").addResourceLocations("/uploadedImages/");
		registry.addResourceHandler("/videos/**").addResourceLocations("/videos/");
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	/**
	 * Resource bundle handler to read the message and their values form properties files.
	 * @see  org.springframework.context.support.ResourceBundleMessageSource.
	 * @return
	 */
	@Bean(name = "messageSource")
	public MessageSource getResourceBundleHandler(){
		ResourceBundleMessageSource resourceBundleMessageSource  = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("messages");
		return resourceBundleMessageSource;
	}
	
	@Bean(name = "validator")
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(getResourceBundleHandler());
		return localValidatorFactoryBean;
	}
	/**
	 * Property place holder for the values which we inject into data base configuration. like  @Value("${mysql.driverClass}")
	 * @return PropertyPlaceholderConfigurer
	 */
	/*@Bean
	public PropertySourcesPlaceholderConfigurer propertyPlaceHolder(){
		//PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		//propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("database.properties"));
		return new PropertySourcesPlaceholderConfigurer();
	//return propertySourcesPlaceholderConfigurer;
	}
	*/
	
	/*@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		//PropertySourcesPlaceholderConfigurer test  = new PropertySourcesPlaceholderConfigurer();
		return new PropertySourcesPlaceholderConfigurer();
	}*/

	@Bean(name="objectMapper")
	public ObjectMapper getObejctMapper(){
		return new ObjectMapper();
	}
	
	@Bean
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	
}
