package lk.rumex.ott_domain_models.podcast.model;

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
import lk.rumex.ott_domain_models.video.model.Video;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "podcast")
public class Podcast extends MediaBase {

    @ManyToMany
    @JoinTable(
            name = "podcast_hosts",
            joinColumns = @JoinColumn(name = "podcast_id"),
            inverseJoinColumns = @JoinColumn(name = "host_id")
    )
    private List<CastMember> hosts;

    @ManyToMany
    @JoinTable(
            name = "podcast_guests",
            joinColumns = @JoinColumn(name = "podcast_id"),
            inverseJoinColumns = @JoinColumn(name = "guest_id")
    )
    private List<CastMember> guests;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "podcast_id")
    private List<Subtitle> subtitles;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "podcast_genres",
            joinColumns = @JoinColumn(name = "podcast_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "podcast_keywords",
            joinColumns = @JoinColumn(name = "podcast_id"),
            inverseJoinColumns = @JoinColumn(name = "keyword_id")
    )
    private List<Keyword> keywords;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "podcast_posters",
            joinColumns = @JoinColumn(name = "podcast_id"),
            inverseJoinColumns = @JoinColumn(name = "poster_id")
    )
    private List<Poster> posters;

    @ManyToMany
    @JoinTable(
            name = "podcast_listing_countries",
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

