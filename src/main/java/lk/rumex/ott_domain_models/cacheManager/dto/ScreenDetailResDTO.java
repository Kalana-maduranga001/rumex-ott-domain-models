package lk.rumex.ott_domain_models.cacheManager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScreenDetailResDTO {
    private Long id;
    private String name;
    private Integer seqNo;
    private List<SliderGraphicDetailResDTO> sliderGraphics = new ArrayList<>();
    private PageResponseDTO<CategoryDetailResDTO> categories;
}
