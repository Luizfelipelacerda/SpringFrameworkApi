package org.example.Controller;

import org.example.Model.Product;
import org.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Product>> getProduct(){

        List<Product> list = this.productService.getAllProducts();
        return ResponseEntity.ok(list);
    }

    @PostMapping("createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product productSalvo = this.productService.createProduct(product);
        return ResponseEntity.ok(productSalvo);
    }

    @PostMapping("findProductById")
    public ResponseEntity<Product> findById(@RequestParam Long productId){
        Product product = this.productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("deleteProduct")
    public ResponseEntity deleteProduct(@RequestParam Long productId){
        this.productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }


    @GetMapping()
    public String isOkay(){
        return "kkk";
    }

}
