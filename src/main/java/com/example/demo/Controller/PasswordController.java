package com.example.demo.Controller;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.boot.archive.spi.ArchiveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.ForgotTokenRepository;
import com.example.demo.Response.EmailService;
import com.example.demo.modal.Account;
import com.example.demo.modal.ForgotToken;

@Controller
public class PasswordController {

	@Autowired
	private AccountRepository accountService;

	@Autowired
	private ForgotTokenRepository forgotToken;

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<String> processForgotPasswordForm(@RequestParam("email") String userEmail,
			HttpServletRequest request) {
		Optional<Account> optional = accountService.findByEmail(userEmail);
		if (!optional.isPresent()) {
			throw new ArchiveException("not found user");
		} else {
			Account user = optional.get();
			ForgotToken t = new ForgotToken();
			ForgotToken prevtoken = user.getForgottoken();
			if (prevtoken != null) {
				t.setId(prevtoken.getId());
			}
			Random ron = new Random();
			t.setresettoken(((Integer) ron.nextInt(10000)).toString());
			user.setForgottoken(t);
			t.setAccount(user);
			accountService.save(user);
			String appUrl = request.getScheme() + "://" + request.getServerName();
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("shaikshabaz786@gmail.com");
			passwordResetEmail.setTo(user.getEmail());
			passwordResetEmail.setSubject("Password Reset Request");
			passwordResetEmail.setText("Hi To reset your password, click the link below:\n" + t.getresettoken());
			emailService.sendEmail(passwordResetEmail);
		}
		return ResponseEntity.ok().body("forgot password");
	}

	@PostMapping("/reset")
	public String resetPassword(@RequestParam Map<String, String> requestParams) {
		Optional<ForgotToken> forgottoken = forgotToken.findByresettoken(requestParams.get("token"));
		ForgotToken ft = forgottoken.get();
		Account account = accountService.getOne(ft.getAccount().getId());
		account.setPassword(requestParams.get("password"));
		account.setConfirmpassword(requestParams.get("confirmpassword"));
		ft.setresettoken(null);
		account.setForgottoken(ft);
		accountService.save(account);
		return "success";
	}
}