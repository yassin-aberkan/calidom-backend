package be.webideas.calidom.repository.product;

import be.webideas.calidom.model.product.HeatingProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeatingProductRepository extends JpaRepository<HeatingProduct, Long> {
    @Query("SELECT h FROM HeatingProduct h JOIN Product p ON h.id = p.id WHERE h.id = :id")
    Optional<HeatingProduct> findHeatingProductById(@Param("id") Long id);
}
