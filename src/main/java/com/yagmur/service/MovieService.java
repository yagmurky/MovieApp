package com.yagmur.service;

import com.yagmur.entity.Movie;
import com.yagmur.entity.User;
import com.yagmur.repository.MovieRepository;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements ICrudService<Movie, Long> {

    private final MovieRepository movieRepository;

    @Override
    public Movie save(Movie movie) {
        Movie movieToBeSaved = Movie.builder()
                .name(movie.getName())
                .rating(movie.getRating())
                .comments(movie.getComments())
                .country(movie.getCountry())
                .url(movie.getUrl())
                .image(movie.getImage())
                .language(movie.getLanguage())
                .premiered(movie.getPremiered())
                .summary(movie.getSummary())
                .genres(movie.getGenres())
                .build();
        return movieRepository.save(movieToBeSaved);
    }

    @Override
    public Movie update(Movie entity) {
      return movieRepository.save(entity);
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> entities) {
        return null;
    }

    @Override
    public List<Movie> findAll() {
        List<Movie> movieList = movieRepository.findAll();
        if (movieList.isEmpty()) {
            throw new NullPointerException("Movie list is empty!");
        }
        return movieList;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return movieRepository.findById(aLong);

    }

    @Override
    public Movie deleteById(Long aLong) {
        return null;
    }

    //Belli bir rating üzerindeki Movie'leri getiren bir metot yazalım
    public List<Movie> findByRatingGreaterThan(double rating){
        return movieRepository.findByRatingGreaterThan(rating);
    }

    //Girilen tarihten önce çıkmış filmleri listeleyen bir metot yazalım. (Tarihi dışarıdan string olarak alalım. formatımız (dd-MM-yyyy) -> gün-ay-yıl şeklinde olsun.

    public List<Movie> findByPremieredBefore(String dateString) throws Exception {
        //local date e çevir
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate parsedDate = LocalDate.parse(dateString, formatter);
        // Veritabanındaki premiered alanını sorgula
        return movieRepository.findByPremieredBefore(parsedDate);
    }

    //Filmler içerisinde puanları 7, 8, 9 olan filmleri getiren bir metot yazalım.
    public List<Movie> findByRatingIn(List<Double> ratings){
        return movieRepository.findByRatingIn(ratings);
    }
}
