import java.util.Scanner;

public class Principal {

  public static void main(String[] args) throws Exception {
    GestaoUsuarios.cadastrarUsuarioAdmin();
    try (Scanner scan = new Scanner(System.in)) {
      GestaoUsuarios gu = new GestaoUsuarios();  
      boolean existente = false;
   
      // Login
      do {
        EntradaSaida.limpatela();
        switch (EntradaSaida.menuPrincipal()) {
          case 1: // Controle de estoque
            Validacao.validarLogin(gu);
            break;
          case 2: // Administração
            if (Validacao.validarLoginAdm(gu)) {
              EntradaSaida.escolherOpcaoMenuAdm();
            } else {
              System.out.println("Login ou senha inválidos. Tente novamente.\n");
            }
            break;
          case 0: // Sair
            System.exit(0);
            break;
          default:
            break;
        }
      } while (!existente);
    }
  }
}
