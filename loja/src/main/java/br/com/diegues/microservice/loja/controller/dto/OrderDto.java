package br.com.diegues.microservice.loja.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class OrderDto {

    @JsonIgnore
    private Long crompraId;

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

    public Long getCrompraId() {
        return crompraId;
    }

    public void setCrompraId(Long crompraId) {
        this.crompraId = crompraId;
    }
}
