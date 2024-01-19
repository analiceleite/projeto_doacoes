import java.util.Scanner;

public class Principal {

  public static void main(String[] args) throws Exception {
    GestaoUsuarios.cadastrarUsuarioAdmin();
    try (Scanner scan = new Scanner(System.in)) {
      GestaoUsuarios gu = new GestaoUsuarios();

      Usuario u = new Usuario();
      boolean existente = false;
      String senhaUsuario = "";

      // Login
      do {
        switch (EntradaSaida.menuPrincipal()) {
          case 1: // Solicitar dados
            Validacao.validarLogin(gu);
            break;
          case 2: // Cadastrar
            u.setNome(EntradaSaida.solicitarDadosCadastro("nome"));
            u.setLogin(EntradaSaida.solicitarDadosCadastro("login"));
            u.setSenha(EntradaSaida.solicitarDadosCadastro("senha"));
            senhaUsuario =
              EntradaSaida.solicitarDadosCadastro("confirmação de senha");
            gu.adicionarUsuario(u, senhaUsuario);
            EntradaSaida.limpatela();
            break;
          case 3: // Sair
            System.exit(0);
            break;
          default:
            break;
        }
      } while (!existente);
    }
  }
}
