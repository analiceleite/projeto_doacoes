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
            EntradaSaida.limpatela();
            String login = EntradaSaida.solicitarDadosCadastro("seu login");
            String senha = EntradaSaida.solicitarDadosCadastro("sua senha");
            
            if ( login.compareTo("admin") != 0 ) {
              System.out.println(Cor.RED + "Usuário sem pemissões!\n");
              Thread.sleep(2000);
            } else {
              Usuario usuarioLogado = gu.buscarLogin(login, senha);
              if (Validacao.validarLoginAdm(usuarioLogado)) {
                EntradaSaida.escolherOpcaoMenuAdm(usuarioLogado.getNome());
              } else {
                System.out.println(Cor.RED + "Login ou senha inválidos. Tente novamente.\n");
                Thread.sleep(2000);
              }
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
