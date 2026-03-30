package lk.rumex.ott_domain_models.tenantPackage.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.tenantPackage.Enum.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tenant_package_prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantPackagePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private CurrencyType currencyType;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "tenant_package_id", nullable = false)
    private TenantPackages tenantPackage;
}
