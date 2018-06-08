package br.com.drogariaSI.dao;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.DrogariaSI.dao.FabricanteDAO;
import br.com.DrogariaSI.dao.ProdutoDAO;
import br.com.DrogariaSI.domain.Fabricante;
import br.com.DrogariaSI.domain.Produto;

public class ProdutoDAOTest {

	@Test
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(1L);
		
		Produto produto = new Produto();
		produto.setDescricao("Anador gota");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("5.50"));
		produto.setQuantidade(new Short("7"));
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);
	}
}
