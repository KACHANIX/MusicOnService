package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Collection;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre parentGenre;

    @OneToMany(mappedBy = "parentGenre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Genre> genresById;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Collection<Soundtrack> soundtracksById;


    public Genre(String title, Genre genre) {
        this.title = title;
        this.parentGenre = genre;
    }

    public Genre() {

    }

    public Genre(String title) {
        this.title = title;
    }

    public Genre(Long id, String title, Genre parentGenre) {
        this.id = id;
        this.title = title;
        this.parentGenre = parentGenre;
    }
    public Genre(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getParentGenre() {
        return parentGenre;
    }

    public void setParentGenre(Genre genreByGenreId) {
        this.parentGenre = genreByGenreId;
    }

    public Collection<Genre> getGenresById() {
        return genresById;
    }

    public void setGenresById(Collection<Genre> genresById) {
        this.genresById = genresById;
    }

    public Collection<Soundtrack> getSoundtracksById() {
        return soundtracksById;
    }

    public void setSoundtracksById(Collection<Soundtrack> soundtracksById) {
        this.soundtracksById = soundtracksById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        if (id != null ? !id.equals(genre.id) : genre.id != null) return false;
        if (title != null ? !title.equals(genre.title) : genre.title != null) return false;
        if (parentGenre != null ? !parentGenre.equals(genre.parentGenre) : genre.parentGenre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (parentGenre != null ? parentGenre.hashCode() : 0);
        return result;
    }
}
