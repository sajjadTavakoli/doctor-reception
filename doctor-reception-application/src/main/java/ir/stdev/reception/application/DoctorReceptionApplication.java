package ir.stdev.reception.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "ir.stdev.reception")
@EntityScan(basePackages = "ir.stdev.reception.persistence")
@EnableJpaRepositories(basePackages = "ir.stdev.reception.persistence")
public class DoctorReceptionApplication {
    public static void main(String[] args) {
        SpringApplication.run(DoctorReceptionApplication.class,args);
    }

}
