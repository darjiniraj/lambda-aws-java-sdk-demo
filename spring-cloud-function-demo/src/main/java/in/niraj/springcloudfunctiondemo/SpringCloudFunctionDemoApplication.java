package in.niraj.springcloudfunctiondemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.function.Function;

@SpringBootApplication
public class SpringCloudFunctionDemoApplication {

	@Bean
	public Function<String, String> uppercase() {
		return String::toUpperCase;
	}

	@Bean
	public Function<String, String> lowercase() {
		return String::toLowerCase;
	}

	@Bean
	public Function<String, String> reverseString() {
		return value -> new StringBuilder(value).reverse().toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunctionDemoApplication.class, args);
	}

}
