package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.shared.Enum.ListingCountryType;
import lk.rumex.ott_domain_models.shared.Enum.MaturityRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDetailResDTO {
    private Long id;
    private String name;
    private String description;
    private Integer seqNo;
    private List<MediaDetailResDTO> mediaList = new ArrayList<>();
    private MaturityRating maturityRating;
    private ListingCountryType listingCountryType;
    private List<CountryDTO> countries;
}
