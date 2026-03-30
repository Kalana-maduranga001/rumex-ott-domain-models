package lk.rumex.ott_domain_models.video.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lk.rumex.ott_domain_models.shared.model.Base;
import lk.rumex.ott_domain_models.video.model.Enum.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "video")
public class Video extends Base {

    @NotNull
    @Size(min = 1)
    @Column(nullable = false)
    private String title;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false)
    private String resolutions;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false)
    private String sourceUrl;

    @NotNull
    @Size(min = 0)
    @Column(nullable = false)
    private String cdnUrl;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false)
    private String conversionStatus;

    @NotNull
    @Size(min = 1)
    @Column(nullable = false)
    private String conversionRate;

    @Column(name = "conversion_error")
    private String conversionError;

    @NotNull
    private String vttUrl;

    private Type videoType;

    private Boolean drmEnabled;

    private String keyId;

    private String hlsUrl;

    private String dashUrl;
}
