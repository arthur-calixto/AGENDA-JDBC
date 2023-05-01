import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class OpcoesAgenda {
	
	private static Scanner sc;
	private static ContatoDAO contatoDAO;
	private static Contato contato;

	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
		contatoDAO = new ContatoDAO();
		contato = new Contato();

		String v_nome;
		int v_idade;
		int v_opcao = 0;
		int v_id;

		while (v_opcao != 9) {

			System.out.println("* BEM VINDO AO CADASTRO DE AGENDA *\n"
					+ "ESCOLHA UMA DAS OPÇÕES ABAIXO:\n"
					+ "1 - CADASTRAR UM NOVO CONTATO\n"
					+ "2 - SELECIONAR CONTATO EXISTENTE\n"
					+ "3 - ATUALIZAR UM CONTATO EXISTENTE\n"
					+ "4 - LISTAR TODOS CONTATOS\n"
					+ "9 - SAIR DO PROGRAMA \n");
			v_opcao = sc.nextInt();

			// CADASTRANDO NOVO CONTATO
			if (v_opcao == 1) {

				Locale.setDefault(Locale.US);
				System.out.println("Digite o nome do novo contato e idade: ");
				v_nome = sc.next();
				v_idade = sc.nextInt();

				//CRIA UM NOVO CONTATO E SALVA NO BANCO
				contato.setNome(v_nome);
				contato.setIdade(v_idade);
				contato.setDataCadastro(new Date());
				contatoDAO.save(contato); //REALIZANDO INSERT
			} 

			//CONSULTANDO CONTATO EXISTENTE
			else if (v_opcao ==2) {

				System.out.println("Digite ID do contato: ");
				v_id = sc.nextInt();
				contatoDAO.getContatos2(v_id);

				System.out.println("ID  | NOME    |IDADE");

				for(Contato c : contatoDAO.getContatos2(v_id)){
					//System.out.println("ID: "+ c.getId()+ " | NOME: " + c.getNome());
					System.out.println( c.getId()+ " | " + c.getNome() + "|" + c.getIdade());
				}
			}

			else if (v_opcao == 4 ) {

				System.out.println("ID  | NOME ");

				for(Contato c : contatoDAO.getContatos()){
					//System.out.println("ID: "+ c.getId()+ " | NOME: " + c.getNome());
					System.out.println( c.getId()+ " | " + c.getNome());
				}
			}
		}	
		sc.close();
	}

}
