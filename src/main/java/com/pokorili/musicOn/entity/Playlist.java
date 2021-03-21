package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Basic
    @Column(name = "title", nullable = false, length = -1)
    private String title;

    @Basic
    @Column(name = "description", length = -1)
    private String description;

    @Basic
    @Column(name = "creating_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false)
    private Timestamp creatingDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id", referencedColumnName = "id", nullable = false)
    private Visitor visitor;

    @OneToMany(mappedBy = "playlist")
    @JsonIgnore
    private Collection<PlaylistRate> playlistRatesById;

    @OneToMany(mappedBy = "playlist")
    @JsonIgnore
    private Collection<PlaylistSoundtrack> playlistSoundtracksById;

    public Playlist() {}

    public Playlist(String title, String description, Visitor visitor) {
        this.title = title;
        this.description = description;
        this.visitor = visitor;
    }

    public Playlist(String title, Visitor visitor) {
        this.title = title;
        this.visitor = visitor;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Timestamp creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitorId(Visitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Playlist playlist = (Playlist) o;

        if (id != null ? !id.equals(playlist.id) : playlist.id != null) return false;
        if (title != null ? !title.equals(playlist.title) : playlist.title != null) return false;
        if (description != null ? !description.equals(playlist.description) : playlist.description != null)
            return false;
        if (creatingDate != null ? !creatingDate.equals(playlist.creatingDate) : playlist.creatingDate != null)
            return false;
        if (visitor != null ? !visitor.equals(playlist.visitor) : playlist.visitor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (creatingDate != null ? creatingDate.hashCode() : 0);
        result = 31 * result + (visitor != null ? visitor.hashCode() : 0);
        return result;
    }


    public Collection<PlaylistRate> getPlaylistRatesById() {
        return playlistRatesById;
    }

    public void setPlaylistRatesById(Collection<PlaylistRate> playlistRatesById) {
        this.playlistRatesById = playlistRatesById;
    }

    public Collection<PlaylistSoundtrack> getPlaylistSoundtracksById() {
        return playlistSoundtracksById;
    }

    public void setPlaylistSoundtracksById(Collection<PlaylistSoundtrack> playlistSoundtracksById) {
        this.playlistSoundtracksById = playlistSoundtracksById;
    }
}
