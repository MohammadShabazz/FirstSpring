package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Response.SignupForm;
import com.example.demo.Storage.DBFileStorageService;
import com.example.demo.modal.Account;
import com.example.demo.modal.Address;

@RestController
@RequestMapping("/api/getme")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

	@Autowired

	AccountRepository accountrepository;

	@Autowired

	RoleRepository rolerepository;

	@Autowired

	AddressRepository addressrepository;

	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	private DBFileStorageService dbFileStorageService;

	@PostMapping("/signup")

	public ResponseEntity<String> registerUsers(@Valid @RequestBody SignupForm s) {

		Account a = new Account(s.getFirstname(), s.getLastname(), s.getDateofbirth(), s.getEmail(), s.getPassword(),
				s.getConfirmpassword(), s.getWorkexperiance(), s.getProfession(), s.getGenders(), s.getLanguage());

		for (Address address : s.getAddress()) {
			a.getAddress().add(address);
			address.setAccount(a);

		}
		accountrepository.save(a);

		return ResponseEntity.ok().body("Registration successfully");

	}

	@GetMapping("/getAccount/{id}")
	public Optional<Account> getAccount(@PathVariable(value = "id") Long id) {

		System.out.println("fetching the data");

		return accountrepository.findByAccount(id);

	}

	@GetMapping("/getname/{id}")
	public String getname(@PathVariable(value = "id") Long id) {

		System.out.println("fetching the data");

		return accountrepository.findnameByAccount(id);

	}

	@GetMapping("/getAll")
	public List<Account> getAll() {
		return accountrepository.findAll();
	}

}
