package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.category.Enum.MediaType;
import lk.rumex.ott_domain_models.clientPackage.model.ClientPackage;
import lk.rumex.ott_domain_models.shared.Enum.ListingCountryType;
import lk.rumex.ott_domain_models.shared.Enum.MaturityRating;
import lk.rumex.ott_domain_models.shared.model.Monetization;
import lk.rumex.ott_domain_models.shared.model.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaDetailResDTO {
    private Long id;
    private Title title;
    private String mediaTrailerUrl;
    private MediaType mediaType;
    private String description;
    private Date releaseDate;
    private String runtime;
    private String posterUrl;
    private String posterTitleUrl;
    private String posterLandScapeTitleUrl;
    private String resolution;
    private Boolean allowDownloads;
    private Boolean allowGuestUsersToWatch;
    private Boolean allowEarlyAccess;
    private MaturityRating maturityRating;
    private String maturityRatingTxtField;
    private ListingCountryType listingCountryType;
    private List<CountryDTO> countries;
    private String earlyAccessDate;
    private String slug;
    private MonetizationResDTO monetization;
    /*private Boolean isPremium;
    private PayToWatchPackageResDTO payToWatchPackageResDTO;*/
}
