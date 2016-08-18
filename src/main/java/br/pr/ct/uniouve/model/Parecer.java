package br.pr.ct.uniouve.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "\"Parecer\"" , schema= "public")
public class Parecer implements Serializable{

	private static final long serialVersionUID = -6042051453915196700L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long parecerId;
	@Column(nullable = false)
	private String ParecerDescricao;
	
	@Column(name = "DataInsercao")
	private Date parecerDataInsercao;
	//private Enum<> NivelVisualizacao;

	public Long getParecerId() {
		return parecerId;
	}

	public void setParecerId(Long parecerId) {
		this.parecerId = parecerId;
	}

	public String getParecerDescricao() {
		return ParecerDescricao;
	}

	public void setParecerDescricao(String parecerDescricao) {
		ParecerDescricao = parecerDescricao;
	}

	public Date getParecerDataInsercao() {
		return parecerDataInsercao;
	}

	public void setParecerDataInsercao(Date parecerDataInsercao) {
		this.parecerDataInsercao = parecerDataInsercao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ParecerDescricao == null) ? 0 : ParecerDescricao.hashCode());
		result = prime * result + ((parecerDataInsercao == null) ? 0 : parecerDataInsercao.hashCode());
		result = prime * result + ((parecerId == null) ? 0 : parecerId.hashCode());
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
		Parecer other = (Parecer) obj;
		if (ParecerDescricao == null) {
			if (other.ParecerDescricao != null)
				return false;
		} else if (!ParecerDescricao.equals(other.ParecerDescricao))
			return false;
		if (parecerDataInsercao == null) {
			if (other.parecerDataInsercao != null)
				return false;
		} else if (!parecerDataInsercao.equals(other.parecerDataInsercao))
			return false;
		if (parecerId == null) {
			if (other.parecerId != null)
				return false;
		} else if (!parecerId.equals(other.parecerId))
			return false;
		return true;
	}
	
	
	
	
	
}
