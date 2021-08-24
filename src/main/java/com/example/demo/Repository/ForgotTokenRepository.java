package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.Account;
import com.example.demo.modal.ForgotToken;

@Repository
public interface ForgotTokenRepository extends JpaRepository<ForgotToken, Long>{

	Optional<ForgotToken> findByresettoken(String token);

	
}
 