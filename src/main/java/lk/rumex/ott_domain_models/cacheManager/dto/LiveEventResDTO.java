package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.video.model.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveEventResDTO extends ContentDetailsResDTO{
    private String cdnUrl;
    private Instant startTimeUtc;
    private Instant endTimeUtc;
    private String countdownVideoUrl;
}
