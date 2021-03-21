package com.pokorili.musicOn.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "advert_place", schema = "s243895", catalog = "studs")
public class AdvertPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Basic
    @Column(name = "free")
    private Boolean isFree;

    @Basic
    @Column(name = "width", nullable = false)
    private Integer width;

    @Basic
    @Column(name = "height", nullable = false)
    private Integer height;

    @OneToMany(mappedBy = "advertPlace")
    @JsonIgnore
    private Collection<Advert> advertsById;

    public AdvertPlace() {}

    public AdvertPlace(Boolean isFree, Integer width, Integer height) {
        this.isFree = isFree;
        this.width = width;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean isFree) {
        this.isFree = isFree;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertPlace that = (AdvertPlace) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (isFree != null ? !isFree.equals(that.isFree) : that.isFree != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (isFree != null ? isFree.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        return result;
    }

    public Collection<Advert> getAdvertsById() {
        return advertsById;
    }

    public void setAdvertsById(Collection<Advert> advertsById) {
        this.advertsById = advertsById;
    }
}
