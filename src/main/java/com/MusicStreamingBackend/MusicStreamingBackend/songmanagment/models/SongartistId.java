package com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models;

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
public class SongartistId implements Serializable {
    private static final long serialVersionUID = 575975290210850621L;
    @Column(name = "song_id", nullable = false)
    private Integer songId;

    @Column(name = "artist_id", nullable = false)
    private Integer artistId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SongartistId entity = (SongartistId) o;
        return Objects.equals(this.artistId, entity.artistId) &&
                Objects.equals(this.songId, entity.songId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artistId, songId);
    }

}