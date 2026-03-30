package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.clientPackage.model.ClientPackage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayToWatchPackageResDTO {
    private ClientPackage payToWatchClientPackageId;
    private Double priceLkr;
    private Double priceUsd;
    private Integer rentalDurationInDays;
    private Integer watchingDurationInDays;
}
