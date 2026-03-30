package lk.rumex.ott_domain_models.shared.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.clientPackage.model.ClientPackage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "monetization")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monetization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "free_to_watch_packs",
            joinColumns = @JoinColumn(name = "monetization_id"),
            inverseJoinColumns = @JoinColumn(name  = "client_package_id")
    )
    private List<ClientPackage> freeClientPackages;

    private Boolean advertisingAllowed;

    @OneToMany(mappedBy = "monetization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MonetizationPayToWatch> payToWatchPackages;
}
