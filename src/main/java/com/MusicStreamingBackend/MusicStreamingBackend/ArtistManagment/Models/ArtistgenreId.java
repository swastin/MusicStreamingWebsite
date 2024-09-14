package com.MusicStreamingBackend.MusicStreamingBackend.ArtistManagment.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class ArtistgenreId implements Serializable {
    private static final long serialVersionUID = -5894546586326445411L;
    @Column(name = "artist_id", nullable = false)
    private Integer artistId;

    @Column(name = "genre_id", nullable = false)
    private Integer genreId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ArtistgenreId entity = (ArtistgenreId) o;
        return Objects.equals(this.genreId, entity.genreId) &&
                Objects.equals(this.artistId, entity.artistId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId, artistId);
    }

}