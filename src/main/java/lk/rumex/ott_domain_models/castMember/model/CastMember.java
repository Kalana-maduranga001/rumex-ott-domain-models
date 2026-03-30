package lk.rumex.ott_domain_models.castMember.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import lk.rumex.ott_domain_models.shared.model.SharedNameBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cast_members")
public class CastMember extends SharedNameBase {
    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(nullable = false, length = 255)
    private String photoUrl;
}
