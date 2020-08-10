package br.com.vinicius.cartoes.service;

import br.com.vinicius.cartoes.entity.ClienteEntity;
import br.com.vinicius.cartoes.mapper.ClienteMapper;
import br.com.vinicius.cartoes.model.ClienteModel;
import br.com.vinicius.cartoes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private ClienteMapper mapper;

    public ClienteModel createUser(ClienteEntity entity) {
        ClienteEntity newUser = repository.save(entity);

        return mapper.to(newUser);
    }

    public ClienteModel buscarCliente(Long clienteId){
        Optional<ClienteEntity> entity = repository.findById(clienteId);
        if(entity.isPresent())
            return mapper.to(entity.get());
        return null;
    }
}

