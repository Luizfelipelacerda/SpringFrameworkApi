package org.example.Controller;

import org.example.Controller.DTO.OrderDTO;
import org.example.Model.Order;
import org.example.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Order/")
public class OrderController {
    @Autowired
    private final OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("isOkay")
    public String isOkay(){
        return "Projeto feito em Spring Framework";
    }
    @GetMapping()
    public String isOkay2(){
        return "Projeto feito em Spring Framework";
    }
    @GetMapping("getOrders")
    public ResponseEntity<List<Order>> getOrders(){

        List<Order> allOrders = this.orderService.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @PostMapping("CreateNewOrder")
    public ResponseEntity<Order> createNewOrder(@RequestBody OrderDTO orderDTO){
        Order newOrder = this.orderService.createNewOrder(orderDTO);
        return ResponseEntity.ok(newOrder);
    }
}
