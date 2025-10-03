package fca.cafeteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "fca.cafeteria")
public class CafeteriaApplication {
    public static void main(String[] args) {
        SpringApplication.run(CafeteriaApplication.class, args);
    }
}