package lk.rumex.ott_domain_models.user.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.clientPackage.model.ClientPackage;
import lk.rumex.ott_domain_models.user.Enum.AccountStatus;
import lk.rumex.ott_domain_models.user.Enum.LoginType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity @Table(name="users", uniqueConstraints = {
        @UniqueConstraint(name = "uk_users_tenant_username", columnNames = {"tenant_id", "username"}),
        @UniqueConstraint(name = "uk_users_tenant_email", columnNames = {"tenant_id", "email"}),
        @UniqueConstraint(name = "uk_users_tenant_phone", columnNames = {"tenant_id", "mobile_number"})
})
@Data @NoArgsConstructor @AllArgsConstructor
public class User {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "tenant_id", nullable = false)
  private Long tenantId;

  @Column(length = 190)
  private String email;

  @Column(name = "mobile_number", length = 128)
  private String phoneNumber;

  @Column(nullable = false)
  private String username;

  private String password;

  private String fullName;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 24)
  private AccountStatus accountStatus = AccountStatus.PENDING_VERIFICATION;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 24)
  private LoginType loginType = LoginType.EMAIL;

  @Column(nullable = false)
  private boolean emailVerified = false;

  @Column(nullable = false)
  private boolean phoneVerified = false;

  @Column(nullable = false)
  private boolean admin = false;

  @CreationTimestamp
  @Column(nullable = false, updatable = false)
  private Instant createdAt;

  @UpdateTimestamp
  @Column(nullable = false)
  private Instant updatedAt;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  private Set<Profile> profiles = new LinkedHashSet<>();

  @ManyToOne
  @JoinColumn(name = "clientPackages_id")
  private ClientPackage clientPackage;

}