package lk.rumex.ott_domain_models.shared.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class SharedNameBase extends Base{
    @Column(nullable = false, unique = true, length = 100)
    private String name;
}
