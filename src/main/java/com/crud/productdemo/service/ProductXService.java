package com.crud.productdemo.service;

import com.crud.productdemo.entity.ProductX;
import com.crud.productdemo.repository.ProductXRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductXService {

    @Autowired
    ProductXRepository productXRepository;

    public List<ProductX> list(){
        return productXRepository.findAll();
    }

    public Boolean existsByDiscountCode(Integer discountCode){
        return productXRepository.existsByDiscountCode(discountCode);
    }

    public void  save(ProductX producto){
        productXRepository.save(producto);
    }

    public void delete(int id){
        productXRepository.deleteById(id);
    }

}
