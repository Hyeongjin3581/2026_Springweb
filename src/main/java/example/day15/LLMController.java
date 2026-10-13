package example.day15;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class LLMController {

    // 1. 
    private final LLMService LLMService;

    @GetMapping("/chat1")
    public String chat1(@RequestParam("prompt") String prompt){
        return LLMService.chat1(prompt);
    }

    @GetMapping("/chat2")
    public String chat2(){
        return LLMService.chat2();
    }

    @GetMapping("/chat3")
    public String chat3(@RequestParam("topic") String topic){
    return LLMService.chat3(topic);
    }
}
