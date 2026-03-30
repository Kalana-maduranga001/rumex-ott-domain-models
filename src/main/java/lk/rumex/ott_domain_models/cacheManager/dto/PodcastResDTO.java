package lk.rumex.ott_domain_models.cacheManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PodcastResDTO extends ContentDetailsResDTO {
    private List<String> hosts;
    private List<String> guests;
}
