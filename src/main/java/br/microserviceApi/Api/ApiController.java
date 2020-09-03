package br.microserviceApi.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    ApiService apiService;

    @GetMapping("/get")
    public String get(@RequestParam(value = "ports") List ports,
                      @RequestHeader HttpHeaders headers)
            throws InterruptedException {

            return apiService.getService(ports, headers);
    }

    @GetMapping("/getAsync")
    public String getAsync(@RequestParam(value = "ports") List ports,
                           @RequestHeader HttpHeaders headers)
            throws InterruptedException {

        return apiService.getService(ports, headers);
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
