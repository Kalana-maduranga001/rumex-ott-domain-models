package lk.rumex.ott_domain_models.sliderGraphics.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.country.model.Country;
import lk.rumex.ott_domain_models.poster.model.Poster;
import lk.rumex.ott_domain_models.shared.model.MasterBase;
import lk.rumex.ott_domain_models.sliderGraphics.Enum.CTAButtonType;
import lk.rumex.ott_domain_models.sliderGraphics.Enum.SliderGraphicType;
import lk.rumex.ott_domain_models.video.model.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sliderGraphics")
public class SliderGraphics extends MasterBase {

    @Enumerated(EnumType.STRING)
    @Column(name = "slider_graphic_type", nullable = false)
    private SliderGraphicType sliderGraphicType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "portrait_poster_id", nullable = false)
    private Poster portraitImageObj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "landscape_poster_id", nullable = false)
    private Poster landscapeImageObj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slider_txt_img_id", nullable = false)
    private Poster sliderTxtImgObj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slider_video", nullable = false)
    private Video sliderVideoObj;

    @Column(name = "add_to_watchlist_enabled")
    private boolean addToWatchlistEnabled;

    @Column(name = "share_button_enabled")
    private boolean shareButtonEnabled;

    @Column(name = "cta_button_enabled")
    private boolean ctabuttonEnabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "cta_button_type")
    private CTAButtonType ctaButtonType;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "play_content_id", referencedColumnName = "id")
    private PlayContent contentObj;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "custom_btn_id", referencedColumnName = "id")
    private CustomBtn customBtnObj;

    @ManyToMany
    @JoinTable(
            name = "slider_graphics_listing_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Country> countries;

}
