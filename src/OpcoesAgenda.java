import java.util.Date;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

import java.util.Locale;
import java.util.Scanner;

public class OpcoesAgenda {
	

	public static void main(String[] args) {

		String v_nome;
		int v_idade;
		int v_opcao;
		int v_id;

		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("* BEM VINDO AO CADASTRO DE AGENDA\n"
				+ "ESCOLHA UMA DAS OPÇÕES ABAIXO:\n"
				+ "1 - CADASTRAR UM NOVO CONTATO\n"
				+ "2 - SELECIONAR CONTATO EXISTENTE\n"
				+ "3 - ATUALIZAR UM CONTATO EXISTENTE\n"
				+ "4 - LISTA DE TODOS CONTATOS\n");
		v_opcao = sc.nextInt();

		
		// CADASTRANDO NOVO CONTATO
		if (v_opcao == 1) {
		Locale.setDefault(Locale.US);
		/*Scanner sc = new Scanner(System.in);*/
		System.out.println("Digite o nome do novo contato e idade:");
		v_nome = sc.next();
		v_idade = sc.nextInt();
		
		// TODO Auto-generated method stub
		 ContatoDAO contatoDAO = new ContatoDAO();
		 
		 //Cria um contato e salva no banco
		 Contato contato = new Contato();
		 contato.setNome(v_nome);
		 contato.setIdade(v_idade);
		 contato.setDataCadastro(new Date());
		 
		 contatoDAO.save(contato); //Realizando insert
		} 
		// CONSULTANDO CONTATO EXISTENTE
		else if (v_opcao ==2) {
			System.out.println("Digite ID do contato:");
			v_id = sc.nextInt();
			
			//contatoDAO.getContatos();
				 
			//System.out.println("NOME: " + c.getNome());
			
		}
		
		
		else if (v_opcao == 4 ) {

			// TODO Auto-generated method stub
			ContatoDAO contatoDAO = new ContatoDAO();
			 for(Contato c : contatoDAO.getContatos()){
				 
				 System.out.println("NOME: " + c.getNome());
			 
			
		}

		}
		 sc.close();
		
	}
				
}