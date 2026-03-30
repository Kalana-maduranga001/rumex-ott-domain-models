package lk.rumex.ott_domain_models.shared.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lk.rumex.ott_domain_models.shared.Enum.ListingCountryType;
import lk.rumex.ott_domain_models.shared.Enum.MaturityRating;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class MasterBase extends BaseConfig{

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaturityRating maturityRating;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ListingCountryType listingCountryType;
}
