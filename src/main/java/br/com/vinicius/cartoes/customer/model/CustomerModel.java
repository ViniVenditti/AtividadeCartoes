package br.com.vinicius.cartoes.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class CustomerModel {

    private Long id;

    @NotNull
    @NotBlank
    @JsonProperty("nome")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
