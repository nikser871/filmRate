package com.example.filmorate.validation;

import com.example.filmorate.exception.FilmException;
import com.example.filmorate.model.Film;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilmValidationTest {

    private static final Film rightFilm = new Film(1, "Sun", "Hello!",
            LocalDate.of(2000, 12, 12), 120, List.of(1, 2), 1);

    private static final Film wrongFilm = new Film(1, null, "DKJFDJFKDJKFDFKSDFPDJKDJSKF" +
            "DKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJKDKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJK" +
            "DKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJKDKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJK" +
            "DKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJKDKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJK" +
            "DKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJKDKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJK" +
            "DKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJKDKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJK" +
            "DKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJKDKJFDJFKDJKFDFKSDFPDJKDJSKFJSDFJKSDJFKDSKFJSJKJSDFJKSDJFKDSKFJSJK",
            LocalDate.of(1800, 12, 12), -1, List.of(1, 2), 1);

    @Test
    void checkName() {
        FilmException thrown = assertThrows(FilmException.class, () -> FilmValidation.checkName(wrongFilm.getName()));
        assertTrue(thrown.getMessage().contains("Name is null"));

        assertDoesNotThrow(() -> FilmValidation.checkName(rightFilm.getName()));
    }

    @Test
    void checkDescription() {
        FilmException thrown = assertThrows(FilmException.class, () ->
                FilmValidation.checkDescription(wrongFilm.getDescription()));
        assertTrue(thrown.getMessage().contains("Description contains symbols more than 200"));

        assertDoesNotThrow(() -> FilmValidation.checkDescription(rightFilm.getDescription()));
    }

    @Test
    void checkDataRelease() {
        FilmException thrown = assertThrows(FilmException.class, () ->
                FilmValidation.checkDataRelease(wrongFilm.getReleaseDate()));
        assertTrue(thrown.getMessage().contains("Date of release can't be before 1895.12.28"));

        assertDoesNotThrow(() -> FilmValidation.checkDataRelease(rightFilm.getReleaseDate()));
    }

    @Test
    void checkDuration() {
        FilmException thrown = assertThrows(FilmException.class, () ->
                FilmValidation.checkDuration(wrongFilm.getDuration()));
        assertTrue(thrown.getMessage().contains("Duration can't be negative"));

        assertDoesNotThrow(() -> FilmValidation.checkDuration(rightFilm.getDuration()));
    }
}