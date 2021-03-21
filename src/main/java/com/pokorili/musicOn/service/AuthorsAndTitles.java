package com.pokorili.musicOn.service;

import com.pokorili.musicOn.entity.Genre;
import org.springframework.web.multipart.MultipartFile;

public class AuthorsAndTitles {
    private String[] authors ;
    private String[] titles;
    private Long[] genreIds;
    public AuthorsAndTitles(String[] authors, String[] titles, MultipartFile[] files){
        this.authors = authors;
        this.titles = titles;
    }
    public AuthorsAndTitles(){

    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getTitles() {
        return titles;
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    public Long[] getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(Long[] genreIds) {
        this.genreIds = genreIds;
    }
}
