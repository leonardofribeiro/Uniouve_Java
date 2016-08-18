package br.pr.ct.uniouve.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.pr.ct.uniouve.controller.FacesMessageCreator;
import br.pr.ct.uniouve.controller.Header;
import br.pr.ct.uniouve.controller.Manager;
import br.pr.ct.uniouve.controller.Page;
import br.pr.ct.uniouve.model.AreaInstitucional;
import br.pr.ct.uniouve.model.Usuario;

@ViewScoped
@ManagedBean(name = "testeBean")
public class TesteBean implements Serializable {

	private static final long serialVersionUID = -4142825877044015029L;
	private Manager manager;
	private Header header = new Header();
	private Usuario usuario = new Usuario();
	private AreaInstitucional areaInstitucional = new AreaInstitucional();
	private FacesMessageCreator facesMessageCreator = new FacesMessageCreator();
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public AreaInstitucional getAreaInstitucional() {
		return areaInstitucional;
	}
	public void setAreaInstitucional(AreaInstitucional areaInstitucional) {
		this.areaInstitucional = areaInstitucional;
	}
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	
	public void init() {
		manager = new Manager();
		manager.commit();
	}
	
	public void salvar() {
		
		manager = new Manager();
		Page page = this.header.getAtivo();
		
		try
		{
			if(page.getTabela().equals("areaInstitucional"))
			{
				if(page.getOperacao().equals("incluir")
					|| page.getOperacao().equals("alterar"))
				{
					manager.getSession().saveOrUpdate(this.areaInstitucional);
					manager.flush();
					
					this.areaInstitucional = new AreaInstitucional();
					facesMessageCreator
					.showMessageInDialog(FacesMessage.SEVERITY_INFO, "Salvo.","Sucesso!");
				}
			}
			else if(page.getTabela().equals("usuario"))
			{
				
			}
		}
		catch(Exception e)
		{
			manager.rollback();
		}
		finally{manager.commit();}
	}
}
