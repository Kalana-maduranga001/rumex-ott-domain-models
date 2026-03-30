package lk.rumex.ott_domain_models.cacheManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PosterResDTO {
    private String sourceUrl;
    private String type;
    private String resolution;
    private String orientation;
    private String cdnUrl;
    private String caption;
}
