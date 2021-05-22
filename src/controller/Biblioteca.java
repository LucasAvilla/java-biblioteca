package controller;

import java.time.LocalDate;

import javax.swing.JOptionPane;

import model.Autor;
import model.Data;
import model.Editora;
import model.Livro;
import model.Locacao;
import model.Usuario;

/**
 * Classe para efetuar o cadastro de usuarios e livros, pesquisa, locação e
 * devolução de livros
 * 
 * @author Lucas Igor A M Nogueira
 * @since 18 de fev. de 2021
 */
public class Biblioteca {

	// Vetores para armazenar as variáveis
	private Livro livros[];
	private Usuario usuarios[];
	private Locacao locacoes[];

	// variavel auxiliar para definir o tamanho dos vetores
	private int quantoslivros = 0;
	private int quantosUsuarios = 0;
	private int quantasLocacoes = 0;

	public Biblioteca() {
		processar();
	}

	// Método principal do programa
	public void processar() {

		// capturando do usuario a quantidade de livros, usuarios e locações
		quantoslivros = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos livros"));
		quantosUsuarios = Integer.parseInt(JOptionPane.showInputDialog("Informe quantos usuarios"));
		quantasLocacoes = Integer.parseInt(JOptionPane.showInputDialog("Informe quantas locações"));

		// definindo o tamanho do estoque de carros
		livros = new Livro[quantoslivros];
		usuarios = new Usuario[quantosUsuarios];
		locacoes = new Locacao[quantasLocacoes];

		implementaLivros();

		// processamento de looping do programa
		while (true) {
			escolhaUsuario();
		}
	}

	// Método para capturar do usuario a opção
	public void escolhaUsuario() {
		String menu = "Informe a opção desejada:\n\n" + "OPÇÃO 1: Cadastrar livro\n" + "OPÇÃO 2: Cadastrar usuário\n"
				+ "OPÇÃO 3: Efetuar locação de livros\n" + "OPÇÃO 4: Efetuar devolução de livros\n"
				+ "OPÇÃO 5: Listar todos os livros cadastrados\n" + "OPÇÃO 6: Listar todos os usuários cadastrados\n"
				+ "OPÇÃO 7: Pesquisar livros por editora\n" + "OPÇÃO 8: Pesquisar livros por autor\n"
				+ "OPÇÃO 9: Pesquisar locações por data\n" + "OPÇÃO 10: Sair do sistema";

		// Exibe as opções de menu para o usuario
		int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
		escolhaProcessamento(escolha);
	}

	// Método para seleção das opções do programa conforme o menu
	public void escolhaProcessamento(int opcao) {
		switch (opcao) {
		case 1:
			cadastrarLivro();
			break;
		case 2:
			cadastrarUsuario();
			break;
		case 3:
			efetuarLocacaoLivros();
			break;
		case 4:
			efetuarDevolucaoLivros();
			break;
		case 5:
			listarTodosLivrosCadastrados();
			break;
		case 6:
			listarTodosUsuariosCadastrados();
			break;
		case 7:
			pesquisarLivrosPorEditora();
			break;
		case 8:
			pesquisarLivrosPorAutor();
			break;
		case 9:
			pesquisarLocacoesPorData();
			break;
		case 10:
			sairDoSistema();
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!", "Cadastro da Biblioteca", 0);// opção do menu
																								// inexistente
			break;
		}
	}

