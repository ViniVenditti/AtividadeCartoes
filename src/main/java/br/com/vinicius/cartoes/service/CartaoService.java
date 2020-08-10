package br.com.vinicius.cartoes.service;

import br.com.vinicius.cartoes.entity.CartaoEntity;
import br.com.vinicius.cartoes.entity.ClienteEntity;
import br.com.vinicius.cartoes.exceptions.CartaoNotFoundException;
import br.com.vinicius.cartoes.exceptions.ClienteNotFoundException;
import br.com.vinicius.cartoes.mapper.CartaoMapper;
import br.com.vinicius.cartoes.model.CartaoModel;
import br.com.vinicius.cartoes.model.ClienteModel;
import br.com.vinicius.cartoes.repository.CartaoRepository;
import br.com.vinicius.cartoes.repository.ClienteRepository;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    private CartaoMapper mapper;
    private CartaoRepository cartaoRepository;
    private ClienteRepository clienteRepository;


    private CartaoService(CartaoMapper mapper, CartaoRepository repository, ClienteRepository clienteRepository) {
        this.mapper = mapper;
        this.cartaoRepository = repository;
        this.clienteRepository = clienteRepository;
    }

    public CartaoModel createCard(CartaoEntity entity) {
        CartaoEntity newCard;
        Optional<ClienteEntity> cliente = this.clienteRepository.findById(entity.getClienteId());
        if(cliente.isPresent()) {
            newCard = this.cartaoRepository.save(entity);
            return mapper.to(newCard);
        }
        throw new ClienteNotFoundException();
    }

    public CartaoModel updateCard(String numero, CartaoModel cartao) {
        Optional<CartaoEntity> entity = this.cartaoRepository.findCardByNumber(numero);
        if(entity.isPresent()){
            CartaoEntity cartaoEntity = entity.get();
            cartaoEntity.setAtivo(cartao.isAtivo());
            CartaoEntity cartaoAtualizado = this.cartaoRepository.save(cartaoEntity);
            return mapper.to(cartaoAtualizado);
        } else
            throw new CartaoNotFoundException();
    }

    public CartaoModel buscarCartao(String numero) {
        Optional<CartaoEntity> cartao = this.cartaoRepository.findCardByNumber(numero);
        if(cartao.isPresent())
            return mapper.to(cartao.get());
        throw new CartaoNotFoundException();
    }

}