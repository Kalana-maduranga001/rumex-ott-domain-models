package lk.rumex.ott_domain_models.season.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.shared.model.SharedNameBase;
import lk.rumex.ott_domain_models.tvShows.model.TvShows;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "seasons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Season extends SharedNameBase {
    @Column(name = "seasonNo", nullable = false)
    private Long seasonNo;
    @Column(name = "label", nullable = false, unique = true, length = 500)
    private String label;
    private Boolean isDeleted = false;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tvShows_id")
    private TvShows tvShow;
}
