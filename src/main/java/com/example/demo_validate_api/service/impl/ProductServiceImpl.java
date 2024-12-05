package com.example.demo_validate_api.service.impl;

import com.example.demo_validate_api.model.dto.request.ProductDTO;
import com.example.demo_validate_api.model.dto.request.ProductDTOUpdate;
import com.example.demo_validate_api.model.entity.Product;
import com.example.demo_validate_api.repository.ProductRepository;
import com.example.demo_validate_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer proId) {
        return productRepository.findById(proId).orElseThrow(()->new NoSuchElementException("Product id not found!"));
    }

    @Override
    public Product insertProduct(ProductDTO productDTO) {
        Product product = Product.builder()
                .proName(productDTO.getProName())
                .producer(productDTO.getProducer())
                .yearMaking(productDTO.getYearMaking())
                .expireDate(productDTO.getExpireDate())
                .price(productDTO.getPrice())
                .status(true)
                .build();
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Integer proId, ProductDTOUpdate productDTOUpdate) {
        Product product = productRepository.findById(proId).orElseThrow(() -> new NoSuchElementException("Product id not found!"));
        product.setProName(productDTOUpdate.getProName());
        product.setProducer(productDTOUpdate.getProducer());
        product.setYearMaking(productDTOUpdate.getYearMaking());
        product.setExpireDate(productDTOUpdate.getExpireDate());
        product.setPrice(productDTOUpdate.getPrice());
        product.setStatus(productDTOUpdate.getStatus());

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer proId) {
        Product product = productRepository.findById(proId).orElseThrow(() -> new NoSuchElementException("Product id not found!"));
        productRepository.delete(product);
    }

    @Override
    public List<Product> getProductsByName(String proName) {
        return productRepository.findProductsByProNameContainsIgnoreCase(proName);
    }
}
