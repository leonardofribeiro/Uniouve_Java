package br.pr.ct.uniouve.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Header implements Serializable {

	private static final long serialVersionUID = -2260654575993797301L;
	private Collection<Page> pages = new ArrayList<Page>();

	public Header() {
		for(int i=0;i<10;i++)
		{
			Page page = new Page(i);
			pages.add(page);
		}
	}
	
	public void set(String tabela, String operacao, Integer index) {
		
		for(Page page : this.pages)
		{
			if(page.getIndex() == index)
				page.set(tabela, operacao);
			else page.setAtivo(false);
			
			if(page.getIndex() > index)
			{
				page.set(new String(), new String());
				page.setTipo(new String());
			}
		}
	}
	
	public Page get(Integer index) {
		
		for(Page page : this.pages)
			if(page.getIndex() == index)
				return page;
		
		return null;
	}
	
	public Page getAtivo() {
		
		for(Page page : this.pages)
			if(page.getAtivo())
				return page;
		return null;
	}
	
	public Collection<Page> getPages() {
		return pages;
	}

	public void setPages(Collection<Page> pages) {
		this.pages = pages;
	}
}
