package br.com.vinicius.cartoes.card.service;

import br.com.vinicius.cartoes.customer.service.CustomerService;
import br.com.vinicius.cartoes.card.entity.CardEntity;
import br.com.vinicius.cartoes.exceptions.CartaoExistenteException;
import br.com.vinicius.cartoes.exceptions.CartaoNotFoundException;
import br.com.vinicius.cartoes.card.mapper.CardMapper;
import br.com.vinicius.cartoes.card.model.CardModel;
import br.com.vinicius.cartoes.customer.model.CustomerModel;
import br.com.vinicius.cartoes.card.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardMapper mapper;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CustomerService customerService;

    public CardModel createCard(CardEntity entity) {
        CardEntity newCard;
        CustomerModel cliente = customerService.findCustomer(entity.getCustomerId());
        Optional<CardEntity> cartao = cardRepository.findCardByNumber(entity.getNumber());
        if(cartao.isEmpty()) {
            newCard = cardRepository.save(entity);
            return mapper.to(newCard);
        } else
            throw new CartaoExistenteException();
    }

    public CardModel updateCard(String numero, CardModel cartao) {
        Optional<CardEntity> entity = cardRepository.findCardByNumber(numero);
        if(entity.isPresent()){
            CardEntity cardEntity = entity.get();
            cardEntity.setActive(cartao.isActive());
            CardEntity cartaoAtualizado = cardRepository.save(cardEntity);
            return mapper.to(cartaoAtualizado);
        } else
            throw new CartaoNotFoundException();
    }

    public CardModel findCard(String numero) {
        Optional<CardEntity> cartao = cardRepository.findCardByNumber(numero);
        if(cartao.isPresent())
            return mapper.to(cartao.get());
        throw new CartaoNotFoundException();
    }

}