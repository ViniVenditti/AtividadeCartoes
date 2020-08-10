package br.com.vinicius.cartoes.repository;

import br.com.vinicius.cartoes.entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<PagamentoEntity, Long> {
}
