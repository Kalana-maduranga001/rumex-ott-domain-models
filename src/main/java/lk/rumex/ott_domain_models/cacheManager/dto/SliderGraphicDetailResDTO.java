package lk.rumex.ott_domain_models.cacheManager.dto;


import lk.rumex.ott_domain_models.shared.Enum.ListingCountryType;
import lk.rumex.ott_domain_models.shared.Enum.MaturityRating;
import lk.rumex.ott_domain_models.sliderGraphics.Enum.CTAButtonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SliderGraphicDetailResDTO {
    private Long id;
    private String name;
    private String colorCode;
    private String posterUrl;
    private String resolution;
    private String posterCaption;
    private String posterType;
    private String sliderTxtImgURL;
    private String sliderVideoURL;
    private boolean addToWatchlistEnabled;
    private boolean shareButtonEnabled;
    private boolean ctabuttonEnabled;
    private CTAButtonType ctaButtonType;
    private PlayContentResDTO contentObj;
    private CustomBtnResDTO customBtnObj;
    private MaturityRating maturityRating;
    private ListingCountryType listingCountryType;
    private List<CountryDTO> countries;
}
