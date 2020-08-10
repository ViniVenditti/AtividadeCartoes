package br.com.vinicius.cartoes.controller;

import br.com.vinicius.cartoes.entity.PagamentoEntity;
import br.com.vinicius.cartoes.mapper.PagamentoMapper;
import br.com.vinicius.cartoes.model.PagamentoModel;
import br.com.vinicius.cartoes.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService service;
    @Autowired
    private PagamentoMapper mapper;

    @PostMapping
    public ResponseEntity<PagamentoModel> realizarPagamento(@RequestBody PagamentoModel pagamento) {
        PagamentoEntity entity = mapper.from(pagamento);
        PagamentoModel model = service.salvarCompra(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }

    @GetMapping(value = "/{id_cartao}")
    public ResponseEntity<List<PagamentoModel>> consultarExtrato(@PathVariable Long id_cartao) {
        List<PagamentoModel> lista = service.extratoPagamento(id_cartao);

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}
