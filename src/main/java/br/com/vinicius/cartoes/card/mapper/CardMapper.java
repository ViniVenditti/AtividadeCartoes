package br.com.vinicius.cartoes.card.mapper;

import br.com.vinicius.cartoes.card.entity.CardEntity;
import br.com.vinicius.cartoes.card.model.CardDTO;
import br.com.vinicius.cartoes.card.model.CardModel;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    private CardMapper(){}

    public CardModel to (CardEntity entity) {
        CardModel model = new CardModel();
        model.setId(entity.getId());
        model.setActive(entity.isActive());
        model.setCustomerId(entity.getCustomerId());
        model.setNumber(entity.getNumber());

        return model;
    }

    public CardEntity from (CardModel model) {
        CardEntity entity = new CardEntity();
        entity.setActive(false);
        entity.setNumber(model.getNumber());
        entity.setCustomerId(model.getCustomerId());

        return entity;
    }

    public CardDTO mapperdto (CardModel model) {
        CardDTO dto = new CardDTO();
        dto.setCustomerId(model.getCustomerId());
        dto.setId(model.getId());
        dto.setNumber(model.getNumber());

        return dto;
    }
}
