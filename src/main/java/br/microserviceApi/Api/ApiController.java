package br.microserviceApi.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ApiController {

    Logger logger = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    ApiService apiService;

    @GetMapping("/get")
    public String get(@RequestParam(value = "ports") List ports) throws InterruptedException {
            return apiService.getService(ports);
    }

    @GetMapping("/getAsync")
    public String getAsync(@RequestParam(value = "ports") List ports) throws InterruptedException {
        return apiService.getService(ports);
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
