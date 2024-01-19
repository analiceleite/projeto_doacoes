import java.util.Scanner;

public class Principal {
  public static void main(String[] args) throws Exception {
    GestaoUsuarios.cadastrarUsuarioAdmin();
    try (Scanner scan = new Scanner(System.in)) {
      GestaoEstoque ge = new GestaoEstoque();
      GestaoUsuarios gu = new GestaoUsuarios();

      Usuario u = new Usuario();
      int opcao = 0;
      // int opcaoMenuPrincipal = 0;
      int opcaoCategorias = 0;
      int id = 0;
      // int opcaoMenus = 0;
      // int opcaoMenuPrincipal = 0;
      // int opcaoMenuEstoque = 0;
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
            senhaUsuario = EntradaSaida.solicitarDadosCadastro("confirmação de senha");
            gu.adicionarUsuario(u,senhaUsuario);
            EntradaSaida.limpatela();
          break;

          case 3: // Sair
            System.exit(0);
          break;

          default:
            break;
        }
      } while (!existente);

      // Login Admin
      if (u.getLogin().equals("admin") && u.getSenha().equals("admin")) {
        System.out.println("\n Bem vindo administrador!\n ");
        do {
          EntradaSaida.escolherOpcaoMenuADM();
          opcao = scan.nextInt();
          switch (opcao) {
            case 1:
              // Solicitar dados e cadastrar doação no menu de categorias
              Doacao d = new Doacao();
              EntradaSaida.escolherOpcaoMenuCategorias();
              opcaoCategorias = scan.nextInt();

              switch (opcaoCategorias) {
                case 1:
                  System.out.println("\nInsira a descrição da doação: ");
                  d.descricao = scan.next();
                  System.out.println("Insira a quantidade: ");
                  d.quantidade = scan.nextInt();
                  d.categoria = "Vestuário";
                  ge.cadastrarDoacao(d);
                  EntradaSaida.escolherOpcaoMenuADM();
                  break;
                case 2:
                  System.out.println("\nInsira a descrição da doação: ");
                  d.descricao = scan.next();
                  System.out.println("Insira a quantidade: ");
                  d.quantidade = scan.nextInt();
                  d.categoria = "Alimento";
                  ge.cadastrarDoacao(d);
                  EntradaSaida.escolherOpcaoMenuADM();

                  break;
                case 3:
                  System.out.println("Insira a descrição da doação: ");
                  d.descricao = scan.next();
                  System.out.println("Insira a quantidade: ");
                  d.quantidade = scan.nextInt();
                  d.categoria = "Móveis";
                  ge.cadastrarDoacao(d);
                  EntradaSaida.escolherOpcaoMenuADM();

                  break;
                case 4:
                  System.out.println("Insira a descrição da doação: ");
                  d.descricao = scan.next();
                  System.out.println("Insira o valor: ");
                  d.quantidade = scan.nextInt();
                  d.categoria = "Dinheiro";
                  ge.cadastrarDoacao(d);
                  EntradaSaida.escolherOpcaoMenuADM();
                  break;
                case 5:
                  EntradaSaida.escolherOpcaoMenuADM();
                  break;
                default:
                  System.exit(0);
                  break;
              }
            break;
            case 2: // Visualizar doações cadastradas
              System.out.println(ge.mostrarDoacoesCadastradas());
              break;
            case 3: // Alterar descrição de alguma doação
              EntradaSaida.solicitarId("alterar");
              id = scan.nextInt();
              System.out.println(ge.alterarDescricaoDoacao(id));
              break;
            case 4: // Excluir cadastro
              EntradaSaida.solicitarId("excluir");
              id = scan.nextInt();
              System.out.println(ge.deletarDoacao(id - 1));
              break;
            case 5: // Dar entrada em doações para o estoque
              break;
            case 6: // Consultar doações em estoque por ID
              break;
            case 7: // Consultar doações por categoria
              break;

          }
        } while (opcao != 0);
      } else {
        do {
          EntradaSaida.escolherOpcaoMenuUsuario();
          opcao = scan.nextInt();

          switch (opcao) {
            case 1: // Solicitar dados e cadastrar doação no menu de categorias
              Doacao d = new Doacao();
              EntradaSaida.escolherOpcaoMenuCategorias();
              opcaoCategorias = scan.nextInt();

              switch (opcaoCategorias) {
                case 1:
                  d.descricao = System.console().readLine("Insira a descrição da doação: ");
                  System.out.println("Insira a quantidade: ");
                  d.quantidade = scan.nextInt();
                  d.categoria = "Vestuário";
                  ge.cadastrarDoacao(d);
                  EntradaSaida.escolherOpcaoMenuADM();
                  break;
                case 2:
                  System.out.println("Insira a descrição da doação: ");
                  d.descricao = scan.next();
                  System.out.println("Insira a quantidade: ");
                  d.quantidade = scan.nextInt();
                  d.categoria = "Alimento";
                  ge.cadastrarDoacao(d);
                  EntradaSaida.escolherOpcaoMenuADM();

                  break;
                case 3:
                  System.out.println("Insira a descrição da doação: ");
                  d.descricao = scan.next();
                  System.out.println("Insira a quantidade: ");
                  d.quantidade = scan.nextInt();
                  d.categoria = "Móveis";
                  ge.cadastrarDoacao(d);
                  EntradaSaida.escolherOpcaoMenuADM();

                  break;
                case 4:
                  System.out.println("Insira a descrição da doação: ");
                  d.descricao = scan.next();
                  System.out.println("Insira o valor: ");
                  d.quantidade = scan.nextInt();
                  d.categoria = "Dinheiro";
                  ge.cadastrarDoacao(d);
                  EntradaSaida.escolherOpcaoMenuADM();
                  break;
                case 5:
                  EntradaSaida.escolherOpcaoMenuADM();
                  break;
                default:
                  System.exit(0);
                  break;
              }
            break;
            case 2: // Visualizar minhas doações cadastradas
              System.out.println(ge.mostrarDoacoesCadastradas());
              break;
            case 3: // Alterar descrição de alguma doação minha
              EntradaSaida.solicitarId("alterar");
              id = scan.nextInt();
              System.out.println(ge.alterarDescricaoDoacao(id));
              break;
            case 4: // Excluir cadastro
              EntradaSaida.solicitarId("excluir");
              id = scan.nextInt();
              System.out.println(ge.deletarDoacao(id - 1));
              break;
          }
        } while (opcao != 0);
      }
    }
  }
}