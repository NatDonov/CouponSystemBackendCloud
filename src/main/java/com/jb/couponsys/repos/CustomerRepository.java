package com.jb.couponsys.repos;

import com.jb.couponsys.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, int customerId);

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
