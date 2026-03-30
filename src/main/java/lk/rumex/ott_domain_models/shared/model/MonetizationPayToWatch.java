package lk.rumex.ott_domain_models.shared.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.clientPackage.model.ClientPackage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "monetization_pay_to_watch")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonetizationPayToWatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "monetization_id")
    private Monetization monetization;

    @ManyToOne
    @JoinColumn(name = "client_package_id")
    private ClientPackage clientPackage;

    private Double priceLkr;
    private Double priceUsd;
    private Integer rentalDurationInDays;
    private Integer watchingDurationInDays;
}
