package example.Practice3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired private MovieRepository movieRepository;

    public boolean 영화등록(MovieDto movieDto){
        // 1. dto --> Entity 변환함수 : toEntity함수
        MovieEntity movieEntity = movieDto.toEntity();
        // 2. entity save 저장
        MovieEntity savedEntity = movieRepository.save(movieEntity);
        if(savedEntity.getMovieid()>=1){return true;}
        return false;
    }


} // class end
