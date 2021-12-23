package cl.teamweichafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MeasuresServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeasuresServiceApplication.class, args);
	}

}
