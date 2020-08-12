package br.com.vinicius.cartoes.payments.service;

import br.com.vinicius.cartoes.card.entity.CardEntity;
import br.com.vinicius.cartoes.payments.entity.PaymentEntity;
import br.com.vinicius.cartoes.exceptions.CartaoNaoHabilitadoException;
import br.com.vinicius.cartoes.exceptions.CartaoNotFoundException;
import br.com.vinicius.cartoes.payments.mapper.PaymentMapper;
import br.com.vinicius.cartoes.payments.model.PaymentModel;
import br.com.vinicius.cartoes.card.repository.CardRepository;
import br.com.vinicius.cartoes.payments.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentMapper mapper;
    @Autowired
    private PaymentRepository repository;
    @Autowired
    private CardRepository cardRepository;

    public PaymentModel salvarCompra(PaymentEntity entity) {
        Optional<CardEntity> cartaoEntity = cardRepository.findById(entity.getCard_id());

        if(cartaoEntity.isPresent()){
            if(cartaoEntity.get().isActive()){
                PaymentEntity newPagamento = repository.save(entity);
                return mapper.to(newPagamento);
            }else
                throw new CartaoNaoHabilitadoException();
        }else
            throw new CartaoNotFoundException();
    }

    public List<PaymentModel> extratoPagamento(Long id_cartao) {
        List<PaymentEntity> listaEntity = repository.findAll();
        return listaEntity
                .stream()
                .map(entity -> mapper.to(entity))
                .collect(Collectors.toList());
    }

}
