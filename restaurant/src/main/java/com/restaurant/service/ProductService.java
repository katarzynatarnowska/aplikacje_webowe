package com.restaurant.service;

import com.restaurant.model.Product;
import com.restaurant.payload.ProductRequest;
import com.restaurant.payload.ProductResponse;

public interface ProductService {

    long addProduct(ProductRequest productRequest);
    ProductResponse getProductById(long id_products );
    void reduceQuantity(long id_product, long quantity);

    public void deleteProductById(long id_product);
}
