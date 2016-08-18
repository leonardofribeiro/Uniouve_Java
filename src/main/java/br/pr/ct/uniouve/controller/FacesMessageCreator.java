package br.pr.ct.uniouve.controller;

import java.io.Serializable;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class FacesMessageCreator implements Serializable {

	private static final long serialVersionUID = 4839371083212273129L;
	
	private String getHeader(javax.faces.application.FacesMessage.Severity severity) {
		if(severity.getOrdinal() == 0)
			return "Informação";
		else if(severity.getOrdinal() == 1)
			return "Atenção";
		else if(severity.getOrdinal() == 2)
			return "Erro";
		else if(severity.getOrdinal() == 3)
			return "Erro Fatal";
		else return null;
	}
	
	public void showMessageInDialog(javax.faces.application.FacesMessage.Severity severity, String message) {
		try
		{
			String header= getHeader(severity);
			javax.faces.application.FacesMessage m = new javax.faces.application.FacesMessage(severity, header, message);
			if(RequestContext.getCurrentInstance() != null)
				RequestContext.getCurrentInstance().showMessageInDialog(m);
			else throw new FacesException("RequestContext nulo. Impossível criar a mensagem.");
		}
		catch(FacesException e)
		{
			e.printStackTrace();
		}
	}
	
	public void showMessageInDialog(javax.faces.application.FacesMessage.Severity severity, String message, String header) {
		try
		{
			javax.faces.application.FacesMessage m = new javax.faces.application.FacesMessage(severity, header, message);
			if(RequestContext.getCurrentInstance() != null)
				RequestContext.getCurrentInstance().showMessageInDialog(m);
			else throw new FacesException("RequestContext nulo. Impossível criar a mensagem.");
		}
		catch(FacesException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addMessage(javax.faces.application.FacesMessage.Severity severity, String message) {
		
		try
		{
			String header= getHeader(severity);
			javax.faces.application.FacesMessage m = new javax.faces.application.FacesMessage(severity, header, message);
			if(FacesContext.getCurrentInstance() != null)
				FacesContext.getCurrentInstance().addMessage(null, m);
			else throw new FacesException("FacesContext nulo. Impossível criar a mensagem.");
		}
		catch(FacesException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addMessage(javax.faces.application.FacesMessage.Severity severity, String message, String header) {
		
		try
		{
			javax.faces.application.FacesMessage m = new javax.faces.application.FacesMessage(severity, header, message);
			if(FacesContext.getCurrentInstance() != null)
				FacesContext.getCurrentInstance().addMessage(null, m);
			else throw new FacesException("FacesContext nulo. Impossível criar a mensagem.");
		}
		catch(FacesException e)
		{
			e.printStackTrace();
		}
	}
	
	public void addMessage(javax.faces.application.FacesMessage.Severity severity, String message, String header, String growl) {
		
		try
		{
			javax.faces.application.FacesMessage m = new javax.faces.application.FacesMessage(severity, header, message);
			if(FacesContext.getCurrentInstance() != null)
				FacesContext.getCurrentInstance().addMessage(growl, m);
			else throw new FacesException("FacesContext nulo. Impossível criar a mensagem.");
		}
		catch(FacesException e)
		{
			e.printStackTrace();
		}
	}
}
