package example.Practice3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/movie")
    public List<MovieDto>전체조회(){
        return movieService.전체조회();
    }

    // 3. 영화 개별 조회
    @GetMapping("/movie/detail")
    public MovieEntity 개별조회(@RequestParam(name="movieid")Integer movieid){
        return movieService.개별조회(movieid);
    }

    // 4. 특정영화 수정
    @PutMapping("/movie")
    public boolean 영화수정(@RequestBody MovieDto movieDto){
        return movieService.영화수정(movieDto);
    }

    // 5. 특정 영화 삭제
    @DeleteMapping("/movie")
    public boolean 영화삭제(@RequestParam(name="movieid")Integer movieid){
        return movieService.영화삭제(movieid);
    }

} // class end
