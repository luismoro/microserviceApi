package br.microserviceApi.Api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class ApiController2 {

    @Autowired
    ApiService2 apiService2;

    @GetMapping("/get")
    public String get2(@RequestParam(value = "ports") List ports,
                       @RequestHeader Map<String, String> headers)
            throws InterruptedException {
        return apiService2.getService2(ports);
    }

    @GetMapping("/getAsync")
    public String getAsync2(@RequestParam(value = "ports") List ports) throws InterruptedException {
        return apiService2.getService2(ports);
    }

    @GetMapping("/error")
    public String error2() throws Exception {
        throw new Exception();
    }

    @PostMapping("/close")
    public String close2(@RequestParam(value = "name", defaultValue = "World") String name) {
        return name;
    }
}
