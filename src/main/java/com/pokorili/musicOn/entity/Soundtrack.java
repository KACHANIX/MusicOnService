package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Soundtrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id", referencedColumnName = "id", nullable = false)
    private Visitor visitor;

    @Basic
    @Column(name = "author", nullable = false, length = -1)
    private String author;

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", referencedColumnName = "id", nullable = false)
    private Genre genre;

    @Basic
    @Column(name = "link", nullable = false, length = -1, unique =  true)
    private String link;

    @Basic
    @Column(name = "creating_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private Timestamp creatingDate;

    @OneToMany(mappedBy = "soundtrack")
    @JsonIgnore
    private Collection<History> historiesById;

    @OneToMany(mappedBy = "soundtrack")
    @JsonIgnore
    private Collection<PlaylistSoundtrack> playlistSoundtracksById;

    @OneToMany(mappedBy = "soundtrack")
    @JsonIgnore
    private Collection<SoundtrackRate> soundtrackRatesById;

    public Soundtrack() {}

    public Soundtrack(Visitor visitor, String author, String title, Genre genre, String link) {
        this.visitor = visitor;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genreId) {
        this.genre = genreId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Timestamp getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Timestamp creatingDate) {
        this.creatingDate = creatingDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Soundtrack that = (Soundtrack) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (visitor != null ? !visitor.equals(that.visitor) : that.visitor != null) return false;
        if (author != null ? !author.equals(that.author) : that.author != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;
        if (creatingDate != null ? !creatingDate.equals(that.creatingDate) : that.creatingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (visitor != null ? visitor.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (creatingDate != null ? creatingDate.hashCode() : 0);
        return result;
    }

    public Collection<History> getHistoriesById() {
        return historiesById;
    }

    public void setHistoriesById(Collection<History> historiesById) {
        this.historiesById = historiesById;
    }

    public Collection<PlaylistSoundtrack> getPlaylistSoundtracksById() {
        return playlistSoundtracksById;
    }

    public void setPlaylistSoundtracksById(Collection<PlaylistSoundtrack> playlistSoundtracksById) {
        this.playlistSoundtracksById = playlistSoundtracksById;
    }

    public Collection<SoundtrackRate> getSoundtrackRatesById() {
        return soundtrackRatesById;
    }

    public void setSoundtrackRatesById(Collection<SoundtrackRate> soundtrackRatesById) {
        this.soundtrackRatesById = soundtrackRatesById;
    }
}
