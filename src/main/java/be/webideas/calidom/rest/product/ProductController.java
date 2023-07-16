package be.webideas.calidom.rest.product;


import be.webideas.calidom.model.CategoryType;
import be.webideas.calidom.model.ProductType;
import be.webideas.calidom.model.product.Product;
import be.webideas.calidom.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/public/product/{productId}")
    public Product getHeatingProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/public/product/")
    public List<Product> getHeatingProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/public/product/type")
    public List<Product> getHeatingProductsByType(@RequestParam("productType") ProductType productType) {
        return productService.getProductsByProductType(productType);
    }

    @GetMapping("/public/product/category")
    public List<Product> getHeatingProductsByCategory(@RequestParam("categoryType") CategoryType categoryType) {
        return productService.getProductsByCategoryType(categoryType);
    }
}
