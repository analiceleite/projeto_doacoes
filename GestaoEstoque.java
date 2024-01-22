import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GestaoEstoque {

  static Scanner scan = new Scanner(System.in);

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
  public static void mostrarDoacoesCadastradas()
    throws InterruptedException, IOException {
    EntradaSaida.limpatela();
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
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(
          Locale.forLanguageTag("pt-BR")
        );
        String valorFormatado = formatoMoeda.format(d.quantidade);
        System.out.println(
          "\nID: " +
          d.id +
          "\nCategoria: " +
          d.categoria +
          "\nDescrição: " +
          d.descricao +
          "\nValor: " +
          valorFormatado +
          "\n"
        );
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
  public static String alterarDescricaoDoacao(int id) {
    for (Doacao d : doacoesCadastradas) {
        if (d.id == id) {
            System.out.println("\nDigite a nova descrição da sua doação: ");
            d.descricao = scan.next();
            return "\nDescrição alterada com sucesso!";
        }
    }
    return "ID não encontrado!";
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
  public static String deletarDoacao(int id) {
    for (int i = 0; i < doacoesCadastradas.size(); i++) {
        Doacao d = doacoesCadastradas.get(i);
        if (d.id == id) {
            doacoesCadastradas.remove(i);
            return "Doação removida com sucesso!";
        }
    }
    return "ID não encontrado. Nenhuma doação removida.";
}

// Dar baixa na doação em estoque

  public static boolean removeQtdAtualProduto(int id, int qtdSaida) {
    boolean result = false;

    for (Doacao d : doacoesCadastradas) {
      if (d.id == id) {
        try {
          int qtd = d.quantidade;
          int novaQtd = qtd - qtdSaida;
          if (novaQtd >= 0) {
            d.quantidade = (novaQtd);
            result = true;
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Erro na alteração da quantidade atual do produto. Valor final menor do que o minimo permitido! "
            );
          }
        } catch (Exception e) {
          result = false;
        }
      }
    }
    return result;
  }

// Dar entrada na doação em estoque

public static boolean addQtdAtualProduto(int id, int qtdAtual) {
  boolean result = false;

  for (Doacao d : doacoesCadastradas) {
    if (d.id == id) {
      try {
        int qtd = d.quantidade;
        int novaQtd = qtd + qtdAtual;
        d.quantidade = (novaQtd);
        result = true;
      } catch (Exception e) {
        result = false;
      }
    }
  }
  return result;
}

}
