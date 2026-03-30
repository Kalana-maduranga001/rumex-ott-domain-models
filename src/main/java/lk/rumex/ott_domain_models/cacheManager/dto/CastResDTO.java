package lk.rumex.ott_domain_models.cacheManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CastResDTO {
    private Long id;
    private String name;
    private String imageUrl;
    private String role;
}
