package br.com.vinicius.cartoes.mapper;

import br.com.vinicius.cartoes.entity.ClienteEntity;
import br.com.vinicius.cartoes.model.ClienteModel;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    private ClienteMapper(){}

    public ClienteEntity from (ClienteModel model){
        ClienteEntity entity = new ClienteEntity();
        entity.setNomeCliente(model.getName());
        return entity;
    }

    public ClienteModel to (ClienteEntity entity) {
        ClienteModel model = new ClienteModel();
        model.setId(entity.getClienteId());
        model.setName(entity.getNomeCliente());
        return model;
    }
}
