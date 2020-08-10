package br.com.vinicius.cartoes.model;

public class PagamentoModel {

    private Long id;
    private Long cartao_id;
    private String descricao;
    private double valor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartao_id() {
        return cartao_id;
    }

    public void setCartao_id(Long cartao_id) {
        this.cartao_id = cartao_id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
