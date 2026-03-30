package lk.rumex.ott_domain_models.promoCode.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.addOns.model.AddOn;
import lk.rumex.ott_domain_models.clientPackage.model.ClientPackage;
import lk.rumex.ott_domain_models.shared.model.BaseConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "promo_codes")
public class PromoCode extends BaseConfig {

    @Column(name = "promo_code", unique = true, nullable = false, length = 50)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "add_on_id")
    private AddOn addOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_package_id")
    private ClientPackage clientPackage;

    @Column(name = "discount_percentage", nullable = false)
    private Double discountPercentage;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(name = "max_usage_count", nullable = false)
    private Long maxUsageCount;
}
