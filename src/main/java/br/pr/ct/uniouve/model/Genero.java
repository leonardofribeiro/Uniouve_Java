package br.pr.ct.uniouve.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name ="\"Genero\"")
public class Genero implements Serializable{

	private static final long serialVersionUID = 766891496959555527L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long generoId;
	
	@Column(nullable = false)
	private String generoDescricao;

	public Long getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Long generoId) {
		this.generoId = generoId;
	}

	public String getGeneroDescricao() {
		return generoDescricao;
	}

	public void setGeneroDescricao(String generoDescricao) {
		this.generoDescricao = generoDescricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((generoDescricao == null) ? 0 : generoDescricao.hashCode());
		result = prime * result + ((generoId == null) ? 0 : generoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genero other = (Genero) obj;
		if (generoDescricao == null) {
			if (other.generoDescricao != null)
				return false;
		} else if (!generoDescricao.equals(other.generoDescricao))
			return false;
		if (generoId == null) {
			if (other.generoId != null)
				return false;
		} else if (!generoId.equals(other.generoId))
			return false;
		return true;
	}
	
	
}
