package br.com.vinicius.cartoes.payments.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentModel {

    private Long id;

    @JsonProperty("cartao_id")
    private Long card_id;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("valor")
    private double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCard_id() {
        return card_id;
    }

    public void setCard_id(Long card_id) {
        this.card_id = card_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
