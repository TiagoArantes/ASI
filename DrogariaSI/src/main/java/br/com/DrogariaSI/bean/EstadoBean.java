package br.com.DrogariaSI.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.DrogariaSI.dao.EstadoDAO;
import br.com.DrogariaSI.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {
	private Estado estado;
	private List<Estado> estados;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);

			novo();
			estados = estadoDAO.listar();

			Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar cadastrar Estado");
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar Estados");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar editar Estado");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);
			
			estados = estadoDAO.listar();
			
			Messages.addGlobalInfo("Estado: " + estado.getNome()+" excluido com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir Estado");
			e.printStackTrace();
		}
	}
}
