import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GestaoEstoque {

  Scanner scan = new Scanner(System.in);
  GestaoEstoque ge = new GestaoEstoque();

  public ArrayList<DoacaoEmEstoque> doacoesEstoque = new ArrayList<DoacaoEmEstoque>();

  public void adicionarDoacoes(DoacaoEmEstoque Doacao) {
    this.doacoesEstoque.add(Doacao);
  }

  public static ArrayList<Doacao> doacoesCadastradas = new ArrayList<Doacao>();

  public static void cadastrarDoacao(Doacao Doacao) {
    int id = 1;
    for (Doacao d : doacoesCadastradas) {
      if (d.id >= id) {
        id = d.id + 1;
      }
    }
    Doacao.id = id;
    doacoesCadastradas.add(Doacao);
  }

  // Visualizar doações cadastradas
  public static void mostrarDoacoesCadastradas() throws InterruptedException, IOException {
    Recursos.limpatela();
    System.out.println("\nDoações cadastradas: ");

    for (Doacao d : doacoesCadastradas) {
    if (d.categoria != "Dinheiro") {
      System.out.println(
          "\nID: " +
          d.id +
          "\nCategoria: " +
          d.categoria +
          "\nDescrição: " +
          d.descricao +
          "\nQuantidade: " +
          d.quantidade +
          "\n"
      ); 
    }
      
    if (d.categoria == "Dinheiro") {
      System.out.println(
          "\nID: " +
          d.id +
          "\nCategoria: " +
          d.categoria +
          "\nDescrição: " +
          d.descricao +
          "\nValor " +
          d.quantidade +
          "\n");
    }
    
    }
    System.out.println("Pressione ENTER para voltar... \n"); 
    try {
      System.in.read(new byte[2]);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

  // Editar descrição doação
  public String alterarDescricaoDoacao(int id) {
    boolean encontrado = false;

    for (Doacao d : doacoesCadastradas) {
      encontrado = true;
      if (d.id == id) {
        System.out.println("Digite a nova descrição da sua doação: ");
        d.descricao = scan.next();
      }
    }
    if (encontrado == true) {
      return ("Descrição alterada com sucesso! ");
    } else {
      return ("Cadastro da doação não encontrado! ");
    }
  }

  // Editar id doação
  public String alterarIdDoacao(int id) {
    boolean encontrado = false;

    for (Doacao d : doacoesCadastradas) {
      encontrado = true;
      if (d.id == id) {
        System.out.println("Digite o novo ID do cadastro: ");
        d.id = scan.nextInt();
      }
    }
    if (encontrado == true) {
      return ("ID alterado com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }
  }

  // Editar categoria doação
  public String alterarCategoriaDoacao(int id) {
    boolean encontrado = false;

    for (Doacao d : doacoesCadastradas) {
      encontrado = true;
      if (d.id == id) {
        System.out.println("Digite a nova categoria da doação: ");
        d.categoria = scan.next();
      }
    }
    if (encontrado == true) {
      return ("Categoria alterada com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }
  }

  // Excluir doação
  public String deletarDoacao(int id) {
    doacoesCadastradas.remove(id);
    return "Tarefa removida com sucesso!";
  }
}
