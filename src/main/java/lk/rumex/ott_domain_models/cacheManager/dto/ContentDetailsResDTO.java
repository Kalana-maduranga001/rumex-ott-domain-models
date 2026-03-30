package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.shared.model.Subtitle;
import lk.rumex.ott_domain_models.shared.model.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentDetailsResDTO {
    private Long id;
    private Boolean allowDownloads;
    private Boolean allowGuestUsersToWatch;
    private Boolean allowEarlyAccess;
    private String maturityRating;
    private String maturityRatingTxtField;
    private String listingCountryType;
    private List<String> countries;
    private String vttUrl;
    private String slug;
    private String description;
    private String releaseDate;
    private String runtime;
    private Title title;
    private List<Subtitle> subtitles;
    private List<String> genres;
    private List<String> keywords;
    private String videoUrl;
    private Long videoId;
    private Boolean ezdrm = true;
    private Boolean axionomdrm = false;
    private List<PosterResDTO> posters;
    private String hlsUrl;
    private String dashUrl;
    private Boolean drmEnabled;
    private MonetizationResDTO monetizationResDTO;
}
