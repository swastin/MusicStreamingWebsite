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
public class ArtistgenerId implements Serializable {
    private static final long serialVersionUID = -5894546586326445411L;
    @Column(name = "artist_id", nullable = false)
    private Integer artistId;

    @Column(name = "gener_id", nullable = false)
    private Integer generId;


}