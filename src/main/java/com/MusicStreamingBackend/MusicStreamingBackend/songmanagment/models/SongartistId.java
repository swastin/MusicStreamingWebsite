package com.MusicStreamingBackend.MusicStreamingBackend.songmanagment.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class SongartistId implements Serializable {
    private static final long serialVersionUID = 575975290210850621L;
    @Column(name = "song_id", nullable = false)
    private Integer songId;

    @Column(name = "artist_id", nullable = false)
    private Integer artistId;


}