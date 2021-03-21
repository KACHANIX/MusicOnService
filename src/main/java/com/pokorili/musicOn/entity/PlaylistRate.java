package com.pokorili.musicOn.entity;

import javax.persistence.*;

@Entity
@Table(name = "playlist_rate")
public class PlaylistRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "playlist_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Playlist playlist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visitor_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Visitor visitor;

    @Basic
    @Column(name = "rate")
    private Integer rate;

    public PlaylistRate() {}

    public PlaylistRate(Playlist playlist, Visitor visitor, Integer rate) {
        this.playlist = playlist;
        this.visitor = visitor;
        this.rate = rate;
    }
    public PlaylistRate(Playlist playlist, Visitor visitor) {
        this.playlist = playlist;
        this.visitor = visitor;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaylistRate that = (PlaylistRate) o;

        if (playlist != null ? !playlist.equals(that.playlist) : that.playlist != null) return false;
        if (visitor != null ? !visitor.equals(that.visitor) : that.visitor != null) return false;
        if (rate != null ? !rate.equals(that.rate) : that.rate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = playlist != null ? playlist.hashCode() : 0;
        result = 31 * result + (visitor != null ? visitor.hashCode() : 0);
        result = 31 * result + (rate != null ? rate.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
