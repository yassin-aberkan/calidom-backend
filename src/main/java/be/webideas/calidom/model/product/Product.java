package be.webideas.calidom.model.product;

import be.webideas.calidom.model.CategoryType;
import be.webideas.calidom.model.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ElementCollection
    @CollectionTable(name = "product_descriptions", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "language_code")
    @Column(name = "description")
    private Map<String, String> descriptions;

    private String brand;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private ProductType productType;

    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private CategoryType categoryType;

    @Column(nullable = false)
    private String imageUrl;

    private String logoUrl;

    private Date expiredDate;
}
