package main.java.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	

	public Token() {
		super();
	}


	public Token(Long id) {
		super();
		this.id = id;
	}
	
	
}
