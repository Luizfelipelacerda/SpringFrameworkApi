package org.example.Controller.Mapper;

import org.example.Controller.DTO.ProductDTO;
import org.example.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductDTO toDTO(Product product){
        return new ProductDTO(product.getNome(), product.getCategory(), product.getImagem(), product.getPreco());
    }

    public Product toEntity(ProductDTO dto){
        return new Product(dto.getNome(),dto.getCategory(),dto.getImagem(), dto.getPreco());
    }

    public List<ProductDTO> toDTO(List<Product> productList){
        return productList.stream().map(prod -> this.toDTO(prod)).collect(Collectors.toList());
    }

    public List<Product> toEntity(List<ProductDTO> dtoList){
        return dtoList.stream().map(dto -> this.toEntity(dto)).collect(Collectors.toList());
    }

    public Page<ProductDTO> toDTO(Page<Product> productList){
        Page<ProductDTO> map = productList.map(this::toDTO);
        return map;
    }




}
