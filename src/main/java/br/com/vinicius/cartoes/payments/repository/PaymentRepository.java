package br.com.vinicius.cartoes.payments.repository;

import br.com.vinicius.cartoes.payments.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
