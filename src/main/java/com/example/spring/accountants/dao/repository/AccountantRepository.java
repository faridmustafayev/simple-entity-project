package com.example.spring.accountants.dao.repository;

import com.example.spring.accountants.dao.entity.AccountantEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountantRepository extends CrudRepository<AccountantEntity, Long> {
    @Override
    List<AccountantEntity> findAll();

    // native query language

//    @Query(nativeQuery = true, value = "SELECT * FROM accountants WHERE status =:status")
//    List<AccountantEntity> getWithStatus(String status);
//
//    @Query(nativeQuery = true, value = "SELECT * FROM accountants WHERE email =:email")
//    List<AccountantEntity> getWithEmail(String email);

    //JPQL(Java persistence query language)

//    @Query("SELECT a FROM AccountantEntity a WHERE a.status =:status")
//    List<AccountantEntity> getWithStatus(AccountantStatus status);
//
//    @Query("SELECT a FROM AccountantEntity a WHERE a.email =:email")
//    List<AccountantEntity> getWithEmail(String email);

}
