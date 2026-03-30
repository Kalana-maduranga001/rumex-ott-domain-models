package lk.rumex.ott_domain_models.episodes.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.castMember.model.CastMember;
import lk.rumex.ott_domain_models.country.model.Country;
import lk.rumex.ott_domain_models.gener.model.Genre;
import lk.rumex.ott_domain_models.keyword.model.Keyword;
import lk.rumex.ott_domain_models.poster.model.Poster;
import lk.rumex.ott_domain_models.shared.model.MediaBase;
import lk.rumex.ott_domain_models.shared.model.Subtitle;
import lk.rumex.ott_domain_models.video.model.Video;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "episodes")
public class Episodes extends MediaBase {

    private Long tvShowId;

    @Column(nullable = false)
    private Integer episodeNo;

    @Column(nullable = false)
    private Integer seasonNo;

    @ManyToMany
    @JoinTable(
            name = "episodes_directors",
            joinColumns = @JoinColumn(name = "episodes_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<CastMember> director;

    @ManyToMany
    @JoinTable(
            name = "episodes_producers",
            joinColumns = @JoinColumn(name = "episodes_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id")
    )
    private List<CastMember> producer;

    @OneToMany(mappedBy = "episodes", cascade = CascadeType.ALL)
    private List<EpisodesCast> cast;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "episodes_id")
    private List<Subtitle> subtitles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "episodes_genres",
            joinColumns = @JoinColumn(name = "episodes_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "episodes_keywords",
            joinColumns = @JoinColumn(name = "episodes_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    private List<Keyword> keywords;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "episodes_posters",
            joinColumns = @JoinColumn(name = "episodes_id"),
            inverseJoinColumns = @JoinColumn(name = "poster_id")
    )
    private List<Poster> posters;

    @ManyToMany
    @JoinTable(
            name = "episodes_listing_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Country> countries;
}
