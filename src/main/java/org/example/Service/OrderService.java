package org.example.Service;

import org.example.Controller.DTO.OrderDTO;
import org.example.Controller.Mapper.OrderMapper;
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

    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }


    public OrderDTO createNewOrder(OrderDTO orderDTO){
        if(orderDTO == null){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

        Order savedOrder = this.orderRepository.save(orderDTO.DtoToOrderMap());

        OrderDTO savedOrderDTO = orderMapper.toDTO(savedOrder);

        return savedOrderDTO;

    }


    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
}
