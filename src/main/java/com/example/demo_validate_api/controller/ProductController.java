package com.example.demo_validate_api.controller;

import com.example.demo_validate_api.model.dto.request.ProductDTO;
import com.example.demo_validate_api.model.dto.request.ProductDTOUpdate;
import com.example.demo_validate_api.model.dto.response.DataResponse;
import com.example.demo_validate_api.model.entity.Product;
import com.example.demo_validate_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Product>>> getListProducts(){
        return new ResponseEntity<>(new DataResponse<>(productService.getProducts(), HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Product>> insertProduct(@Valid @RequestBody ProductDTO productDTO){
        return  new ResponseEntity<>(new DataResponse<>(productService.insertProduct(productDTO),HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @PutMapping("/{proId}")
    public ResponseEntity<DataResponse<Product>> updateProduct(@PathVariable Integer proId, @Valid @RequestBody ProductDTOUpdate productDTOUpdate){
        return  new ResponseEntity<>(new DataResponse<>(productService.updateProduct(proId,productDTOUpdate),HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{proId}")
    public ResponseEntity<DataResponse<Product>> getProductById(@PathVariable Integer proId){
        return new ResponseEntity<>(new DataResponse<>(productService.getProductById(proId),HttpStatus.OK),HttpStatus.OK);
    }

    @DeleteMapping("/{proId}")
    public ResponseEntity<DataResponse<String>> deleteProduct(@PathVariable Integer proId){
        productService.deleteProduct(proId);
        return new ResponseEntity<>(new DataResponse<>("Đã xóa sản phẩm có id: "+proId,HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/searchProductByName/{proName}")
    public ResponseEntity<DataResponse<List<Product>>> getProductsByName(@PathVariable String proName){
        return new ResponseEntity<>(new DataResponse<>(productService.getProductsByName(proName),HttpStatus.OK),HttpStatus.OK);
    }
}
