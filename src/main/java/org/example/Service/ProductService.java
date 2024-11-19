package org.example.Service;

import org.example.Controller.DTO.ProductDTO;
import org.example.Controller.Mapper.ProductMapper;
import org.example.Model.Product;
import org.example.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    public List<ProductDTO> getAllProducts() {
        List<Product> all = this.productRepository.findAll();

        if(all.isEmpty()){
            throw new RuntimeException("no product found.");
        }
        return productMapper.toDTO(all);

    }

    public Page<ProductDTO> getAllPageableProducts(Pageable pageable) {
        Page<Product> allPage = this.productRepository.findAll(pageable);

        if(allPage.isEmpty()){
            throw new RuntimeException("no product found.");
        }
        return productMapper.toDTO(allPage);

    }

    @Transactional
    public ProductDTO createProduct(ProductDTO productDto) {
        Product product = this.productMapper.toEntity(productDto);
        Product productSaved = this.productRepository.save(product);
        return this.productMapper.toDTO(productSaved);
    }

    public ProductDTO getProductById(Long productId) {
        Optional<Product> byId = this.productRepository.findById(productId);

        if(!byId.isPresent()){
            throw new RuntimeException("Producto de Id "+productId+" não encontrado");
        }
        return this.productMapper.toDTO(byId.get());
    }

    @Transactional
    public void deleteProduct(Long productId) {
        Optional<Product> byId = this.productRepository.findById(productId);
        if(!byId.isPresent()){
            throw new RuntimeException("Producto de Id "+productId+" não encontrado");
        }
        this.productRepository.delete(byId.get());

    }

    public Page<ProductDTO> getAllProductsByNamePageable(Pageable pageable, String nome) {
        Page<Product> AllProductsByName = this.productRepository.findByNomeContaining(pageable, nome);
        if(AllProductsByName.isEmpty()){
            throw new RuntimeException("no product found.");
        }
        return productMapper.toDTO(AllProductsByName);
    }
}
