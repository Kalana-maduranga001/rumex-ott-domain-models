package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.shared.Enum.ListingCountryType;
import lk.rumex.ott_domain_models.shared.Enum.MaturityRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NavBarDataDTO {
    private Long id;
    private String name;
    private MaturityRating maturityRating;
    private ListingCountryType listingCountryType;
    private List<CountryDTO> countries;
    private Integer seqNo;
}
