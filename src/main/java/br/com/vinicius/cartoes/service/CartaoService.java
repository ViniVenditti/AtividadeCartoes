package br.com.vinicius.cartoes.service;

import br.com.vinicius.cartoes.entity.CartaoEntity;
import br.com.vinicius.cartoes.entity.ClienteEntity;
import br.com.vinicius.cartoes.exceptions.CartaoExistenteException;
import br.com.vinicius.cartoes.exceptions.CartaoNotFoundException;
import br.com.vinicius.cartoes.exceptions.ClienteNotFoundException;
import br.com.vinicius.cartoes.mapper.CartaoMapper;
import br.com.vinicius.cartoes.model.CartaoModel;
import br.com.vinicius.cartoes.repository.CartaoRepository;
import br.com.vinicius.cartoes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartaoService {

    @Autowired
    private CartaoMapper mapper;
    @Autowired
    private CartaoRepository cartaoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public CartaoModel createCard(CartaoEntity entity) {
        CartaoEntity newCard;
        Optional<ClienteEntity> cliente = clienteRepository.findById(entity.getClienteId());
        Optional<CartaoEntity> cartao = cartaoRepository.findCardByNumero(entity.getNumero());
        if(cliente.isPresent() && cartao.isEmpty()) {
            newCard = cartaoRepository.save(entity);
            return mapper.to(newCard);
        } else if (cartao.isPresent())
            throw new CartaoExistenteException();

        throw new ClienteNotFoundException();
    }

    public CartaoModel updateCard(String numero, CartaoModel cartao) {
        Optional<CartaoEntity> entity = cartaoRepository.findCardByNumero(numero);
        if(entity.isPresent()){
            CartaoEntity cartaoEntity = entity.get();
            cartaoEntity.setAtivo(cartao.isAtivo());
            CartaoEntity cartaoAtualizado = cartaoRepository.save(cartaoEntity);
            return mapper.to(cartaoAtualizado);
        } else
            throw new CartaoNotFoundException();
    }

    public CartaoModel buscarCartao(String numero) {
        Optional<CartaoEntity> cartao = cartaoRepository.findCardByNumero(numero);
        if(cartao.isPresent())
            return mapper.to(cartao.get());
        throw new CartaoNotFoundException();
    }

}