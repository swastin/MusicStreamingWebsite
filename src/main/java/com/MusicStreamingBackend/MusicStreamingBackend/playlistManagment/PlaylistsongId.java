package com.MusicStreamingBackend.MusicStreamingBackend.playlistManagment;

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
public class PlaylistsongId implements Serializable {
    private static final long serialVersionUID = 4980497745765670807L;
    @Column(name = "playlist_id", nullable = false)
    private Integer playlistId;

    @Column(name = "song_id", nullable = false)
    private Integer songId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlaylistsongId entity = (PlaylistsongId) o;
        return Objects.equals(this.playlistId, entity.playlistId) &&
                Objects.equals(this.songId, entity.songId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, songId);
    }

}