package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.category.Enum.MediaType;
import lk.rumex.ott_domain_models.shared.model.Title;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShortsResDTO extends ContentDetailsResDTO {
    private List<CastResDTO> director;
    private List<CastResDTO> producer;
    private List<CastResDTO> cast;
    private String mediaTrailerUrl;

    private MediaType linkedMediaType;
    private Long linkedMediaId;
}
