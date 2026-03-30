package lk.rumex.ott_domain_models.screen.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lk.rumex.ott_domain_models.country.model.Country;
import lk.rumex.ott_domain_models.shared.model.MasterBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "screens")
public class Screen extends MasterBase {

    @NotNull
    @Column(name = "seq_no", nullable = false)
    private Integer seqNo;

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("seqNo ASC")
    private List<ScreenSliderGraphic> screenSliderGraphics = new ArrayList<>();

    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("seqNo ASC")
    private List<ScreenCategory> screenCategories = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "screen_listing_countries",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Country> countries;
}
