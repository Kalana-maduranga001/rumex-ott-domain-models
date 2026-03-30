package lk.rumex.ott_domain_models.sliderGraphics.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.category.Enum.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "play_content")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlayContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "media_id", nullable = false)
    private Long mediaId;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false)
    private MediaType mediaType;
}
