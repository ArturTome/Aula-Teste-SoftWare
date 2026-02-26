package br.ifpe.jaboatao.ts.servicos;

import java.util.Date;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.FilmeException;
import br.ifpe.jaboatao.ts.utils.DataUtils;

public class LocacaoService {
	
	
	public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {
		if (filme.getEstoque() == 0) {
			throw new FilmeException("Estoque vazio!");
		}
		if(usuario.getNome()== "") {
			throw new FilmeException("Não existe usuario");
		}
		Locacao locacao = new Locacao();
		locacao.setFilme(filme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(filme.getValor());

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = DataUtils.incrementarQntDias(1, dataEntrega);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.
		
		return locacao;
	}
	
}