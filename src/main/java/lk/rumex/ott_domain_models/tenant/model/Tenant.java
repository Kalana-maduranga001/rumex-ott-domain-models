package lk.rumex.ott_domain_models.tenant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lk.rumex.ott_domain_models.tenantPackage.model.TenantPackages;
import lk.rumex.ott_domain_models.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tenant")
public class Tenant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false, unique = true)
    private String name;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false, unique = true)
    private String domain;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false, unique = true)
    private String tabTitle;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false, unique = true)
    private String heroTitle;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false, unique = true)
    private String heroDescription;

    @NotNull
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false, unique = true)
    private String mobile;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false)
    private String settings;


    @Column(updatable = false)
    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "package_id")
    private TenantPackages packageSubscribed;

}
