package lk.rumex.ott_domain_models.cacheManager.dto;

import lk.rumex.ott_domain_models.clientPackage.model.ClientPackage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonetizationResDTO {
    private List<ClientPackage> freeClientPackage;
    private Boolean advertisingAllowed;
    private List<PayToWatchPackageResDTO> payToWatchPackageResDTOS;
}
