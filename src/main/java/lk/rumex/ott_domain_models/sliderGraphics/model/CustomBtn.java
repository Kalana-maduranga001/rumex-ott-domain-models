package lk.rumex.ott_domain_models.sliderGraphics.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.sliderGraphics.Enum.BtnLinkType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "custom_btn")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomBtn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cta_button_text", length = 100)
    private String ctaButtonText;

    @Column(name = "linked_content_url", length = 500)
    private String linkedContentURL;

    @Enumerated(EnumType.STRING)
    @Column(name = "btn_link_type", nullable = false)
    private BtnLinkType btnLinkType;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "play_content_id", referencedColumnName = "id")
    private PlayContent contentObj;

    @Column(name = "external_link_url", length = 500)
    private String externalLinkURL;
}
