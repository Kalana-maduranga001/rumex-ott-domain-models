package lk.rumex.ott_domain_models.clientPackage.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lk.rumex.ott_domain_models.clientPackage.Enum.AudienceType;
import lk.rumex.ott_domain_models.clientPackage.Enum.Availability;
import lk.rumex.ott_domain_models.clientPackage.Enum.BillingPeriod;
import lk.rumex.ott_domain_models.shared.model.BaseConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "clientPackages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientPackage extends BaseConfig {

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "client_package_features", joinColumns = @JoinColumn(name = "client_package_id"))
    @Column(name = "feature")
    private List<String> features;

    @Column(length = 255)
    private String imageURL;

//    @Column(length = 100)
//    private String offerId;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "client_package_offer_ids", joinColumns = @JoinColumn(name = "client_package_id"))
    @Column(name = "offer_id", length = 100)
    private List<String> offerIds;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BillingPeriod billingPeriod;

    @Column(nullable = false)
    private Boolean recurringPlan = false;

    private Integer recurringPeriodInDays;

    // true = SLT, false = Rumex
    @Column(nullable = false)
    private Boolean provisionBy = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Availability availability;

    @OneToMany(mappedBy = "clientPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ClientPackagePrice> packagePrices;

    @Enumerated(EnumType.STRING)
    @Column(name = "audience_type", nullable = false)
    private AudienceType audienceType = AudienceType.GENERAL;

    @PrePersist
    @PreUpdate
    private void syncRecurringPeriodInDays() {
        recurringPeriodInDays = billingPeriod != null ? billingPeriod.toDays() : null;
    }

}
