package pl.medrekkaszuba.ingester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients(basePackages = {"pl.medrekkaszuba.ingester.service"})
public class IngesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(IngesterApplication.class, args);
	}

}
