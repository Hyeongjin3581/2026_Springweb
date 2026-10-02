package example.Practice6;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/redis")
@RequiredArgsConstructor 
public class RedisController {
    private final StringRedisTemplate redisTemplate;



    // [2] 레디스 저장
    @GetMapping("/add")
    public String save(@RequestParam("data")String data){
        redisTemplate.opsForValue().set(data, data);
        return "레디스 저장 성공";
    }


    // [2] 레디스 전체조회
    @GetMapping ("/all")
    public List<String> findAll(){
        Set<String> keys = redisTemplate.keys("*");
        List<String> list = new ArrayList<>();
        for( String key : keys ){
            String data = redisTemplate.opsForValue().get(key);
            list.add(data);
        }
        return list;
    }
}
