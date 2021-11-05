package com.crud.productdemo.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ProductXDto {

    @NotBlank
    private String email;
    @Min(0)
    private Long count;
    private Integer discountCode;

}
