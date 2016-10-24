package ua.pp.lazin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/home").setViewName("home");
//		registry.addViewController("/").setViewName("redirect:/login");
//		registry.addViewController("/hello").setViewName("hello");
//		registry.addViewController("/login").setViewName("login");
//		registry.addViewController("/403").setViewName("403");
	}

	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.postgresql.Driver");
		driverManagerDataSource.setUrl("jdbc:postgresql://192.168.3.99/inaction");
		driverManagerDataSource.setUsername("postgres");
		driverManagerDataSource.setPassword("asdfghjkl");
		return driverManagerDataSource;
	}

	@Bean(name = "entityManagerFactory")
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("ua.pp.lazin.inaction");
	}
}