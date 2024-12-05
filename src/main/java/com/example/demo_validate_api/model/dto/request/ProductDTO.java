package com.example.demo_validate_api.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    @NotBlank(message = "Product name is empty!")
    private String proName;
    @NotBlank(message = "Producer is empty!")
    private String producer;
    @NotNull(message = "Year making is null!")
    private Integer yearMaking;
    @NotNull(message = "Expire date is null!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Expire date is not valid!")
    private Date expireDate;
    @NotNull(message = "Price is null!")
    private Double price;
}
