package lk.rumex.ott_domain_models.packageSubs.model;

import jakarta.persistence.*;

import lk.rumex.ott_domain_models.shared.model.BaseConfig;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "packages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Packages extends BaseConfig {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false, length = 10)
    private String currencyType;

    @Column(nullable = false)
    private Double monthlyPrice;

    @Column(nullable = false)
    private Double annualPrice;

    @ElementCollection
    @CollectionTable(name = "package_features", joinColumns = @JoinColumn(name = "package_id"))
    @Column(name = "feature")
    private List<String> features;

    @Column(length = 255)
    private String textField;
}
