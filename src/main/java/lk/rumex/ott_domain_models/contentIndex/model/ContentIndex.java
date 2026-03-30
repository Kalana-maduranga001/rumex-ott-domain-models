package lk.rumex.ott_domain_models.contentIndex.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.category.Enum.MediaType;
import lk.rumex.ott_domain_models.shared.Enum.ListingCountryType;
import lk.rumex.ott_domain_models.shared.Enum.MaturityRating;
import lk.rumex.ott_domain_models.shared.Enum.Status;
import lk.rumex.ott_domain_models.shared.model.Base;
import lk.rumex.ott_domain_models.shared.model.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(
        name = "content_index",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_content_index_tenant_slug", columnNames = {"tenantId", "slug"})
        }
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContentIndex extends Base {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MediaType mediaType;

    @Column(nullable = false)
    private Long mediaId;

    @Column(nullable = false, length = 250)
    private String slug;

    @Embedded
    private Title title;

    @Column(length = 500)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    private String runtime;

    @Enumerated(EnumType.STRING)
    private Status publishStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date publishDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date unpublishDate;

    @Enumerated(EnumType.STRING)
    private MaturityRating maturityRating;

    @Enumerated(EnumType.STRING)
    private ListingCountryType listingCountryType;

    // Representative media
    private String LandscapePosterUrl;
    private String portraitPosterUrl;
    private String titlePosterUrl;
    private String posterResolution;
    private String trailerUrl;

    // Flattened lists for quick filtering (comma-separated)
    @Column(length = 1000)
    private String genres;

    @Column(length = 1000)
    private String keywords;

    @Column(length = 1000)
    private String countries;

    @Lob
    private String extra;
}
