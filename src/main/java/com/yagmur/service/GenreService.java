package com.yagmur.service;

import com.yagmur.entity.Genre;
import com.yagmur.repository.GenreRepository;
import com.yagmur.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GenreService implements ICrudService<Genre, Long> {
    private final GenreRepository genreRepository;

    @Override
    public Genre save(Genre entity) {
        return null;
    }

    @Override
    public Genre update(Genre entity) {
        return null;
    }

    @Override
    public Iterable<Genre> saveAll(Iterable<Genre> entities) {
        return null;
    }

    @Override
    public List<Genre> findAll() {
        return null;
    }

    @Override
    public Optional<Genre> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Genre deleteById(Long aLong) {
        return null;
    }
}
