package lk.rumex.ott_domain_models.liveChannel.model;

import jakarta.persistence.*;

import lk.rumex.ott_domain_models.shared.model.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "live_channel_epg",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"live_channel_id", "external_program_id"})
        })
public class LiveChannelEpg extends Base {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "live_channel_id", nullable = false)
    private LiveChannel liveChannel;

    @Column(name = "external_program_id", nullable = false)
    private Long externalProgramId;

    @Column(name = "epg_date", nullable = false)
    private LocalDate epgDate;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String synopsis;

    private String language;

    private String genre;

    @Column(name = "sub_genre")
    private String subGenre;

    @Column(name = "poster_url", length = 500)
    private String posterUrl;

    @Column(name = "program_type")
    private String programType;

    @Column(name = "episode_number")
    private String episodeNumber;

    @Column(name = "start_datetime_utc", nullable = false)
    private Instant startDateTimeUtc;

    @Column(name = "end_datetime_utc", nullable = false)
    private Instant endDateTimeUtc;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @Column(name = "time_zone")
    private String timeZone;

    @Column(name = "is_live")
    private Boolean live;

    @Column(name = "pg_rating")
    private String pgRating;

    @Column(name = "episodic_title")
    private String episodicTitle;

    @Column(name = "episodic_synopsis", columnDefinition = "TEXT")
    private String episodicSynopsis;

    private String starcast;

    private String writer;

    private String director;

    private String cdnUrl;
}
