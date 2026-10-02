package example.Practice6;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/cookie")
public class CookieController {
    private final ObjectMapper objectMapper = new ObjectMapper();

    // [1] 쿠키 등록
    @GetMapping("/add")
    public String save(
        @RequestParam("data") String data,
        @CookieValue(value = "COOKIE_DATA", required = false) String cookieData,
        HttpServletResponse response )throws Exception{
        List<String> list = (cookieData == null) ? new ArrayList<>() : objectMapper.readValue(cookieData,  new TypeReference<List<String>>() {});
        list.add(data);

        String json = objectMapper.writeValueAsString(list);
        ResponseCookie cookie = ResponseCookie.from("COOKIE_DATA", URLEncoder.encode(json, StandardCharsets.UTF_8))
            .path("/")
            .build();
        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
        return "쿠키저장성공";
    }


    // [2] 쿠키 조회
    @GetMapping("/all")
    public List<String> getAllCookieData(@CookieValue(name = "COOKIE_DATA", required = false) String cookieData) throws Exception {
        if (cookieData == null) {
            return List.of();
        }
        return objectMapper.readValue(cookieData,  new TypeReference<List<String>>() {} );
    }
}
