import java.util.ArrayList;
import java.util.Scanner;

public class GestaoEstoque {
  Scanner scan = new Scanner(System.in);

  public ArrayList<DoacaoEmEstoque> doacoesEstoque = new ArrayList<DoacaoEmEstoque>();

  public void adicionarDoacoes(DoacaoEmEstoque Doacao) {
    this.doacoesEstoque.add(Doacao);
  }

  public ArrayList<Doacao> doacoesCadastradas = new ArrayList<Doacao>();

  public void cadastrarDoacao(Doacao Doacao) {
    int id = 1;
    for (Doacao d : this.doacoesCadastradas) {
      if (d.id >= id) {
        id = d.id + 1;
      }
    }
    Doacao.id = id;
    this.doacoesCadastradas.add(Doacao);
  }

  // Visualizar doações cadastradas
  public String mostrarDoacoesCadastradas() {
    String mensagem = "";

    for (Doacao d : this.doacoesCadastradas) {
    System.out.println( mensagem += "\nAs informações das doações cadastradas são: \n" + "\n ID: " +
    d.id +
    "\n Categoria: " +
    d.categoria +
    "\n Descrição: " +
    d.descricao +
    "\n Quantidade: " +
    d.quantidade + "\n");
    }
    
    return mensagem;
  }

  // Editar descrição doação
  public String alterarDescricaoDoacao(int id) {
    boolean encontrado = false;

    for (Doacao d : this.doacoesCadastradas) {
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

    for (Doacao d : this.doacoesCadastradas) {
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

    for (Doacao d : this.doacoesCadastradas) {
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

    this.doacoesCadastradas.remove(id);
    return "Tarefa removida com sucesso!";
  }
}


