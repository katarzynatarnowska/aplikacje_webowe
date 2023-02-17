package com.restaurant.service;

import com.restaurant.model.Product;
import com.restaurant.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProductService {

  @Autowired
  private ProductRepository productRepository;
//  public Product findProductByName(String name);

  public List<Product> getAllProducts(String keyword) {

    return productRepository.findAll();
  }

  public List<Product>  getByKeyword(String keyword){

    return  productRepository.findByKeyword(keyword);
  }



  public Product getProductById(int id){
  return productRepository.findById(id);
}

}