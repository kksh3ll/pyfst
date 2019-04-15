package top.jhana.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/tvservice")
public class TvServiceController {

    @GetMapping
    public Map sayHello() {

        Map<String, String> map = new HashMap<>();
        map.put("message", "hello world");
        return map;

    }

}
