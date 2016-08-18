package br.pr.ct.uniouve.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Usuario\"", schema = "public")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -6684406934005241111L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long co_id;
	
	@Column(nullable = false)
	private String no_usuario;
	
	@Column(length = 200, unique = true, nullable = false)
	private String no_email;
	
	@Column(length = 30)
	private String nu_telefone;
	
	@Column(nullable = false)
	private String senha;
	
}
