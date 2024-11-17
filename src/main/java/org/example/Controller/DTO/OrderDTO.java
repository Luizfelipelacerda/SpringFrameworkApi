package org.example.Controller.DTO;

import org.example.Model.Order;

import java.util.Date;

public class OrderDTO {
    private String name;
    private Date dataDeEnvio;
    private String sender;

    public OrderDTO() {
    }

//    public OrderDTO(String name, Date dataDeEnvio, String sender) {
//        this.name = name;
//        this.dataDeEnvio = dataDeEnvio;
//        this.sender = sender;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDataDeEnvio() {
        return dataDeEnvio;
    }

    public void setDataDeEnvio(Date dataDeEnvio) {
        this.dataDeEnvio = dataDeEnvio;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

//    public Order DtoToOrderMap(){
//        return new Order(this.getName(),this.getDataDeEnvio(),this.getSender());
//    }
}
