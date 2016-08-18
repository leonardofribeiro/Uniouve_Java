package br.pr.ct.uniouve.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"Log\"")
public class Log implements Serializable{

	private static final long serialVersionUID = 7986094777582437115L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long logId;
	@Column(name = "Descricao" , nullable = false)
	private String logDescricao;
	
	private Date dataInsercao;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "co_responsavel")
	private Usuario usuario;

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public String getLogDescricao() {
		return logDescricao;
	}

	public void setLogDescricao(String logDescricao) {
		this.logDescricao = logDescricao;
	}

	public Date getDataInsercao() {
		return dataInsercao;
	}

	public void setDataInsercao(Date dataInsercao) {
		this.dataInsercao = dataInsercao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataInsercao == null) ? 0 : dataInsercao.hashCode());
		result = prime * result + ((logDescricao == null) ? 0 : logDescricao.hashCode());
		result = prime * result + ((logId == null) ? 0 : logId.hashCode());
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
		Log other = (Log) obj;
		if (dataInsercao == null) {
			if (other.dataInsercao != null)
				return false;
		} else if (!dataInsercao.equals(other.dataInsercao))
			return false;
		if (logDescricao == null) {
			if (other.logDescricao != null)
				return false;
		} else if (!logDescricao.equals(other.logDescricao))
			return false;
		if (logId == null) {
			if (other.logId != null)
				return false;
		} else if (!logId.equals(other.logId))
			return false;
		return true;
	}
	
	
	
	
	
}
