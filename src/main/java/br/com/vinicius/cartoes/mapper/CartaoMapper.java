package br.com.vinicius.cartoes.mapper;

import br.com.vinicius.cartoes.entity.CartaoEntity;
import br.com.vinicius.cartoes.model.CartaoModel;
import org.springframework.stereotype.Component;

@Component
public class CartaoMapper {

    private CartaoMapper(){}

    public CartaoModel to (CartaoEntity entity) {
        CartaoModel model = new CartaoModel();
        model.setId(entity.getId());
        model.setAtivo(entity.isAtivo());
        model.setClienteId(entity.getClienteId());
        model.setNumero(entity.getNumero());

        return model;
    }

    public CartaoEntity from (CartaoModel model) {
        CartaoEntity entity = new CartaoEntity();
        entity.setAtivo(false);
        entity.setNumero(model.getNumero());
        entity.setClienteId(model.getClienteId());

        return entity;
    }
}
