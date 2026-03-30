package lk.rumex.ott_domain_models.shared.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.shared.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class MediaBase extends ContentRule{

    private Long createdUser;

    private Long modifiedUser;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status contentStatus;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status posterConversionStatus;

    @Embedded
    private Title title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false, length = 500)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private String runtime;

    @Column(name = "publish_date")
    private Date publishDate;

    @Column(name = "unpublish_date")
    private Date unpublishDate;


}
