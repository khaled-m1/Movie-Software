package com.example.moviesoftware.model;

import jdk.jfr.Timestamp;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Movie {
    @Id
    @Column(nullable = false,unique = true)
    @NotNull(message = "ID Cannot be null")
    @Min(value = 3,message = "ID Length more than 3")
    private Integer id;
    @Column(nullable = false,unique = true)
    @NotEmpty(message = "Name Cannot be null")
    @Size(min = 2,message = "Name Length more than 2")
    private String name;
    @Column(nullable = false)
    @NotEmpty(message = "Genre Cannot be null")
    @Pattern(regexp = "(Drama|Action|Comedy)")
    private String genre;
    @Column(nullable = false)
    @NotNull(message = "rating Cannot be null")
    @Positive(message = "rating Has to be a Positive number")
    @Min(value = 1,message = "rating must be between 1 - 5")
    @Max(value = 5,message = "rating must be between 1 - 5")
    private Integer rating;
    @Column(nullable = false)
    @NotNull(message = "duration Cannot be null")
    @Positive(message = "duration Has to be a Positive number")
    @Timestamp
    @Digits(integer = 60,fraction = 0,message = "I must be more than 60!")
    private Integer duration;
    @Column(nullable = false)
    private String launchDate;
    public Movie() {
    }
    public Movie(Integer id, String name, String genre, Integer rating, Integer duration, String launchDate) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
        this.launchDate = launchDate;
    }
}
