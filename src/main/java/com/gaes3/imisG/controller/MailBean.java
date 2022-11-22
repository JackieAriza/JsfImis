package com.gaes3.imisG.controller;


import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import com.gaes3.imisG.Utilities.EmailSender;
import com.gaes3.imisG.facadeImp.UsuarioDAO;
import com.gaes3.imisG.modelo.Usuario;


@ManagedBean(name = "mailBean")
@RequestScoped
public class MailBean {

	private static final ArrayList<String> destino = new ArrayList<String>();
	private String asusto;
	private String texto;
	private String correos;
	private UsuarioDAO u = new UsuarioDAO();

	public ArrayList<String> getDestino() {
		return destino;
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

	public String getCorreos() {
		return correos;
	}

	public void setCorreos(String correos) {
		this.correos = correos;
	}

	public MailBean() {

	}

	public void notificar() {
		if (EmailSender.enviarEmail(destino, asusto, texto)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Muy Bien", "Correo Enviado Correctamente"));
			destino.clear();
			correos = "";
			asusto = "";
			texto = "";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Oh Rayos", "Correo Enviado No se Pudo Enviar"));
		}

	}
	

	public void agregarcorreo() {
		
		boolean v = false;
		for (String d : destino) {
			if (d.contentEquals(correos)) {
				v = true;
			}
		}
		if (v == false) {
			destino.add(correos);
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ese correo ya fue agregado"));
		}
		correos = "";
	}

	public void quitarCorreo(String p) {
		destino.remove(p);
		correos = "";
	}

	public List<String> listacorreos() throws Exception {
		List<String> lista = new ArrayList<>();
		for (Usuario user : u.obtenerUsuarios()) {
			lista.add(user.getEmailUsuario());
		}
		return lista;
	}
	
	public void boton() {
		List<Usuario> lista = new ArrayList<>();
		lista = u.obtenerUsuarios();
		for(Usuario user: lista) {
			destino.add(user.getEmailUsuario());
		}
		if (EmailSender.enviarEmail(destino, asusto, texto)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Muy Bien", "Correo Enviado Correctamente"));
			destino.clear();
			correos = "";
			asusto = "";
			texto = "";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Oh Rayos", "Correo Enviado No se Pudo Enviar"));
		}

	}

}