	// Método para cadastrar um livro novo na biblioteca
	public void cadastrarLivro() {

		// variável auxiliar para verificar se gravou o livro
		boolean gravado = false;

		// laço para verificar espaço
		for (int i = 0; i < livros.length; i++) {// inicio do for
			if (livros[i] == null) {
				livros[i] = criarLivro();
				gravado = true;
				break;
			}
		} // fim do for

		// exibindo para o usuario se o cadastro foi realizado com sucesso
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Livro gravado com sucesso!", "Cadastro da Biblioteca", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Livro não cadastrado!", "Cadastro da Biblioteca", 2);
		}

	}// fim do método

	// Método para devolver um livro cadastrado
	public Livro criarLivro() {

		// criando e instanciando os objetos
		Livro livro = new Livro();
		Editora editora = new Editora();
		Autor autor = new Autor();

		// Recebendo do usuario as informações de autor, editora e livro
		autor.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do autor")));
		autor.setNome(JOptionPane.showInputDialog("Informe o nome do autor do livro"));
		autor.setNacionalidade(JOptionPane.showInputDialog("Informe a nacionalidade do autor do livro"));
		editora.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo da editora")));
		editora.setNome(JOptionPane.showInputDialog("Informe o nome da editora do livro"));
		editora.setPais(JOptionPane.showInputDialog("Informe o pais da editora do livro"));

		livro.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo do livro")));
		livro.setTitulo(JOptionPane.showInputDialog("Informe o titulo do livro"));
		livro.setAnoPublicacao(Integer.parseInt(JOptionPane.showInputDialog("Informe o ano de publicação do livro")));

		// atribuindo o autor e editora para o objeto livro
		livro.setAutor(autor);
		livro.setEditora(editora);
		livro.setDisponivel(true);

		return livro;

	}// fim do metodo

	// Método para efetuar o cadastro de um novo usuario
	public void cadastrarUsuario() {

		// variável auxiliar para verificar se gravou o usuario
		boolean gravado = false;

		// laço para verificar espaço
		for (int i = 0; i < usuarios.length; i++) {// inicio do for
			if (usuarios[i] == null) {
				usuarios[i] = criarUsuario();
				gravado = true;
				break;
			}
		} // fim do for

		// exibindo o resultado para o usuario
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Usuario gravado com sucesso!", "Cadastro da Biblioteca", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Usuario não cadastrado!", "Cadastro da Biblioteca", 2);
		}

	}// fim do método

	// Método para devolver um usuario cadastrado
	public Usuario criarUsuario() {

		// criando e instanciando os objetos
		Usuario usuario = new Usuario();
		Data dataNascimento = new Data();

		// Recebendo do usuario as informações do usuario
		usuario.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Informe o codigo de usuario")));
		usuario.setNome(JOptionPane.showInputDialog("Informe o nome completo do usuario"));
		usuario.setEmail(JOptionPane.showInputDialog("Informe o e-mail do usuario"));
		usuario.setTelefone(JOptionPane.showInputDialog("Informe o telefone com DDD do usuario"));

		String data[] = JOptionPane.showInputDialog("Insira a data de nascimento (DD/MM/AAAA)").split("/");
		dataNascimento.setDia(Integer.parseInt(data[0]));
		dataNascimento.setMes(Integer.parseInt(data[1]));
		dataNascimento.setAno(Integer.parseInt(data[2]));

		// atribuindo a data para o usuario
		usuario.setDataNascimento(dataNascimento);

		return usuario;

	}

	// Método para realizar a locação de um livro cadastrado
	public void efetuarLocacaoLivros() {

		// criando e instanciando os objetos
		boolean usuariocadastrado = false;
		boolean gravado = false;

		// verificando se existe o usuario cadastrado
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				usuariocadastrado = true;
			}
		}

		// laço para verificar espaço para salvar a locação
		for (int i = 0; i < locacoes.length; i++) { // inicio do for
			if (locacoes[i] == null && usuariocadastrado && livroDisponivel()) {
				locacoes[i] = criarLocacao();
				gravado = true;
				break;
			}
		} // fim do for

		// exibindo para o usuário se a locação foi realizada ou não
		if (gravado) {
			JOptionPane.showMessageDialog(null, "Livro alugado com sucesso!", "Cadastro da Biblioteca", 2);
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao Efetuar locação.", "Cadastro da Biblioteca", 0);
		}
	}

	// Método para realizar a devolucão de um livro locado
	public void efetuarDevolucaoLivros() {

		// variavel para verificar a devolução
		boolean aux = false;

		// verificando há livro para devolver
		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null) {
				aux = true;
			}
		}

		// caso não tenha devolução exibe a mensagem
		if (aux) {

			String msg = "Erro ao devolver.";

			// Recebe o codigo do livro locado
			int codigo = Integer.parseInt(JOptionPane
					.showInputDialog("Digite o codigo do livro para efetuar a devolução:\n" + mostrarLivrosLocados()));

			// varrendo o vetor de locacoes
			for (int i = 0; i < locacoes.length; i++) {
				if (locacoes[i] != null) {
					Livro livrosAlugados[] = locacoes[i].getLivros();
					for (int j = 0; j < livrosAlugados.length; j++) {
						if (livrosAlugados[j] != null && livrosAlugados[j].getCodigo() == codigo
								&& !livrosAlugados[j].isDisponivel()) {
							livrosAlugados[j].setDisponivel(true);
							locacoes[i] = null;
							msg = "Livro devolvido.";
							break;
						}
					}

				}
			} // Fim do for

			JOptionPane.showMessageDialog(null, msg, "Cadastro da Biblioteca", 2);
		} else {
			JOptionPane.showMessageDialog(null, "Erro ao devolver.", "Cadastro da Biblioteca", 0);
		}
	}

	// Método para retornar todos os livros cadastrados
	public void listarTodosLivrosCadastrados() {

		// variavel auxiliar para exibir livros cadastrados para o usuario
		String mensagem = "Livros Cadastrados\n\n";

		// varrendo para verificar se existe livros cadastrados

		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				mensagem += (i + 1) + " - " + livros[i].getCodigo() + " | " + livros[i].getTitulo() + " | Autor: "
						+ livros[i].getAutor().getNome() + "\n" + " | Editora: " + livros[i].getEditora().getNome()
						+ "\n\n";
			}

		} // fim do for

		// exibindo os livros para o usuario
		JOptionPane.showMessageDialog(null, mensagem, "Cadastro da Biblioteca", 1);

	}

	// Método para retornar todos os usuarios cadastrados
	public void listarTodosUsuariosCadastrados() {

		// variavel auxiliar para exibir os usuarios cadastrados
		String mensagem = "Usuarios Cadastrados\n\n";

		// varrendo para verificar se existe usuarios cadastrados
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null) {
				mensagem += (i + 1) + " - " + usuarios[i].getCodigo() + " | " + usuarios[i].getNome() + "\n";
			}
		} // fim do for

		// exibindo os usuarios cadastrados
		JOptionPane.showMessageDialog(null, mensagem, "Cadastro da Biblioteca", 1);

	}

	// Método para retornar os livros da editora escolhida
	public void pesquisarLivrosPorEditora() {

		// recebendo do usuario qual editora a ser pesquisado
		String editora = JOptionPane.showInputDialog("Informe a editora para pesquisa").toLowerCase().trim();

		// variavel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por Editora:\n\n";

		// variavel auxiliar para verificar se existe a editora cadastrada
		boolean existe = false;

		// varrendo o vetor e verificando as editoras
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && (livros[i].getEditora().getNome().toLowerCase().trim().equals(editora))) {
				mensagem += mensagem(livros[i]);
				existe = true;
			}
		} // fim do for

		// exibindo o resultado da pesquisa para o usuario
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro da Biblioteca", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existe a editora no cadastrado", "Cadastro da Biblioteca", 2);
		}

	}

	// Método para retornar os livros do autor escolhido escolhido
	public void pesquisarLivrosPorAutor() {

		// recebendo do usuario qual autor a ser pesquisado
		String autor = JOptionPane.showInputDialog("Informe o autor para pesquisa").toLowerCase().trim();

		// variavel auxiliar para exibir a mensagem do resultado pesquisado
		String mensagem = "Pesquisa por Autor:\n\n";

		// variavel auxiliar para verificar se existe o autor cadastrada
		boolean existe = false;

		// varrendo o vetor e verificando as editoras
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && (livros[i].getAutor().getNome().toLowerCase().trim().equals(autor))) {
				mensagem += mensagem(livros[i]);
				existe = true;
			}
		} // fim do for

		// exibindo o resultado da pesquisa para o usuario
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, "Cadastro da Biblioteca", 1);
		} else {
			JOptionPane.showMessageDialog(null, "Não existe o autor no cadastrado", "Cadastro da Biblioteca", 2);
		}

	}

	// Método para retornar as locações realizadas na data escolhida
	public void pesquisarLocacoesPorData() {

		String msg = "";

		// variavel para exibir a resposta
		boolean aux = false;

		for (int i = 0; i < locacoes.length; i++) {
			// verificando se possui locações
			if (locacoes[i] != null) {
				aux = true;
			}
		}

		if (aux) {
			Data dt = new Data();
			// recebendo informaçoes para pesquisar por data
			String data[] = JOptionPane.showInputDialog("Informe a data de locação para buscar (dd/mm/aaaa):")
					.split("/");
			// atribuindo valores a data:
			dt.setDia(Integer.parseInt(data[0]));
			dt.setMes(Integer.parseInt(data[1]));
			dt.setAno(Integer.parseInt(data[2]));

			// Varrendo o vetor locacoes
			for (int i = 0; i < locacoes.length; i++) {
				// Verificando se o vetor de locações nao esta vazio e comparando as datas
				if (locacoes[i] != null && locacoes[i].getDataLocacao().toString().equals(dt.toString())) {

					// Adicionando os livros
					Livro livrosAlugados[] = locacoes[i].getLivros();

					msg += "Data da Locação: " + locacoes[i].getDataLocacao() + "\n";
					msg += "Cliente: " + locacoes[i].getUsuario().getNome() + "\nLivros: \n";
					for (int j = 0; j < livrosAlugados.length; j++) {
						if (livrosAlugados[j] != null) {
							msg += livrosAlugados[j].getCodigo() + " - " + livrosAlugados[j].getTitulo() + "\n";
						}
					}
					msg += "------------------------------------------------\n";

				}

				if (msg.equals("")) {
					msg = " Nenhum locação encontrado na data!";
				}
			}
			JOptionPane.showMessageDialog(null, msg, "" + "Cadastro da Biblioteca", 2);
		} else {
			JOptionPane.showMessageDialog(null, "Nenhuma locação encontrada.", "Cadastro da Biblioteca", 0);

		}
	}

	public String mensagem(Livro livro) {

		// variavel auxiliar para retonar a mensagem formatada
		String msg = "\n";

		// montando a mensagem de retorno para o usuario
		msg += "Codigo: " + livro.getCodigo() + "\n";
		msg += "Titulo: " + livro.getTitulo() + "\n";
		msg += "Autor: " + livro.getAutor().getNome() + "\n";
		msg += "Editora: " + livro.getEditora().getNome() + "\n";
		msg += "Ano de publicação: " + livro.getAnoPublicacao();

		// retornando a variavel fomartada
		return msg;
	}

	// Método para sair do sistema
	public void sairDoSistema() {
		System.exit(0);
	}

	// metodo para verificar os livros disponiveis
	public boolean livroDisponivel() {

		// verificando se tem livros disponiveis
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].isDisponivel()) {
				return true;
			}
		}
		return false;
	}

	// Método para demonstrar a lista de livros cadastrados
	public String mostrarLivros() {
		String msg = "";
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				msg += "Codigo: " + livros[i].getCodigo() + " Nome: " + livros[i].getTitulo() + "\n";
			}
		}
		return msg;
	}

	// Método para demonstrar a lista de usuarios cadastrados
	public String mostrarUsuarios() {
		String msg = "";
		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null) {
				msg += "Codigo: " + usuarios[i].getCodigo() + " Nome: " + usuarios[i].getNome() + "\n";
			}
		}
		return msg;

	}

	// método para criar uma locação
	public Locacao criarLocacao() {
		// criando e instanciando objeto do tipo Locacao
		Locacao locacao = new Locacao();
		// criando e instanciando um objeto do tipo Data
		Data data = new Data();
		// criando e instanciando um objeto do tipo Usuario
		Usuario usuario = new Usuario();
		// criando e instanciando um objeto do tipo Livro
		Livro livro = new Livro();
		// criando e instanciando o arrai para armazenar os livros
		Livro[] livrosAlugado = new Livro[livros.length];

		// atribuindo valor ao atributo codigo
		locacao.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Insira o código da locação:")));

		// capturando a data do sistema atual convertendo e atribuindo a data da locação
		String dataAtual[] = LocalDate.now().toString().split("-");
		data.setAno(Integer.parseInt(dataAtual[0]));
		data.setMes(Integer.parseInt(dataAtual[1]));
		data.setDia(Integer.parseInt(dataAtual[2]));

		// associando data a locação
		locacao.setDataLocacao(data);

		int codigo = 0;
		do {
			codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do usuario.\n" + mostrarUsuarios()));
			usuario = buscarUsuarioPorCodigo(codigo);
		} while (usuario == null);

		int cod = 0;
		do {
			cod = Integer.parseInt(JOptionPane.showInputDialog("Digite o codigo do livro.\n" + mostrarLivros()));
			livro = buscarLivroPorCodigo(cod);
		} while (livro == null);

		livro.setDisponivel(false);

		for (int i = 0; i < livrosAlugado.length; i++) {
			if (livrosAlugado[i] == null) {
				livrosAlugado[i] = livro;
				break;
			}
		}
		// adicionando os livros alugados a locação
		locacao.setLivros(livrosAlugado);
		// associando o usuario a locação
		locacao.setUsuario(usuario);

		return locacao;
	}

	// metodo para buscar usuario por codigo
	public Usuario buscarUsuarioPorCodigo(int cod) {

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getCodigo() == cod) {
				return usuarios[i];
			}

		}
		JOptionPane.showMessageDialog(null, "Usuario não encontrado", "Cadastro da Biblioteca", 0);
		return null;
	}

	// metodo para buscar livros por codigo
	public Livro buscarLivroPorCodigo(int cod) {

		for (int i = 0; i < livros.length; i++) {
			if (livros[i] != null && livros[i].getCodigo() == cod) {
				return livros[i];
			}
		}
		JOptionPane.showMessageDialog(null, "Livro não encontrado", "Cadastro da Biblioteca", 0);
		return null;
	}

	// método para exibir a relação de livros locados
	public String mostrarLivrosLocados() {

		String msg = "------------------------------------------------\n";

		for (int i = 0; i < locacoes.length; i++) {
			if (locacoes[i] != null) {
				Livro livrosAlugados[] = locacoes[i].getLivros();
				msg += "Data da Locação: " + locacoes[i].getDataLocacao() + "\n";
				msg += "Cliente: " + locacoes[i].getUsuario().getNome() + "\nLivros: \n";
				for (int j = 0; j < livrosAlugados.length; j++) {
					if (livrosAlugados[j] != null) {
						msg += "Cód.: " + livrosAlugados[j].getCodigo() + " - Título: " + livrosAlugados[j].getTitulo()
								+ "\n";
					}
				}
				msg += "------------------------------------------------\n";
			}
		}
		return msg;
	}

	public void implementaLivros() {
		Livro livro1 = new Livro();
		Autor autor1 = new Autor();
		Editora editora1 = new Editora();

		livro1.setAnoPublicacao(2019);
		livro1.setTitulo("Morro dos ventos uivantes");
		livro1.setDisponivel(true);
		livro1.setCodigo(1);
		autor1.setCodigo(1);
		autor1.setNacionalidade("Americana");
		autor1.setNome("Emily Bronte");
		editora1.setCodigo(1);
		editora1.setNome("Principis");
		editora1.setPais("Brasil");
		livro1.setAutor(autor1);
		livro1.setEditora(editora1);
		livros[0] = livro1;

		Livro livro2 = new Livro();
		Autor autor2 = new Autor();
		Editora editora2 = new Editora();

		livro2.setAnoPublicacao(1982);
		livro2.setTitulo("As Brumas de Avalon");
		livro2.setDisponivel(true);
		livro2.setCodigo(2);
		autor2.setCodigo(2);
		autor2.setNacionalidade("Inglesa");
		autor2.setNome("Marion Zimmer Bradley");
		editora2.setCodigo(2);
		editora2.setNome("Alfred A. Knopf");
		editora2.setPais("Inglaterra");
		livro2.setAutor(autor2);
		livro2.setEditora(editora2);
		livros[1] = livro2;

		Livro livro3 = new Livro();
		Autor autor3 = new Autor();
		Editora editora3 = new Editora();

		livro3.setAnoPublicacao(2016);
		livro3.setTitulo("O cortiço");
		livro3.setDisponivel(true);
		livro3.setCodigo(3);
		autor3.setCodigo(3);
		autor3.setNacionalidade("Brasileira");
		autor3.setNome("Aluísio Azevedo");
		editora3.setCodigo(3);
		editora3.setNome("Atica");
		editora3.setPais("Brasil");
		livro3.setAutor(autor3);
		livro3.setEditora(editora3);
		livros[2] = livro3;

		Livro livro4 = new Livro();
		Autor autor4 = new Autor();
		Editora editora4 = new Editora();

		livro4.setAnoPublicacao(2016);
		livro4.setTitulo("O Príncipe");
		livro4.setDisponivel(true);
		livro4.setCodigo(4);
		autor4.setCodigo(4);
		autor4.setNacionalidade("Italiano");
		autor4.setNome("Nicolau Maquiavel");
		editora4.setCodigo(4);
		editora4.setNome("Martins Fontes");
		editora4.setPais("Brasil");
		livro4.setAutor(autor4);
		livro4.setEditora(editora4);
		livros[3] = livro4;

		Livro livro5 = new Livro();
		Autor autor5 = new Autor();
		Editora editora5 = new Editora();

		livro5.setAnoPublicacao(2003);
		livro5.setTitulo("O Código Da Vinci");
		livro5.setDisponivel(true);
		livro5.setCodigo(5);
		autor5.setCodigo(5);
		autor5.setNacionalidade("Norte-americano");
		autor5.setNome("Dan Brown");
		editora5.setCodigo(4);
		editora5.setNome("Arqueiro");
		editora5.setPais("Brasil");
		livro5.setAutor(autor5);
		livro5.setEditora(editora5);
		livros[4] = livro5;

	}
}
