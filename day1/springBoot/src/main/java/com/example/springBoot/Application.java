package com.example.springBoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@Slf4j
@SpringBootApplication
//@OpenAPIDefinition(info = @Info( title ="${swagger.title}" , version = "${swagger.version}", description = "${swagger.description}"),security = { @SecurityRequirement(name = "api_key")})
public class Application {
	public static void main(String[] args) {
			SpringApplication.run(Application.class, args);
	}
}
