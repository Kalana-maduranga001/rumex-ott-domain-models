package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.category.Enum.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayContentResDTO {
    private Long id;
    private MediaType mediaType;
    private Long mediaId;
    private String slug;
    private TitleResDTO title;
    private String description;
    private Date releaseDate;
    private String runtime;
}
