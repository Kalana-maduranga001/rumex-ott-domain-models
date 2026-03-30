package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.sliderGraphics.Enum.BtnLinkType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomBtnResDTO {
    private String ctaButtonText;
    private String linkedContentURL;
    private BtnLinkType btnLinkType;
    private PlayContentResDTO contentObj;
    private String externalLinkURL;
}
