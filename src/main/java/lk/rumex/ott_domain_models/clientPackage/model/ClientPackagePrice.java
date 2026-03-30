package lk.rumex.ott_domain_models.clientPackage.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lk.rumex.ott_domain_models.tenantPackage.Enum.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "client_package_prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientPackagePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private CurrencyType currencyType;

    @Column(nullable = false)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "client_package_id", nullable = false)
    @JsonBackReference
    private ClientPackage clientPackage;
}
