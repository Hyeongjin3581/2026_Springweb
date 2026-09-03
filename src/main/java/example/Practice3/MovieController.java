package example.Practice3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    private final MovieRepository movieRepository;
    @Autowired private MovieService movieService;

    MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    // 1. 영화 등록
    @PostMapping("/movie")
    public boolean 영화등록(@RequestBody MovieDto movieDto){
        return movieService.영화등록(movieDto);
    }
    // 2. 영화 전체 조회

    // 3. 영화 개별 조회

    // 4. 특정 영화 수정

    // 5. 특정 영화 삭제


} // class end
