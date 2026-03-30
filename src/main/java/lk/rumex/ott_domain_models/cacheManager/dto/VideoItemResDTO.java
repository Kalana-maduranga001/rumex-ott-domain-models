package lk.rumex.ott_domain_models.cacheManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoItemResDTO {
    private Long videoId;
    private String title;
    private Long seqNo;
    private String cdnUrl;
    private String vttUrl;
    private String conversionError;
}

