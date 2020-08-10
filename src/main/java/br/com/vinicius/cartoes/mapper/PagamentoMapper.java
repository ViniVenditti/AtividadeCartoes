package br.com.vinicius.cartoes.mapper;

import br.com.vinicius.cartoes.entity.PagamentoEntity;
import br.com.vinicius.cartoes.model.PagamentoModel;
import org.springframework.stereotype.Component;

@Component
public class PagamentoMapper {

    private PagamentoMapper() {}

    public PagamentoModel to (PagamentoEntity entity){
        PagamentoModel model = new PagamentoModel();
        model.setDescricao(entity.getDescricao());
        model.setId(entity.getId());
        model.setCartao_id(entity.getCartao_id());
        model.setValor(entity.getValor());

        return model;
    }

    public PagamentoEntity from (PagamentoModel model) {
        PagamentoEntity entity = new PagamentoEntity();
        entity.setDescricao(model.getDescricao());
        entity.setValor(model.getValor());
        entity.setCartao_id(model.getCartao_id());

        return entity;
    }

}
