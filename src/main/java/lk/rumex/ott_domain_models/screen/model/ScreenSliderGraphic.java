package lk.rumex.ott_domain_models.screen.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.sliderGraphics.model.SliderGraphics;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "screen_slider_graphics")
public class ScreenSliderGraphic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seq_no", nullable = false)
    private Integer seqNo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "screen_id", nullable = false)
    private Screen screen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "slider_graphic_id", nullable = false)
    private SliderGraphics sliderGraphics;

}
