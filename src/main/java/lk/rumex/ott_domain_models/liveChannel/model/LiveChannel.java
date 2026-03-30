package lk.rumex.ott_domain_models.liveChannel.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.poster.model.Poster;
import lk.rumex.ott_domain_models.shared.model.BaseConfig;
import lk.rumex.ott_domain_models.shared.model.Monetization;
import lk.rumex.ott_domain_models.shared.model.Title;
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
@Table(name = "live_channels")
public class LiveChannel extends BaseConfig {

    @Embedded
    private Title title;

    @Column(nullable = false, unique = true)
    private String cdnUrl;

    @Column(name = "rtmp_preview_url", nullable = false)
    private String rtmpPreviewUrl;

    @Column(name = "log_url", nullable = false)
    private String logUrl;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(name = "instance_id", nullable = false)
    private String instanceId;

    @Column(name = "external_channel_id", unique = true)
    private Long externalChannelId;

    @Column(name = "lcn", unique = true)
    private Integer lcn;

    @Column(name = "drm_enabled", nullable = false)
    private Boolean drmEnabled = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "live_channel_posters",
            joinColumns = @JoinColumn(name = "live_channel_id"),
            inverseJoinColumns = @JoinColumn(name = "poster_id")
    )
    private List<Poster> posters;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "monetization_id")
    private Monetization monetization;
}
