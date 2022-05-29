package com.example.moviesoftware.service;

import com.example.moviesoftware.model.Movie;
import com.example.moviesoftware.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }
    public boolean addMovies(Movie movie) {
         movieRepository.save(movie);
         return true;
    }
    public boolean editMovies(Integer id, Movie movie) {
        Movie EditMovie =movieRepository.findById(id).get();
        EditMovie.setName(movie.getName());
        EditMovie.setDuration(movie.getDuration());
        EditMovie.setGenre(movie.getGenre());
        EditMovie.setRating(movie.getRating());
        EditMovie.setLaunchDate(movie.getLaunchDate());
        movieRepository.save(movie);
        return true;
    }
    public void removeMovies(Integer id) {
        movieRepository.deleteById(id);
    }
}
