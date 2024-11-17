package org.example.Service;

import org.example.Model.Product;
import org.example.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Product getProductById(Long productId) {
        Optional<Product> byId = this.productRepository.findById(productId);

        if(!byId.isPresent()){
            throw new RuntimeException("Producto de Id "+productId+" não encontrado");
        }
        return byId.get();
    }

    public void deleteProduct(Long productId) {
        Optional<Product> byId = this.productRepository.findById(productId);
        if(!byId.isPresent()){
            throw new RuntimeException("Producto de Id "+productId+" não encontrado");
        }
        this.productRepository.delete(byId.get());

    }
}
