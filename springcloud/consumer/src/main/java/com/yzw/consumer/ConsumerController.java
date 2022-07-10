package com.yzw.consumer;

import com.api;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Reference(interfaceName = "com.api")
    api a;

    @GetMapping("/get/{id}")
    public String getId(@PathVariable("id") Integer id) {
        return a.getId(id);
    }

}
