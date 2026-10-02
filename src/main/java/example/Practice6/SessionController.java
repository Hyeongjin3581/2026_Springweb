package example.Practice6;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/session")
public class SessionController {

    // [1] 등록
    @GetMapping("/add")
    public String save(@RequestParam(value = "data", required = false) String data, HttpSession session){
        if(data == null || data.isBlank()){
            return "세션저장실패";
        }

        @SuppressWarnings("unchecked")
        List<String> dataList = (List<String>) session.getAttribute("dataList");
        if(dataList == null){
            dataList = new ArrayList<>();
        }
        dataList.add(data);
        session.setAttribute("dataList", dataList);
        return session.getAttribute("dataList") != null ? "세션저장성공" : "세션저장실패";
    }


    // [2] 전체조회
    @GetMapping("/all")
    public List<String> findAll(HttpSession session) {
        @SuppressWarnings("unchecked")
        List<String> dataList = (List<String>) session.getAttribute("dataList");
        return dataList == null ? List.of() : dataList;
    }
}
