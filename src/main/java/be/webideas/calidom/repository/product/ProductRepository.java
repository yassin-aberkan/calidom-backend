package be.webideas.calidom.repository.product;

import be.webideas.calidom.model.CategoryType;
import be.webideas.calidom.model.ProductType;
import be.webideas.calidom.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductType(ProductType productType);

    @Query("SELECT p FROM Product p WHERE p.productType = ?1 AND p.expiredDate >= CURRENT_DATE")
    List<Product> findByProductTypeAndNotExpired(ProductType productType);

    List<Product> findByCategoryType(CategoryType categoryType);

    @Query("SELECT p FROM Product p WHERE p.categoryType = ?1 AND p.expiredDate >= CURRENT_DATE")
    List<Product> findByCategoryTypeAndNotExpired(CategoryType categoryType);

}
