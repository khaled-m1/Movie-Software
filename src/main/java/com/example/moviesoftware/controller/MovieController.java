package com.example.moviesoftware.controller;
import com.example.moviesoftware.model.Movie;
import com.example.moviesoftware.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
@RestController
@RequestMapping("api/v1/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }
    @GetMapping
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }
    @PostMapping
    public ResponseEntity<Api> addMovies(@RequestBody @Valid Movie movie, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isrequestmovie = movieService.addMovies(movie);
        if (!isrequestmovie){
            return ResponseEntity.status(400).body(new Api("Your request not Added :(",400));
        }
        return ResponseEntity.status(201).body(new Api("Movies Added! :)",201));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Api> editMovies(@RequestBody @Valid Movie movie,@PathVariable Integer id, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(),400));
        }
        boolean isrequestEdit = movieService.editMovies(id,movie);
        if (!isrequestEdit){
            return ResponseEntity.status(400).body(new Api("Your request not Edited :(",400));
        }
        return ResponseEntity.status(201).body(new Api("Movies Edited! :)",201));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity removeMovies(@PathVariable Integer id){
        movieService.removeMovies(id);
        return ResponseEntity.status(201).body(new Api("Movies Removed! :)",201));
    }
}
