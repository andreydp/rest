package com.poletaiev;

/**
 * Created by andrey on 17.05.2021.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.poletaiev.*")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
