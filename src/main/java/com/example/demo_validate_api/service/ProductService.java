package com.example.demo_validate_api.service;

import com.example.demo_validate_api.model.dto.request.ProductDTO;
import com.example.demo_validate_api.model.dto.request.ProductDTOUpdate;
import com.example.demo_validate_api.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProductById(Integer proId);
    Product insertProduct(ProductDTO productDTO);
    Product updateProduct(Integer proId, ProductDTOUpdate productDTOUpdate);
    void deleteProduct(Integer proId);
    List<Product> getProductsByName(String proName);
}
