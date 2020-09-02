package br.microserviceApi;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication2 {

    public static void main(String[] args) {
        ElasticApmAttacher.attach();

        SpringApplication.run(ApiApplication2.class, args);
    }

}
