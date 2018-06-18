package br.com.DrogariaSI.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.DrogariaSI.dao.CidadeDAO;
import br.com.DrogariaSI.dao.EstadoDAO;
import br.com.DrogariaSI.domain.Cidade;
import br.com.DrogariaSI.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable{
	private List<Cidade> cidades;
	private Cidade cidade;
	private List<Estado> estados;

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void Listar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			
		}catch(RuntimeException e) {
			Messages.addGlobalError("Ocorreu erro ao tentar listar cidades");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		cidade = new Cidade();
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar Estados");
			e.printStackTrace();
		}
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	
	public void salvar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);
			cidades = cidadeDAO.listar();
			novo();
			Messages.addGlobalInfo("Cidade salvo com sucesso");
		}catch(RuntimeException e) {
			Messages.addGlobalError("Ocorreu erro ao tentar cadastrar cidade");
			e.printStackTrace();
		}
	}
	
	public void excluir(ActionEvent evento) {
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
			
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			
			cidades = cidadeDAO.listar();
			
			Messages.addGlobalInfo("Cidade: " + cidade.getNome()+" excluído com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir Cidade");
			e.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionado");
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar selecionar cidade");
			e.printStackTrace();
		}
	}
}
