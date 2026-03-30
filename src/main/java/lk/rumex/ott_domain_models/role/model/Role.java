package lk.rumex.ott_domain_models.role.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lk.rumex.ott_domain_models.shared.model.SharedNameBase;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Role extends SharedNameBase {
}
