package lk.rumex.ott_domain_models.addOns.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.tenantPackage.Enum.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addon_prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddOnPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private CurrencyType currencyType;

    @Column(nullable = false)
    private Double price;

    @Column
    private Integer rentalDurationInDays;

    private Boolean recurring = false;
    private Integer recurringPeriodInDays;

}
