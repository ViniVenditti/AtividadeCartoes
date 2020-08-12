package br.com.vinicius.cartoes.card.controller;

import br.com.vinicius.cartoes.card.entity.CardEntity;
import br.com.vinicius.cartoes.card.mapper.CardMapper;
import br.com.vinicius.cartoes.card.model.CardDTO;
import br.com.vinicius.cartoes.card.model.CardModel;
import br.com.vinicius.cartoes.card.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cartao")
public class CardController {

    @Autowired
    private CardMapper mapper;
    @Autowired
    private CardService service;

    @PostMapping
    public ResponseEntity<CardModel> criarCartao(@RequestBody @Valid CardModel model) {
        CardEntity entity = mapper.from(model);
        CardModel newCard = service.createCard(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(newCard);
    }

    @PutMapping(value = "/{numero}")
    public ResponseEntity<CardModel> atualizarCartao(@PathVariable String numero, @RequestBody @Valid CardModel cardModel) {
        CardModel cartao = service.updateCard(numero, cardModel);
        return ResponseEntity.status(HttpStatus.OK).body(cartao);
    }

    @GetMapping(value = "/{numero}")
    public ResponseEntity<CardDTO> consultarCartao(@PathVariable String numero) {
        CardModel cartao = service.findCard(numero);
        CardDTO dto = mapper.mapperdto(cartao);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
