/**
 * 
 */
package com.ziffi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.ziffi.entity.BaseEntity;
import com.ziffi.entity.Media;
import com.ziffi.entity.Profile;
import com.ziffi.entity.Task;

/**
 * @author vawasthi
 * 
 */
@Configuration
public class HibernateConfigurer {
	/*@Value("${get.mysql.driver.class}")
	private String driverClass;
	@Value("${mysql.database.url}")
	private String url;
	@Value("${mysql.database.username}")
	private String userName;
	@Value("${mysql.database.password}")
	private String password;*/
	/**
	 * We can read the propeties file value by using Environment also.
	 */
	 @Autowired
	 private Environment environment;

	/**
	 * Spring provided data source for test environment 
	 * @see org.springframework.jdbc.datasource.DriverManagerDataSource
	 * @return
	 */
	@Bean(name = "dataSource")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ziffi");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	/**
	 * Apache commons DBCP data source configuration.
	 * @see org.apache.commons.dbcp2.BasicDataSource
	 * @return
	 */
	/*@Bean
	public BasicDataSource getBasicDataSource(){
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driverClass);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(userName);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}*/
	
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		//String [] annotatedPackage={"com.ziffi.entity"};
		//localSessionFactoryBean.setAnnotatedPackages(annotatedPackage);
		Class [] annotatedClasses ={BaseEntity.class,Profile.class,Media.class,Task.class};
		localSessionFactoryBean.setAnnotatedClasses(annotatedClasses);
		localSessionFactoryBean.setDataSource(getDataSource());
		return localSessionFactoryBean;
	}

	
	/*@Bean(name = "sessionFactory")
	public AnnotationSessionFactoryBean getSessionFactory() {
		AnnotationSessionFactoryBean annotationSessionFactoryBean = new AnnotationSessionFactoryBean();
		//localSessionFactoryBean.setAnnotatedPackages("com.ziffi.entity");
		//Class [] annotatedClasses ={BaseEntity.class};
		//annotationSessionFactoryBean.setAnnotatedClasses(annotatedClasses);
		annotationSessionFactoryBean.setPackagesToScan("com.ziffi.entity");
		annotationSessionFactoryBean.setDataSource(getDataSource());
		return annotationSessionFactoryBean;
	}*/
	
	
	
	
}
