package lk.rumex.ott_domain_models.videoLibrary.model;

import jakarta.persistence.*;
import lk.rumex.ott_domain_models.shared.model.Base;
import lk.rumex.ott_domain_models.video.model.Video;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "video_library_videos")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VideoLibraryVideo extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", nullable = false)
    private VideoLibrary videoLibrary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "video_id", nullable = false)
    private Video video;

    @Column(nullable = false)
    private Long seqNo;
}

