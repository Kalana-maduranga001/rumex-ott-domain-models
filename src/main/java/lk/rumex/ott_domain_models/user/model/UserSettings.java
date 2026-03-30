package lk.rumex.ott_domain_models.user.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="user_settings")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserSettings {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private Long userId;

  private String language;          // EN/SI/TA
  private Boolean emailNotifications;
  private Boolean twoFactorEmail;
}
