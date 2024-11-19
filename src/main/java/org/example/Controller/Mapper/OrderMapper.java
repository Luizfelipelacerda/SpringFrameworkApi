package org.example.Controller.Mapper;

import org.example.Controller.DTO.OrderDTO;
import org.example.Model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order){
        return new OrderDTO(order.getName(),order.getDataDeEnvio(),order.getSender());
    }

    public Order toEntity(OrderDTO dto){
        return new Order(dto.getName(), dto.getDataDeEnvio(), dto.getSender());
    }
}