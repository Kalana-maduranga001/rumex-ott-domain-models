package lk.rumex.ott_domain_models.category.model;

import jakarta.persistence.*;

import lk.rumex.ott_domain_models.category.Enum.CategoryTemplate;
import lk.rumex.ott_domain_models.country.model.Country;
import lk.rumex.ott_domain_models.shared.model.MasterBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category extends MasterBase {
    @Column(name = "description", length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category_template", nullable = false)
    private CategoryTemplate categoryTemplate;

    @Column(name = "seq_no", nullable = false)
    private Long seqNo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "category_id")
    private List<Media> mediaList;

    @ManyToMany
    @JoinTable(
            name = "category_listing_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Country> countries;
}
