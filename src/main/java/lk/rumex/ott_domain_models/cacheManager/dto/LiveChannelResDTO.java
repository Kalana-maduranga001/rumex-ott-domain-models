package lk.rumex.ott_domain_models.cacheManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiveChannelResDTO extends ContentDetailsResDTO {
    private String cdnUrl;
}
