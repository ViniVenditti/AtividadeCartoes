package br.com.vinicius.cartoes.service;

import br.com.vinicius.cartoes.entity.ClienteEntity;
import br.com.vinicius.cartoes.mapper.ClienteMapper;
import br.com.vinicius.cartoes.model.ClienteModel;
import br.com.vinicius.cartoes.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private ClienteRepository repository;
    private ClienteMapper mapper;

    public ClienteService(ClienteRepository repository, ClienteMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteModel createUser(ClienteEntity entity) {
        ClienteEntity newUser = this.repository.save(entity);

        return mapper.to(newUser);
    }

    public ClienteModel buscarCliente(Long clienteId){
        Optional<ClienteEntity> entity = this.repository.findById(clienteId);
        if(entity.isPresent())
            return mapper.to(entity.get());
        return null;
    }
}

