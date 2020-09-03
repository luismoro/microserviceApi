package br.microserviceApi.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiController3 {


    @Autowired
    ApiService3 apiService3;

    @GetMapping("/get")
    public String get3(@RequestParam(value = "ports") List ports,
                       @RequestHeader HttpHeaders headers)
            throws InterruptedException {

            return apiService3.getService3(ports, headers);
    }

    @GetMapping("/getAsync")
    public String getAsync3(@RequestParam(value = "ports") List ports,
                            @RequestHeader HttpHeaders headers)
            throws InterruptedException {
        return apiService3.getService3(ports, headers);
    }

    @GetMapping("/error")
    public String error3() throws Exception {
        throw new Exception();
    }

    @PostMapping("/close")
    public String close3(@RequestParam(value = "name", defaultValue = "World") String name) {
        return name;
    }
}
