package br.com.vinicius.cartoes.customer.repository;

import br.com.vinicius.cartoes.customer.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
