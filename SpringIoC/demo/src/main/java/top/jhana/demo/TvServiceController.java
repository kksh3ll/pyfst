package top.jhana.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/tvservice")
public class TvServiceController {

    private static final Log log = LogFactory.getLog(TvServiceController.class);

//    @GetMapping
//    public Map sayHello() {
//
//        Map<String, String> map = new HashMap<>();
//        map.put("message", "hello world");
//        return map;
//    }

    @GetMapping
    public List<TvServiceDto> getAll() {

        if (log.isTraceEnabled()) {
            log.trace("getAll()被调用了！");
        }
        List<TvServiceDto> list = new ArrayList<>();
        list.add(createWestWorld());
        list.add(createPoi());
        return list;
    }

    public TvServiceDto createWestWorld() {
        Calendar cal = Calendar.getInstance();
        cal.set(2011, Calendar.OCTOBER, 22, 0 , 0, 0);
        return new TvServiceDto(101, "West world", 2, cal.getTime());
    }

    public TvServiceDto createPoi() {
        Calendar cal = Calendar.getInstance();
        cal.set(2011, Calendar.SEPTEMBER, 30, 0, 0, 0);
        return new TvServiceDto(102, "Person of Intrest", 1, cal.getTime());
    }

}
