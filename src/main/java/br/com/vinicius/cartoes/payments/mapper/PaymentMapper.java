package br.com.vinicius.cartoes.payments.mapper;

import br.com.vinicius.cartoes.payments.entity.PaymentEntity;
import br.com.vinicius.cartoes.payments.model.PaymentModel;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    private PaymentMapper() {}

    public PaymentModel to (PaymentEntity entity){
        PaymentModel model = new PaymentModel();
        model.setDescription(entity.getDescription());
        model.setId(entity.getId());
        model.setCard_id(entity.getCard_id());
        model.setValue(entity.getValue());

        return model;
    }

    public PaymentEntity from (PaymentModel model) {
        PaymentEntity entity = new PaymentEntity();
        entity.setDescription(model.getDescription());
        entity.setValue(model.getValue());
        entity.setCard_id(model.getCard_id());

        return entity;
    }

}
