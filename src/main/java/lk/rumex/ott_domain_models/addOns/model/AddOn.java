package lk.rumex.ott_domain_models.addOns.model;

import jakarta.persistence.*;

import lk.rumex.ott_domain_models.addOns.Enum.AddOnBundleType;
import lk.rumex.ott_domain_models.clientPackage.Enum.Availability;
import lk.rumex.ott_domain_models.movies.model.Movie;
import lk.rumex.ott_domain_models.podcast.model.Podcast;
import lk.rumex.ott_domain_models.poster.model.Poster;
import lk.rumex.ott_domain_models.shared.model.BaseConfig;
import lk.rumex.ott_domain_models.tvShows.model.TvShows;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "addons")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOn extends BaseConfig {

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Availability availability;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AddOnBundleType bundleType;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "addon_price_id")
    private AddOnPrice addOnPrice;

    private boolean autoAssignAllNewUsers;
    private boolean autoAssignExistingUsers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portrait_poster_id")
    private Poster portraitPoster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landscape_poster_id")
    private Poster landscapePoster;

    @OneToMany(mappedBy = "addon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddOnLineup> lineups = new ArrayList<>();

}



