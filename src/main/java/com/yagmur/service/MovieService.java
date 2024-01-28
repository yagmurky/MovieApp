package com.yagmur.service;

import com.yagmur.entity.Movie;
import com.yagmur.repository.MovieRepository;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService implements ICrudService<Movie, Long> {

    private final MovieRepository movieRepository;

    @Override
    public Movie save(Movie entity) {
        return null;
    }

    @Override
    public Movie update(Movie entity) {
        return null;
    }

    @Override
    public Iterable<Movie> saveAll(Iterable<Movie> entities) {
        return null;
    }

    @Override
    public List<Movie> findAll() {
        return null;
    }

    @Override
    public Optional<Movie> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Movie deleteById(Long aLong) {
        return null;
    }
}
