package com.yagmur.service;

import com.yagmur.entity.MovieComment;
import com.yagmur.repository.MovieCommentRepository;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieCommentService implements ICrudService <MovieComment,Long> {

    private final MovieCommentRepository movieCommentRepository;
    @Override
    public MovieComment save(MovieComment entity) {
        return null;
    }

    @Override
    public MovieComment update(MovieComment entity) {
        return null;
    }

    @Override
    public Iterable<MovieComment> saveAll(Iterable<MovieComment> entities) {
        return null;
    }

    @Override
    public List<MovieComment> findAll() {
        return null;
    }

    @Override
    public Optional<MovieComment> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public MovieComment deleteById(Long aLong) {
        return null;
    }

    //Bir filme ait yorumları listeleyen metodu yazalım.
    public List<MovieComment> findByMovieId(Long movieId){
        return movieCommentRepository.findByMovieId(movieId);
    }
    //Verilen tarih aralıklarında belirli bir filme yapılmış olan yorumları gösteren bir metot yazalım.
    public List<MovieComment> findByMovieIdAndCommentDateBetween(Long movieId, Date startDate, Date endDate){
        return movieCommentRepository.findByMovieIdAndDateBetween(movieId,startDate,endDate);
    }
    //Yorum uzunluğu 20 karakterden büyük olan yorumları getiren bir metot yazalım.
    public List<MovieComment> findByCommentLengthGreaterThan(int length){
        return movieCommentRepository.findByContentLengthGreaterThan(length);
    }
}
