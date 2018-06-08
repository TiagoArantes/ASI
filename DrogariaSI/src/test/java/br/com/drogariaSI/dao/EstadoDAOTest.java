package br.com.drogariaSI.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.DrogariaSI.dao.EstadoDAO;
import br.com.DrogariaSI.domain.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("São Paulo");
		estado.setSigla("SP");
		
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}
	
	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();
		
		for(Estado estado : resultado) {
			System.out.println(estado.getNome() + " - " + estado.getSigla());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado != null) {
			System.out.println(estado.getCodigo() + " - " + estado.getNome());
		}else {
			System.out.println("Registro não foi encontrado com o valor informado");
		}
		
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado != null) {
			estadoDAO.excluir(estado);
			System.out.println("Estado excluido");
		}else {
			System.out.println("Registro não foi encontrado com o valor informado");
		}
	}
	
	@Test
	public void editar() {
		Long codigo = 2L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		if(estado != null) {
			estado.setSigla("MW");
			estadoDAO.editar(estado);
			System.out.println("Estado editado");
		}else {
			System.out.println("Registro não foi encontrado com o valor informado");
		}
	}
}
