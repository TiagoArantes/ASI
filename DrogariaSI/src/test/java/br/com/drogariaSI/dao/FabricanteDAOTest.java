package br.com.drogariaSI.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.DrogariaSI.dao.FabricanteDAO;
import br.com.DrogariaSI.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Generic Santos");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
	
	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();
		
		for(Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante resultado = fabricanteDAO.buscar(codigo);
		
		if(resultado != null) {
			System.out.println(resultado.getCodigo() + " - " + resultado.getDescricao());
		}else {
			System.out.println("Fabricante não foi encontrado com codigo informado");
		}
	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante resultado = fabricanteDAO.buscar(codigo);
		
		if(resultado != null) {
			fabricanteDAO.excluir(resultado);
			System.out.println("Fabricante excluido");
		}else {
			System.out.println("Fabricante não foi encontrado com codigo informado");
		}
	}
	
	@Test
	public void editar() {
		Long codigo = 1L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante resultado = fabricanteDAO.buscar(codigo);
		
		if(resultado != null) {
			resultado.setDescricao("Descrição editada");
			fabricanteDAO.editar(resultado);
			System.out.println("Fabricante editado");
		}else {
			System.out.println("Fabricante não foi encontrado com codigo informado");
		}
	}
}
