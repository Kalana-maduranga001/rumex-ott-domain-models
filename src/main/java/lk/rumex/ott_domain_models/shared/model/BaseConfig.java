package lk.rumex.ott_domain_models.shared.model;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lk.rumex.ott_domain_models.shared.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseConfig extends Base {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status publishStatus;

    private Long publishedBy;

    private Long isDeletedBy;

    @Column(nullable = false)
    private Boolean isDeleted;

    @Column(nullable = false)
    private Boolean asyncElasticSearch;
}
