//package com.restaurant.service;
//
//import com.restaurant.model.Product;
//import com.restaurant.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//
//import java.util.List;
//
//public interface ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//
//
//   public List<Product> findAllProducts(){
//       return productRepository.findAll();
//   }
//
//    public Page<Product> findProductsWithPagination(int offset, int pageSize){
//        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
//        return  products;
//    }
//
//
//}
