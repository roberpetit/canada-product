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
@RequestMapping("/producto")
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
    public ResponseEntity<?> create(@RequestBody ProductXDto productoDto){
        if(productXService.existsByDiscountCode(productoDto.getDiscountCode())
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        ProductX producto = new ProductX(productoDto.getNombre(), productoDto.getPrecio());
        productXService.save(producto);
        return new ResponseEntity(new Message("producto creado"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!productXService.existsById(id))
            return new ResponseEntity(new Message("no existe"), HttpStatus.NOT_FOUND);
        productXService.delete(id);
        return new ResponseEntity(new Message("producto eliminado"), HttpStatus.OK);
    }


}
