package br.com.vinicius.cartoes.controller;

import javax.validation.Valid;

import br.com.vinicius.cartoes.entity.ClienteEntity;
import br.com.vinicius.cartoes.mapper.ClienteMapper;
import br.com.vinicius.cartoes.model.ClienteModel;
import br.com.vinicius.cartoes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;
    @Autowired
    private ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteModel> cadastrarCliente(@Valid @RequestBody ClienteModel cliente) {
        ClienteEntity entity = mapper.from(cliente);
        ClienteModel newUser = service.createUser(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping(value = "/{clienteId}")
    public ResponseEntity<ClienteModel> consultarCliente(@PathVariable Long clienteId) {
        ClienteModel user = service.buscarCliente(clienteId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
