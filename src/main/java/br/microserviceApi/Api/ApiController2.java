package br.microserviceApi.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiController2 {

    @Autowired
    ApiService2 apiService2;

    @GetMapping("/get")
    public String get2(@RequestParam(value = "ports") List ports,
                       @RequestHeader HttpHeaders headers)
            throws InterruptedException {
        return apiService2.getService2(ports, headers);
    }

    @GetMapping("/getAsync")
    public String getAsync2(@RequestParam(value = "ports") List ports,
                            @RequestHeader HttpHeaders headers)
            throws InterruptedException {
        return apiService2.getService2(ports, headers);
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
