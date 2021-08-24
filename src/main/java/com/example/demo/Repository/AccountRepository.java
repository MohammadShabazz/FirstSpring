package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.http.server.PathContainer.Options;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Account;

//import antlr.collections.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
	Optional<Account> findByEmail(String email);

	@Query(value = "select * from users  where id=:identy", nativeQuery = true)
	Optional<Account> findByAccount(Long identy);

	@Query(value = "select firstname from users  where id=:identy", nativeQuery = true)
	String findnameByAccount(Long identy);

}
