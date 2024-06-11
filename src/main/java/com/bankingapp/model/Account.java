package com.bankingapp.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
//import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    private String accountNumber;

	   
	    private Double balance;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private Applicant user;
	    
	    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	    private List<Transaction> transactions;
}

