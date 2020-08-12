package br.com.vinicius.cartoes.customer.service;

import br.com.vinicius.cartoes.customer.entity.CustomerEntity;
import br.com.vinicius.cartoes.exceptions.ClienteNotFoundException;
import br.com.vinicius.cartoes.customer.mapper.CustomerMapper;
import br.com.vinicius.cartoes.customer.model.CustomerModel;
import br.com.vinicius.cartoes.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerMapper mapper;

    public CustomerModel createCustomer(CustomerEntity entity) {
        CustomerEntity newUser = repository.save(entity);

        return mapper.to(newUser);
    }

    public CustomerModel findCustomer(Long clienteId){
        Optional<CustomerEntity> entity = repository.findById(clienteId);
        if(entity.isPresent())
            return mapper.to(entity.get());

        throw new ClienteNotFoundException();
    }
}

