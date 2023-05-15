package be.webideas.calidom.service.product;

import be.webideas.calidom.model.CategoryType;
import be.webideas.calidom.model.ProductType;
import be.webideas.calidom.model.product.Product;
import be.webideas.calidom.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductsByProductType(ProductType productType) {
        return productRepository.findByProductTypeAndNotExpired(productType);
    }

    public List<Product> getProductsByCategoryType(CategoryType categoryType) {
        return productRepository.findByCategoryTypeAndNotExpired(categoryType);
    }

    public Product createProduct(Product product) {
        Product p = product;
        return productRepository.save(p);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = getProductById(id);
        if (existingProduct == null) {
            return null;
        }
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
