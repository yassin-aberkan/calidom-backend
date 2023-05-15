package be.webideas.calidom.rest.product;

import be.webideas.calidom.model.product.HeatingProduct;
import be.webideas.calidom.service.product.HeatingProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HeatingProductController {

    @Autowired
    private HeatingProductService heatingProductService;

    @GetMapping("/public/product/heating/{productId}")
    public HeatingProduct getHeatingProductById(@PathVariable Long productId) {
        return heatingProductService.getProductById(productId);
    }

    @GetMapping("/public/product/heating")
    public List<HeatingProduct> getHeatingProducts() {
        return heatingProductService.getAllProducts();
    }

    @PostMapping("/product/heating/")
    public HeatingProduct createHeatingProduct(@RequestBody HeatingProduct product) {
        return heatingProductService.createProduct(product);
    }
}
