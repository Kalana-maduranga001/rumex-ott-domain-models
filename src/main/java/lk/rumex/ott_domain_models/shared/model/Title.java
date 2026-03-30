package lk.rumex.ott_domain_models.shared.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Title {

    @Column(nullable = false)
    private String titleEn;

    private String titleSi;

    private String titleTa;
}
