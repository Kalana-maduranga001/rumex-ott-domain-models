package lk.rumex.ott_domain_models.poster.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lk.rumex.ott_domain_models.poster.Enum.PosterOrientation;
import lk.rumex.ott_domain_models.poster.Enum.PosterType;
import lk.rumex.ott_domain_models.shared.model.BaseConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "poster")
public class Poster extends BaseConfig {

    @Column(name = "caption", nullable = false, length = 255)
    private String caption;

    @Column(name = "resolution", nullable = false, length = 50)
    private String resolution;

    @Column(name = "source_url", nullable = false, length = 2083)
    private String sourceUrl;

    @Column(name = "cdn_url", nullable = false, length = 2083)
    private String cdnUrl;

    @Column(name = "poster_orientation", nullable = false, length = 50)
    private PosterOrientation posterOrientation;

    @Column(name = "poster_type", nullable = false, length = 50)
    private PosterType posterType;

    @Column(name = "color_code", nullable = true)
    private String colorCode;
}
