package br.com.DrogariaSI.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
			System.out.println("Entrou no novo");
			for(Estado est : estados) {
				System.out.println(est.getNome());
			}
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
			
		}catch(RuntimeException e) {
			Messages.addGlobalError("Ocorreu erro ao tentar cadastrar cidade");
			e.printStackTrace();
		}
	}
}
