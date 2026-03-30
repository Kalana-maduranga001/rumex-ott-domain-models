package lk.rumex.ott_domain_models.tenantPackage.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.clientPackage.Enum.Availability;
import lk.rumex.ott_domain_models.clientPackage.Enum.BillingPeriod;
import lk.rumex.ott_domain_models.shared.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tenantPackages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TenantPackages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long createdAdmin;

    private Long modifiedAdmin;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false, nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status publishStatus;

    private Long publishedBy;

    private Long isDeletedBy;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @ElementCollection
    @CollectionTable(name = "tenant_package_features", joinColumns = @JoinColumn(name = "tenant_package_id"))
    @Column(name = "feature")
    private List<String> features;

    @Column(length = 255)
    private String textField;

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

    @OneToMany(mappedBy = "tenantPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TenantPackagePrice> packagePrices;

    @PrePersist
    @PreUpdate
    private void syncRecurringPeriodInDays() {
        recurringPeriodInDays = billingPeriod != null ? billingPeriod.toDays() : null;
    }

}
