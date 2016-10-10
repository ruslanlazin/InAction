package ua.pp.lazin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class InActionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InActionApplication.class, args);
	}
}
