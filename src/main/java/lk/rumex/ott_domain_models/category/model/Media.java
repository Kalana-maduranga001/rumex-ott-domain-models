package lk.rumex.ott_domain_models.category.model;

import jakarta.persistence.*;

import lk.rumex.ott_domain_models.category.Enum.MediaType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "media_type", nullable = false)
    private MediaType mediaType;

    @Column(name = "seq_no", nullable = false)
    private Long seqNo;

    @Column(name = "media_id", nullable = false)
    private Long mediaId;
}
