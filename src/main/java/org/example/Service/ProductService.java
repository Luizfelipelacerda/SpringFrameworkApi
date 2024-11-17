package org.example.Service;

import org.example.Model.Product;
import org.example.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        List<Product> all = this.productRepository.findAll();

        if(all.isEmpty()){
            throw new RuntimeException("no product found.");
        }
        return all;

    }

    public Product createProduct(Product product) {
        Product save = this.productRepository.save(product);
        return save;
    }
}
