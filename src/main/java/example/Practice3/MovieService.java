package example.Practice3;

import example.Practice3.AppStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {
    @Autowired private MovieRepository movieRepository;

    // 1. 영화 등록
    public boolean 영화등록(MovieDto movieDto){
        // 1. dto --> Entity 변환함수 : toEntity함수
        MovieEntity movieEntity = movieDto.toEntity();
        // 2. entity save 저장
        MovieEntity savedEntity = movieRepository.save(movieEntity);
        if(savedEntity.getMovieid()>=1){return true;}
        return false;
    }

    // 2. 전체 조회
    public List<MovieDto>전체조회(){
        // 1. 전체 엔티티 조회
        List<MovieEntity> entities = movieRepository.findAll();

        // 2. 전체 엔티티 -> DTO로 전환
        // 2-1 . 빈 리스트 생성
        List<MovieDto> list  = new ArrayList<>();
        // 엔티티를 반복하여 DTO로 변환 및 새로운 리스트에 저장
        entities.forEach(entity -> {
            list.add(MovieDto.from(entity));
        });
        return list;
    }

    // 3. 개별 조회
    public MovieEntity 개별조회(Integer movieid){
        Optional<MovieEntity> optional = movieRepository.findById(movieid);

        if(optional.isPresent()){return optional.get();}
        return null; 
    }

    // 4. 영화수정
    @Transactional
    public boolean 영화수정(MovieDto movieDto){
        // 1. 수정할 엔티티(pk) 를 찾는다
        Optional<MovieEntity> optional = movieRepository.findById(movieDto.getMovieid());
        // 2. 찾은 엔티티가 존재한다. 
        if(optional.isPresent()){
            // 3. 엔티티를 꺼낸다
            MovieEntity entity  = optional.get();
            // 4 . setter 메소드를 이용하여 수정
            entity.setTitle(movieDto.getTitle());
            entity.setDirector(movieDto.getDirector());
            entity.setReleasedate(movieDto.getReleasedate());
            entity.setRating(movieDto.getRating());
            return true;
        }
        return false;
    }

     // 영화삭제
     @Transactional
     public boolean 영화삭제(Integer movieid){
        movieRepository.deleteById(movieid);
        return true;
     }



} // class end
