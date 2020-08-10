package br.com.vinicius.cartoes.service;

import br.com.vinicius.cartoes.entity.CartaoEntity;
import br.com.vinicius.cartoes.entity.PagamentoEntity;
import br.com.vinicius.cartoes.exceptions.CartaoNaoHabilitadoException;
import br.com.vinicius.cartoes.exceptions.CartaoNotFoundException;
import br.com.vinicius.cartoes.mapper.PagamentoMapper;
import br.com.vinicius.cartoes.model.PagamentoModel;
import br.com.vinicius.cartoes.repository.CartaoRepository;
import br.com.vinicius.cartoes.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoMapper mapper;
    @Autowired
    private PagamentoRepository repository;
    @Autowired
    private CartaoRepository cartaoRepository;

    public PagamentoModel salvarCompra(PagamentoEntity entity) {
        Optional<CartaoEntity> cartaoEntity = cartaoRepository.findById(entity.getCartao_id());

        if(cartaoEntity.isPresent()){
            if(cartaoEntity.get().isAtivo()){
                PagamentoEntity newPagamento = repository.save(entity);
                return mapper.to(newPagamento);
            }else
                throw new CartaoNaoHabilitadoException();
        }else
            throw new CartaoNotFoundException();
    }

    public List<PagamentoModel> extratoPagamento(Long id_cartao) {
        List<PagamentoEntity> listaEntity = repository.findAll();
        return listaEntity
                .stream()
                .map(entity -> mapper.to(entity))
                .collect(Collectors.toList());
    }

}
