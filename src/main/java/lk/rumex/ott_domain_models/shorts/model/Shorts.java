package lk.rumex.ott_domain_models.shorts.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.castMember.model.CastMember;
import lk.rumex.ott_domain_models.category.Enum.MediaType;
import lk.rumex.ott_domain_models.country.model.Country;
import lk.rumex.ott_domain_models.gener.model.Genre;
import lk.rumex.ott_domain_models.keyword.model.Keyword;
import lk.rumex.ott_domain_models.poster.model.Poster;
import lk.rumex.ott_domain_models.shared.model.MediaBase;
import lk.rumex.ott_domain_models.shared.model.Monetization;
import lk.rumex.ott_domain_models.shared.model.Subtitle;
import lk.rumex.ott_domain_models.video.model.Video;
import lk.rumex.ott_domain_models.clientPackage.Enum.AudienceType;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shorts")
public class Shorts extends MediaBase {

    @ManyToMany
    @JoinTable(
            name = "shorts_directors",
            joinColumns = @JoinColumn(name = "short_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<CastMember> director;

    @ManyToMany
    @JoinTable(
            name = "shorts_producers",
            joinColumns = @JoinColumn(name = "short_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id")
    )
    private List<CastMember> producer;

    @OneToMany(mappedBy = "shorts", cascade = CascadeType.ALL)
    private List<ShortsCast> cast;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "short_id")
    private List<Subtitle> subtitles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "shorts_genres",
            joinColumns = @JoinColumn(name = "short_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "shorts_keywords",
            joinColumns = @JoinColumn(name = "short_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    private List<Keyword> keywords;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "shorts_posters",
            joinColumns = @JoinColumn(name = "short_id"),
            inverseJoinColumns = @JoinColumn(name = "poster_id")
    )
    private List<Poster> posters;

    @ManyToMany
    @JoinTable(
            name = "shorts_listing_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Country> countries;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_trailer_id")
    private Video mediaTrailer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "monetization_id")
    private Monetization monetization;

    @Enumerated(EnumType.STRING)
    @Column(name = "audience_type", nullable = false)
    private AudienceType audienceType = AudienceType.GENERAL;

    // Link to any content (optional)
    @Enumerated(EnumType.STRING)
    private MediaType linkedMediaType;

    private Long linkedMediaId;
}

