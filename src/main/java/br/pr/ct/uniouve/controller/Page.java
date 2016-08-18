package br.pr.ct.uniouve.controller;

import java.io.Serializable;

public class Page implements Serializable {

	private static final long serialVersionUID = 4742701971917554426L;
	private String tabela = new String();
	private String operacao = new String();
	private Integer index = 0;
	private Boolean ativo = false;
	private String tipo = new String();
	
	public Page(Integer index) {
		this.index = index;
	}
	
	public void set(String tabela, String operacao) {
		this.tabela = tabela;
		this.operacao = operacao;
		this.ativo = true;
	}
	
	public String getTabela() {
		return tabela;
	}
	public void setTabela(String tabela) {
		this.tabela = tabela;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
		result = prime * result + ((index == null) ? 0 : index.hashCode());
		result = prime * result + ((operacao == null) ? 0 : operacao.hashCode());
		result = prime * result + ((tabela == null) ? 0 : tabela.hashCode());
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
		Page other = (Page) obj;
		if (ativo == null) {
			if (other.ativo != null)
				return false;
		} else if (!ativo.equals(other.ativo))
			return false;
		if (index == null) {
			if (other.index != null)
				return false;
		} else if (!index.equals(other.index))
			return false;
		if (operacao == null) {
			if (other.operacao != null)
				return false;
		} else if (!operacao.equals(other.operacao))
			return false;
		if (tabela == null) {
			if (other.tabela != null)
				return false;
		} else if (!tabela.equals(other.tabela))
			return false;
		return true;
	}
}
