package br.com.drogariaSI.dao;

import org.junit.Test;

import br.com.DrogariaSI.dao.CidadeDAO;
import br.com.DrogariaSI.dao.EstadoDAO;
import br.com.DrogariaSI.domain.Cidade;
import br.com.DrogariaSI.domain.Estado;

public class CidadeDAOTest {
	@Test
	public void salvar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		
		Estado estado = estadoDAO.buscar(2L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Uberlândia");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
	}
}
