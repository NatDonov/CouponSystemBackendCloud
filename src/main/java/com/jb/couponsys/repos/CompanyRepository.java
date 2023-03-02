package com.jb.couponsys.repos;

import com.jb.couponsys.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByName(String name);
    boolean existsByEmail(String email);
    boolean existsByEmailAndIdNot(String email, int companyId);

    Optional<Company> findByEmailAndPassword(String email, String password);






}
