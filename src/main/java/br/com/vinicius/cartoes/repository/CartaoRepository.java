package br.com.vinicius.cartoes.repository;

import br.com.vinicius.cartoes.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Long> {

    @Query("select c from CartaoEntity c where c.numero = :numero")
    Optional<CartaoEntity> findCardByNumber(String numero);

}
