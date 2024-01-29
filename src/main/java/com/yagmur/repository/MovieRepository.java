package com.yagmur.repository;

import com.yagmur.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    //Belli bir rating üzerindeki Movie'leri getiren bir metot yazalım
    List<Movie> findByRatingGreaterThan(double rating);

    //Girilen tarihten önce çıkmış filmleri listeleyen bir metot yazalım. (Tarihi dışarıdan string olarak alalım. formatımız (dd-MM-yyyy) -> gün-ay-yıl şeklinde olsun.
    List<Movie> findByReleaseDateBefore(Date releaseDate);

    //Filmler içerisinde puanları 7, 8, 9 olan filmleri getiren bir metot yazalım.
    List<Movie> findByRatingIn(List<Double> ratings);
}



