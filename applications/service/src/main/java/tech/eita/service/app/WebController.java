package tech.eita.service.app;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("/{name}")
    @Cacheable(value = "hello-name")
    public String getValue(@PathVariable String name) {
        return "Hello" + name;
    }
}
