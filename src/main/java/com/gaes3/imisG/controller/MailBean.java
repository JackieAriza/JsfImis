package com.gaes3.imisG.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.gaes3.imisG.Utilities.EmailSender;
import com.gaes3.imisG.modelo.Cliente;
import com.gaes3.imisG.modelo.Tipo_Documento;

@ManagedBean(name = "mailBean")
@RequestScoped
public class MailBean implements Serializable {

	private String destino;
	private String asusto;
	private String texto;
	private String correos;
	
	public MailBean() {

	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getAsusto() {
		return asusto;
	}

	public void setAsusto(String asusto) {
		this.asusto = asusto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void notificar() {
		if (EmailSender.enviarEmail(destino, asusto, texto)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Muy Bien","Correo Enviado Correctamente"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Oh Rayos","Correo Enviado No se Pudo Enviar"));
		}

	}

}
