package top.jhana.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/tvservice")
public class TvServiceController {

    private static final Log log = LogFactory.getLog(TvServiceController.class);

    @GetMapping("/hello")
    public Map sayHello() {

        Map<String, String> map = new HashMap<>();
        map.put("message", "hello world");
        return map;
    }

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

    @GetMapping("/{id}")
    public TvServiceDto getOne(@PathVariable int id) {
        if (log.isTraceEnabled()) {
            log.trace("getOne()被调用了！id=" + id);
        }
        if (id == 101) {
            return createWestWorld();
        } else if (id == 102) {
            return createPoi();
        } else {
            throw new ResourceNotFoundException("资源找不到！");
        }
    }

    @PostMapping
    public TvServiceDto insertOne(@Valid @RequestBody TvServiceDto tvServiceDto) {
        if (log.isTraceEnabled()) {
            log.trace("insertOne()被调用了！");
        }

        tvServiceDto.setId(999);
        return tvServiceDto;
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
