package lk.rumex.ott_domain_models.user.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.user.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Table(name="profiles")
@Data @NoArgsConstructor @AllArgsConstructor
public class Profile {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private User user;

  @Column(nullable = false, length = 60)
  private String name;

  @Column(nullable = false, length = 16)
  private String maturityLevel; // KIDS, TEEN, ADULT (string for compatibility)

  private String imageUrl;
  private Integer age;
  private Gender gender;
  private String language = "EN";

  private boolean autoplayNext = true;
  private boolean autoplayPreviews = false;

  private String pin;
}
