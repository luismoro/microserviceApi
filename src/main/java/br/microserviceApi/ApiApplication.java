package br.microserviceApi;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        ElasticApmAttacher.attach();

        SpringApplication.run(ApiApplication.class, args);
    }

}
