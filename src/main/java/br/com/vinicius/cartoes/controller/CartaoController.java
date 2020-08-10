package br.com.vinicius.cartoes.controller;

import br.com.vinicius.cartoes.entity.CartaoEntity;
import br.com.vinicius.cartoes.mapper.CartaoMapper;
import br.com.vinicius.cartoes.model.CartaoDTO;
import br.com.vinicius.cartoes.model.CartaoModel;
import br.com.vinicius.cartoes.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cartao")
public class CartaoController {

    @Autowired
    private CartaoMapper mapper;
    @Autowired
    private CartaoService service;

    @PostMapping
    public ResponseEntity<CartaoModel> criarCartao(@RequestBody CartaoModel model) {
        CartaoEntity entity = mapper.from(model);
        CartaoModel newCard = service.createCard(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCard);
    }

    @PutMapping(value = "/{numero}")
    public ResponseEntity<CartaoModel> atualizarCartao(@PathVariable String numero, @RequestBody CartaoModel cartaoModel) {
        CartaoModel cartao = service.updateCard(numero, cartaoModel);
        return ResponseEntity.status(HttpStatus.OK).body(cartao);
    }

    @GetMapping(value = "/{numero}")
    public ResponseEntity<CartaoDTO> consultarCartao(@PathVariable String numero) {
        CartaoModel cartao = service.buscarCartao(numero);
        CartaoDTO dto = mapper.mapperdto(cartao);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
