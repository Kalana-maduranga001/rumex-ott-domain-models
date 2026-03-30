package lk.rumex.ott_domain_models.cacheManager.dto;
import lk.rumex.ott_domain_models.shared.model.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeCommonResDTO {
    private Long id;
    private String slug;
    private String description;
    private String runtime;
    private Title title;
    private List<String> genres;
    private List<String> keywords;
    private List<PosterResDTO> posters;
    private Integer episodeNo;
}
