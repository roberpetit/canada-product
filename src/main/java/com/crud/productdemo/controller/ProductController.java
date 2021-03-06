package com.crud.productdemo.controller;

import com.crud.productdemo.dto.Message;
import com.crud.productdemo.dto.ProductXDto;
import com.crud.productdemo.entity.ProductX;
import com.crud.productdemo.service.ProductXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productX")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    @Autowired
    ProductXService productXService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductX>> list(){
        List<ProductX> list = productXService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProductXDto productXDto){
        if(productXDto.getDiscountCode()!=null && productXService.existsByDiscountCode(productXDto.getDiscountCode()))
            return new ResponseEntity(new Message("Discount code repeated"), HttpStatus.BAD_REQUEST);
        if(productXDto.getCount()<1) {
            return new ResponseEntity(new Message("At least one product must be ordered"), HttpStatus.BAD_REQUEST);
        }

        ProductX producto = new ProductX(productXDto.getEmail(), productXDto.getCount(), productXDto.getDiscountCode());
        productXService.save(producto);
        return new ResponseEntity(new Message("ProductX succesfully ordered"), HttpStatus.OK);
    }

}
