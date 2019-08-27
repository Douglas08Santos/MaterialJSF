package br.ufrn.imd.material.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.ufrn.imd.material.dominio.Usuario;
import br.ufrn.imd.material.repositorios.UsuarioRepositorio;

@Named
@SessionScoped
public class UsuarioMBean implements Serializable{
	private Usuario usuario;
	private Usuario usuarioLogado;
	
	public UsuarioMBean() {
		usuario = new Usuario();
	}
	public String logar() {
		Usuario usuarioBd = UsuarioRepositorio.getUsuario(usuario.getLogin(), usuario.getSenha());
		if (usuarioBd != null) {
			usuarioLogado = usuarioBd;
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", usuarioLogado);
			return "/pages/index.jsf";
		} else {
			FacesMessage msg = new FacesMessage("Usuário não encontrado.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage("", msg);
			return null;
		}
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the usuarioLogado
	 */
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	/**
	 * @param usuarioLogado the usuarioLogado to set
	 */
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
	
}
