package br.com.vinicius.cartoes.payments.controller;

import br.com.vinicius.cartoes.payments.entity.PaymentEntity;
import br.com.vinicius.cartoes.payments.mapper.PaymentMapper;
import br.com.vinicius.cartoes.payments.model.PaymentModel;
import br.com.vinicius.cartoes.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamento")
public class PaymentController {

    @Autowired
    private PaymentService service;
    @Autowired
    private PaymentMapper mapper;

    @PostMapping
    public ResponseEntity<PaymentModel> realizarPagamento(@RequestBody PaymentModel pagamento) {
        PaymentEntity entity = mapper.from(pagamento);
        PaymentModel model = service.salvarCompra(entity);

        return ResponseEntity.status(HttpStatus.CREATED).body(model);
    }

    @GetMapping(value = "/{id_cartao}")
    public ResponseEntity<List<PaymentModel>> consultarExtrato(@PathVariable Long id_cartao) {
        List<PaymentModel> lista = service.extratoPagamento(id_cartao);

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

}
