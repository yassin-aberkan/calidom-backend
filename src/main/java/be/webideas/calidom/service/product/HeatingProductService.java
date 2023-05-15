package be.webideas.calidom.service.product;

import be.webideas.calidom.model.product.HeatingProduct;
import be.webideas.calidom.model.product.Product;
import be.webideas.calidom.repository.product.HeatingProductRepository;
import be.webideas.calidom.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeatingProductService {
    @Autowired
    private HeatingProductRepository heatingProductRepository;

    @Autowired
    private ProductService productService;

    public List<HeatingProduct> getAllProducts() {
        return heatingProductRepository.findAll();
    }

    public HeatingProduct getProductById(Long id) {
        return heatingProductRepository.findHeatingProductById(id).orElse(null);
    }

    public HeatingProduct createProduct(HeatingProduct product) {
        if (product == null) {
            throw new RuntimeException("Failed to save product");
        }
        return heatingProductRepository.save(product);
    }

    public HeatingProduct updateProduct(Long id, HeatingProduct product) {
        HeatingProduct existingProduct = getProductById(id);
        if (existingProduct == null) {
            return null;
        }
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return heatingProductRepository.save(existingProduct);
    }

    public void deleteProduct(Long id) {
        heatingProductRepository.deleteById(id);
    }
}
