package org.example.Service;

import org.example.Controller.DTO.OrderDTO;
import org.example.Model.Order;
import org.example.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createNewOrder(OrderDTO orderDTO){
        if(orderDTO == null){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        Order savedOrder = this.orderRepository.save(orderDTO.DtoToOrderMap());

        return savedOrder;

    }


    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
}
