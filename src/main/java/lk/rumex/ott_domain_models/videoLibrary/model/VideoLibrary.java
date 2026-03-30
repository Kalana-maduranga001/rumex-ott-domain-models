package lk.rumex.ott_domain_models.videoLibrary.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.castMember.model.CastMember;
import lk.rumex.ott_domain_models.clientPackage.Enum.AudienceType;
import lk.rumex.ott_domain_models.country.model.Country;
import lk.rumex.ott_domain_models.gener.model.Genre;
import lk.rumex.ott_domain_models.keyword.model.Keyword;
import lk.rumex.ott_domain_models.poster.model.Poster;
import lk.rumex.ott_domain_models.shared.model.MediaBase;
import lk.rumex.ott_domain_models.shared.model.Monetization;
import lk.rumex.ott_domain_models.shared.model.Subtitle;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "video_libraries")
public class VideoLibrary extends MediaBase {

    @ManyToMany
    @JoinTable(
            name = "video_library_directors",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<CastMember> director;

    @ManyToMany
    @JoinTable(
            name = "video_library_producers",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id")
    )
    private List<CastMember> producer;

    @OneToMany(mappedBy = "videoLibrary", cascade = CascadeType.ALL)
    private List<VideoLibraryCast> cast;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "videoLibrary", orphanRemoval = true)
    private List<VideoLibraryVideo> videos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    private List<Subtitle> subtitles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "video_library_genres",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "video_library_keywords",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    private List<Keyword> keywords;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "video_library_posters",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "poster_id")
    )
    private List<Poster> posters;

    @ManyToMany
    @JoinTable(
            name = "video_library_listing_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Country> countries;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "monetization_id")
    private Monetization monetization;

    @Enumerated(EnumType.STRING)
    @Column(name = "audience_type", nullable = false)
    private AudienceType audienceType = AudienceType.GENERAL;
}

