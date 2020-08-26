package br.microserviceApi.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @GetMapping("/get")
    public String get(@RequestParam(value = "ports") List ports) throws InterruptedException {
        System.out.println("Microservice - "+ ports.toString());

        Thread.sleep(4000L);

        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);
        logger.debug("Microservice - 8080" + nowTime.toString());

        if (!ports.isEmpty() && ports.get(0)!= null) {
            String port = ports.get(0).toString();
            ports.remove(0);

            final String uri =
                    port
                            + "?ports="
                            + ports.toString().
                            replace("[","").
                            replace("]","");

            System.out.println("Uri: " + uri);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> futureEntity = restTemplate.getForEntity(uri, String.class);

        }

        return new String("Microservice - 8080");
    }

    @GetMapping("/getAsync")
    public String getAsync(@RequestParam(value = "ports") List ports) throws InterruptedException {
        System.out.println("Microservice - "+ ports.toString());

        Thread.sleep(4000L);

        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);
        logger.debug("Microservice - 8080" + nowTime.toString());

        if (!ports.isEmpty() && ports.get(0)!= null) {
            String port = ports.get(0).toString();
            ports.remove(0);

            final String uri =
                    port
                            + "?ports="
                            + ports.toString().
                            replace("[","").
                            replace("]","");

            System.out.println("Uri: " + uri);

            AsyncRestTemplate restTemplate = new AsyncRestTemplate();
            ListenableFuture<ResponseEntity<String>> futureEntity = restTemplate.getForEntity(uri, String.class);

//            final DeferredResult<String> result = new DeferredResult<>();

//            futureEntity.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
//                @Override
//                public void onSuccess(ResponseEntity<String> result) {
//                    System.out.println(result.toString());
//                }
//
//                @Override
//                public void onFailure(Throwable ex) {
//                    result.setErrorResult(ex.getMessage());
//                }
//            });
        }

        return new String("Microservice - 8080");
    }

    @GetMapping("/error")
    public String error() throws Exception {
        throw new Exception();
    }

    @PostMapping("/close")
    public String close(@RequestParam(value = "name", defaultValue = "World") String name) {
        return name;
    }
}
