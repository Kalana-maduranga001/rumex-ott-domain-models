package lk.rumex.ott_domain_models.liveCountdown.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.poster.model.Poster;
import lk.rumex.ott_domain_models.shared.model.BaseConfig;
import lk.rumex.ott_domain_models.shared.model.Monetization;
import lk.rumex.ott_domain_models.shared.model.Title;
import lk.rumex.ott_domain_models.video.model.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "live_countdowns")
public class LiveCountdown extends BaseConfig {

    @Embedded
    private Title title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private String cdnUrl;

    @Column(name = "rtmp_preview_url", nullable = false)
    private String rtmpPreviewUrl;

    @Column(name = "log_url", nullable = false)
    private String logUrl;

    @Column(name = "start_time_utc", nullable = false)
    private Instant startTimeUtc;

    @Column(name = "end_time_utc", nullable = false)
    private Instant endTimeUtc;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "countdown_video_id", nullable = false)
    private Video countdownVideo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "live_countdown_posters",
            joinColumns = @JoinColumn(name = "live_countdown_id"),
            inverseJoinColumns = @JoinColumn(name = "poster_id")
    )
    private List<Poster> posters;

    @Column(name = "drm_enabled", nullable = false)
    private Boolean drmEnabled = false;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "monetization_id")
    private Monetization monetization;
}
