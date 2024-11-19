package org.example.Controller;

import org.example.Controller.DTO.ProductDTO;
import org.example.Model.Product;
import org.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public ResponseEntity<List<ProductDTO>> getProducts(){

        List<ProductDTO> list = this.productService.getAllProducts();
        return ResponseEntity.ok(list);
    }

    @GetMapping("getAllPages")
    public ResponseEntity<Page<ProductDTO>> getProductsPages(
            @PageableDefault(size = 10, page = 0) Pageable pageable){

        Page<ProductDTO> pageProductDto = this.productService.getAllPageableProducts(pageable);
        return ResponseEntity.ok(pageProductDto);
    }

    @GetMapping("getByNamePages")
    public ResponseEntity<Page<ProductDTO>> getProductsByNamePages(
            @PageableDefault(size = 10, page = 0) Pageable pageable,
            @RequestParam String nome){

        Page<ProductDTO> pageProductDto = this.productService.getAllProductsByNamePageable(pageable, nome);
        return ResponseEntity.ok(pageProductDto);
    }

    @PostMapping("createProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO product){
        ProductDTO productSalvo = this.productService.createProduct(product);
        return ResponseEntity.ok(productSalvo);
    }

    @PostMapping("findProductById")
    public ResponseEntity<ProductDTO> findById(@RequestParam Long productId){
        ProductDTO product = this.productService.getProductById(productId);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("deleteProduct")
    public ResponseEntity deleteProduct(@RequestParam Long productId){
        this.productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }




}
