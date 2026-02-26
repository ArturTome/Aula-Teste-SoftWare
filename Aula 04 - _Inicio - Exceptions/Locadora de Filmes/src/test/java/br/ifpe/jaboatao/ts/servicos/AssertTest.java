package br.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.security.PublicKey;

import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;

public class AssertTest {

	@Test
	public void teste01() {
		assertTrue(true);
		assertFalse(false);
	}
	@Test
	public void teste02() {
		//Numeros
		assertEquals(1, 1,"Erro de comparação.");
		assertNotEquals(1, 2);
		assertEquals(0.23122, 0.2312, 0.0001);
		assertEquals(Math.PI, 3.14, 0.01);
		//Texto
		assertEquals("casa", "casa");
		assertTrue("casa" == "casa");
		assertTrue("casa".equalsIgnoreCase("Casa"));
		assertEquals("casa".toLowerCase(), "Casa".toLowerCase());
		//Objetos
		Usuario u1 = new Usuario("Usuario 01");
		Usuario u2 = new Usuario("Usuario 01");
		assertEquals(u1, u2);
	}
	@Test
	public void teste03() {
		Usuario u1 = new Usuario("Usuario 01");
		Usuario u2 = new Usuario("Usuario 01");
		Usuario u3 = u2;
		assertSame(u3, u2);
		assertNotSame(u1, u3);
	}
	@Test
	public void teste04() {
		Usuario u4 = new Usuario("Usuario 04");
		Usuario u5 = null;
		assertNull(u5);
		assertNotNull(u4);
	}
	
	@Test
	public void teste05() {
		// Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 01");
		Filme filme = new Filme("Titulo 01", 0, 10.00);
		
		// Acão
		try {
			Locacao locacao = service.alugarFilme(usuario, filme);
			fail("Deveria ter ocorrido uma excepiton.");
		} catch (Exception e) {
			// Verificação
			assertEquals("Estoque vazio!", e.getMessage());
			
		}
		

	}
	@Test
	public void teste06() {
		// Cenário
				LocacaoService service = new LocacaoService();
				Usuario usuario = new Usuario("Usuario 01");
				Filme filme = new Filme("Titulo 01", 0, 10.00);
				
		// Ação
		Exception minhaException = assertThrows(Exception.class, () -> {
			service.alugarFilme(usuario, filme);
		}, "Deveria ter ocorrido uma Exception");
		
		// Verificação
		assertEquals("Estoque vazio!", minhaException.getMessage());
	}
	@Test
	public void teste07() {
		// Cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("");
		Filme filme = new Filme("Titulo 01", 0, 10.00);
		
		//ação
		Exception e1 = assertThrows(Exception.class, () -> {
			service.alugarFilme(usuario, filme);
		}, "Deveria não ter nome");
		
		// Verificação
		assertEquals("Estoque vazio!", e1.getMessage());
		}
	}

