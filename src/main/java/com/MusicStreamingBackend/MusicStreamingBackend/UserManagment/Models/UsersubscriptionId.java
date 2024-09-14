package com.MusicStreamingBackend.MusicStreamingBackend.UserManagment.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class UsersubscriptionId implements Serializable {
    private static final long serialVersionUID = 8555618288527778128L;
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "plan_id", nullable = false)
    private Integer planId;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsersubscriptionId entity = (UsersubscriptionId) o;
        return Objects.equals(this.planId, entity.planId) &&
                Objects.equals(this.userId, entity.userId) &&
                Objects.equals(this.startDate, entity.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planId, userId, startDate);
    }

}