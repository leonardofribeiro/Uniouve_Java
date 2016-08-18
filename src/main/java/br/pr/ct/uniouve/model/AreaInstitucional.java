package br.pr.ct.uniouve.model;

import java.io.Serializable;

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
@Table(name = "\"AreaInstitucional\"", schema = "public")
public class AreaInstitucional implements Serializable {

	private static final long serialVersionUID = 5440348766496229915L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long co_id;
	
	@Column(unique = true, nullable = false)
	private String no_area_institucional;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "co_responsavel")
	private Usuario usuario;
	
	public Long getCo_id() {
		return co_id;
	}
	public void setCo_id(Long co_id) {
		this.co_id = co_id;
	}
	public String getNo_area_institucional() {
		return no_area_institucional;
	}
	public void setNo_area_institucional(String no_area_institucional) {
		this.no_area_institucional = no_area_institucional;
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
		result = prime * result + ((co_id == null) ? 0 : co_id.hashCode());
		result = prime * result + ((no_area_institucional == null) ? 0 : no_area_institucional.hashCode());
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
		AreaInstitucional other = (AreaInstitucional) obj;
		if (co_id == null) {
			if (other.co_id != null)
				return false;
		} else if (!co_id.equals(other.co_id))
			return false;
		if (no_area_institucional == null) {
			if (other.no_area_institucional != null)
				return false;
		} else if (!no_area_institucional.equals(other.no_area_institucional))
			return false;
		return true;
	}
}
