package lk.rumex.ott_domain_models.episodes.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.castMember.model.CastMember;
import lk.rumex.ott_domain_models.role.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "episodes_cast")
public class EpisodesCast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "episodes_id", nullable = false)
    private Episodes episodes;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cast_member_id", nullable = false)
    private CastMember castMember;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;


    @Column(nullable = false)
    private int priorityNo;
}
