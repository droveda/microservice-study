package br.com.diegues.microservice.loja.controller.dto;

import java.util.List;

public class OrderDto {

    private List<OrderItemDto> items;

    private AddressDto address;

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
