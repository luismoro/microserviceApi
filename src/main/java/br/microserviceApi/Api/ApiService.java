package br.microserviceApi.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApiService {

    Logger logger = LoggerFactory.getLogger(ApiService.class);

    public String getService(List ports) throws InterruptedException {
        System.out.println("Microservice - "+ ports.toString());

        Thread.sleep(4000L);

        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);
        logger.debug("Microservice - 8080" + nowTime.toString());

        RestTemplate restTemplate = new RestTemplate();
        String url = getUrl(ports);
        if (url != null)
            return restTemplate.getForEntity(url, String.class).getBody();
        else
            return "";
    }

    public String getAsyncService(List ports) throws InterruptedException {
        System.out.println("Microservice - "+ ports.toString());

        Thread.sleep(4000L);

        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);
        logger.debug("Microservice - 8080" + nowTime.toString());

        AsyncRestTemplate restTemplate = new AsyncRestTemplate();
        ListenableFuture<ResponseEntity<String>> futureEntity = restTemplate.getForEntity(getUrl(ports), String.class);

//            final DeferredResult<String> result = new DeferredResult<>();
//
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

        return "Microservice End getAsyncService";
    }

        private String getUrl(List ports) {
            String uri = null;

            if (!ports.isEmpty() && ports.get(0)!= null) {
                String port = ports.get(0).toString();
                ports.remove(0);

                uri =
                        port
                                + "?ports="
                                + ports.toString().
                                replace("[", "").
                                replace("]", "");

                System.out.println("Uri: " + uri);
            }
        return uri;
    }

}
