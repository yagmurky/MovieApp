package com.yagmur.repository;

import com.yagmur.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovieCommentRepository extends JpaRepository<MovieComment, Long> {

    //Bir filme ait yorumları listeleyen metodu yazalım.
    List<MovieComment> findByMovieId(Long movieId);
    //Verilen tarih aralıklarında belirli bir filme yapılmış olan yorumları gösteren bir metot yazalım.
    List<MovieComment> findByMovieIdAndCommentDateBetween(Long movieId, Date startDate, Date endDate);
    //Yorum uzunluğu 20 karakterden büyük olan yorumları getiren bir metot yazalım.
    List<MovieComment> findByCommentLengthGreaterThan(int length);
}
