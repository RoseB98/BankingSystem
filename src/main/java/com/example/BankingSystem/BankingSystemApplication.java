package com.example.BankingSystem;

import com.example.BankingSystem.models.Account.CreditCard;
import com.example.BankingSystem.models.User.*;
import com.example.BankingSystem.repositories.AccountHolderRepository;
import com.example.BankingSystem.repositories.RoleRepository;
import com.example.BankingSystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class BankingSystemApplication implements CommandLineRunner {
	@Autowired
	AccountHolderRepository accountHolderRepository;

	@Autowired
    UserRepository userRepository;
    @Autowired
	RoleRepository roleRepository;
	public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*BigDecimal a = new BigDecimal(1);
		BigDecimal b = new BigDecimal(2);
		int resultado = a.compareTo(b);
		System.out.println("--------------------------");
		System.out.println("--------------------------");
		System.out.println(resultado);
		if(a.compareTo(b) < 0) System.out.println("a es mas pequeñö");
		else if(a.compareTo(b) > 0) System.out.println("b es mas pequeñö");
		else System.out.println("los numeros son iguals");*/



		/*Address address1 = new Address("av. Dilma", "62B", "17-2", PlaceType.APPARTMENT, "Barcelona", "08002");
		LocalDate date1 = LocalDate.of(2000, 12, 27);
		Address mailingAddress1 = new Address("av. Deilma", "62B", "17-2", PlaceType.APPARTMENT, "Barcelona", "08002");
		Address address2 = new Address("Pamplona", "56", "7-1", PlaceType.APPARTMENT, "Guadalajara", "93648");
		Address mailingAddress2 = new Address("Delta", "1-15",null, PlaceType.HOUSE, "Barquisimeto", "9103");


		User accountHolder1 = new AccountHolder("Pablito", "12345", date1, address1, mailingAddress1);
		User accountHolder2 = new AccountHolder("Darci", "54321", LocalDate.of(1979, 03, 19), address2, mailingAddress2);
		userRepository.saveAll(List.of(accountHolder1, accountHolder2));

		roleRepository.save(new Role("ACCOUNT-HOLDER", accountHolder1));
		roleRepository.save(new Role("ACCOUNT-HOLDER", accountHolder2));*/


	}
}
