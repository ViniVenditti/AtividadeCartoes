package br.com.vinicius.cartoes.repository;

import br.com.vinicius.cartoes.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
