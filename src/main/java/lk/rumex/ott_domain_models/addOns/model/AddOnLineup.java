package lk.rumex.ott_domain_models.addOns.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.movies.model.Movie;
import lk.rumex.ott_domain_models.poster.model.Poster;
import lk.rumex.ott_domain_models.tvShows.model.TvShows;
import lk.rumex.ott_domain_models.util.converter.YearMonthAttributeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "addon_lineups",
        uniqueConstraints = @UniqueConstraint(name = "uk_addon_month", columnNames = {"addon_id","lineup_month"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddOnLineup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "addon_id", nullable = false)
    private AddOn addon;

    @Convert(converter = YearMonthAttributeConverter.class)
    @Column(name = "lineup_month", nullable = false, length = 7)
    private YearMonth month;

    @Column(nullable = false)
    private boolean published = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portrait_poster_id")
    private Poster portraitPoster;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landscape_poster_id")
    private Poster landscapePoster;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "addon_lineup_movies",
            joinColumns = @JoinColumn(name = "lineup_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    @Builder.Default
    private List<Movie> movies = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "addon_lineup_tvshows",
            joinColumns = @JoinColumn(name = "lineup_id"),
            inverseJoinColumns = @JoinColumn(name = "tvshow_id"))
    @Builder.Default
    private List<TvShows> tvShows = new ArrayList<>();
}
