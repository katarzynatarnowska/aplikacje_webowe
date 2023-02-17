package com.restaurant.service;

import com.restaurant.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import com.restaurant.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;


@Service
public class OrderDetailService {


   @Autowired
   private OrderDetailRepository orderDetailRepository;

    public void addOrderDetail(OrderDetail orderDetail){
        orderDetailRepository.save(orderDetail);
    }

}
