package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.clientPackage.Enum.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOnPriceResDTO {
    private Long id;
    private CurrencyType currencyType;
    private Double price;
    private Integer rentalDurationInDays;
}