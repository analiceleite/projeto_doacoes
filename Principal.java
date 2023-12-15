import java.util.Scanner;

public class Principal {

  public static void main(String[] args) throws Exception {
    try (Scanner scan = new Scanner(System.in)) {
        GestaoEstoque ge = new GestaoEstoque();
        GestaoUsuarios gu = new GestaoUsuarios();
        GestaoVoluntario gv = new GestaoVoluntario();
        Usuario u = new Usuario();
        boolean voluntarioValido = Validacao.validarIdadeVoluntario(0);
        int opcao = 0;
        int opcaoLogin = 0;
        int opcaoCategorias = 0;
        int idVoluntario = 0;
        int id = 0;
        int opcaoMenus = 0;
        int opcaoMenuPrincipal = 0;
        int opcaoMenuEstoque = 0;
        int opcaoMenuVoluntario = 0;
        boolean jaLogou = false;
        boolean buscarLogin = false;

        // Fazer a validação do login
        do {
          EntradaSaida.escolherOpcaoMenuLogin();2
          opcaoLogin = scan.nextInt();
          if (opcaoLogin == 1) {
            String senha;
            String login;
            System.out.println("Login: ");
            login = scan.next();
            System.out.println("Senha: ");
            senha = scan.next();
            jaLogou = gu.buscarLogin(login, senha);

          } else if (opcaoLogin == 2) {
            System.out.println("----Tela de cadastro----");
            System.out.println("Informe o login da sua conta: ");
            u.setSenha(scan.next());
            System.out.println("Informa a senha da sua conta: ");
            u.setLogin(scan.next());
            gu.adicionarUsuario(u);
            jaLogou = false;
            
          } else if (opcaoLogin == 3) {
            System.exit(0);
          }
        } while (!jaLogou);

        if (u.getLogin().equals("admin") && u.getSenha().equals("admin")) {
          // funções admin
          System.out.println("Bem vindo administrador!");
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
                    System.out.println("Insira a descrição da doação: ");
                    d.descricao = scan.next();
                    System.out.println("Insira a quantidade: ");
                    d.quantidade = scan.next();
                    d.categoria = "Vestuário";
                    ge.cadastrarDoacao(d);
                    EntradaSaida.escolherOpcaoMenuADM();
                    break;
                  case 2:
                    System.out.println("Insira a descrição da doação: ");
                    d.descricao = scan.next();
                    System.out.println("Insira a quantidade: ");
                    d.quantidade = scan.next();
                    d.categoria = "Alimento";
                    ge.cadastrarDoacao(d);
                    EntradaSaida.escolherOpcaoMenuADM();

                    break;
                  case 3:
                    System.out.println("Insira a descrição da doação: ");
                    d.descricao = scan.next();
                    System.out.println("Insira a quantidade: ");
                    d.quantidade = scan.next();
                    d.categoria = "Móveis";
                    ge.cadastrarDoacao(d);
                    EntradaSaida.escolherOpcaoMenuADM();

                    break;
                  case 4:
                    System.out.println("Insira a descrição da doação: ");
                    d.descricao = scan.next();
                    System.out.println("Insira o valor: ");
                    d.quantidade = scan.next();
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
              case 2:
                // Visualizar doações cadastradas
                System.out.println(ge.mostrarDoacoesCadastradas());
                break;
              case 3:
                // Alterar descrição de alguma doação
                EntradaSaida.solicitarId("alterar");
                id = scan.nextInt();
                System.out.println(ge.alterarDescricaoDoacao(id));
                break;
              case 4:
                // Excluir cadastro
                EntradaSaida.solicitarId("excluir");
                id = scan.nextInt();
                System.out.println(ge.deletarDoacao(id - 1));
                break;
              case 5:
                // Dar entrada em doaç?es para o estoque

                break;
              case 6:
                // Consultar doaç?es em estoque por ID

                break;
              case 7:
                // Consultar doaç?es por categoria

                break;
              case 8:
                // Realizar cadastro para voluntariado:
                Voluntario v = new Voluntario();
                System.out.println("Informe o nome do doador: ");
                v.nomeVoluntario = scan.next();
                while (voluntarioValido == false) {
                  System.out.println(
                    "Informe a idade (o doador deve ser maior de 18): "
                  );
                  v.idadeVoluntario = scan.nextInt();
                  voluntarioValido =
                    Validacao.validarIdadeVoluntario(v.idadeVoluntario);
                }
                System.out.println("Informe o CPF: ");
                v.cpfVoluntario = scan.next();
                System.out.println("Informe o endereço: ");
                v.enderecoVoluntario = scan.next();
                System.out.println("Informe o telefone: ");
                v.telefone = scan.next();
                gv.adicionarVoluntario(v);
                System.out.print("Cadastro realizado com sucesso!");
                break;
              case 9:
                // Motrar voluntários cadastrados:
                System.out.println(gv.mostrarVoluntariosCadastrados());
                break;
              case 10:
                // Editar informações dos voluntários cadastrados:
                EntradaSaida.escolherOpcaoMenuVoluntarios();
                opcaoMenuVoluntario = scan.nextInt();
                switch (opcaoMenuVoluntario) {
                  case 1:
                    // Editar nome voluntário
                    EntradaSaida.solicitarId("alterar");
                    id = scan.nextInt();
                    System.out.println(gv.alterarNomeVoluntario(id));
                    break;
                  case 2:
                    // Editar idade voluntário
                    EntradaSaida.solicitarId("alterar");
                    idVoluntario = scan.nextInt();
                    System.out.println(gv.alterarIdadeVoluntario(idVoluntario));
                    break;
                  case 3:
                    // Editar endereço voluntário
                    EntradaSaida.solicitarId("alterar");
                    idVoluntario = scan.nextInt();
                    System.out.println(gv.alterarEnderecoVoluntario(idVoluntario));

                    break;
                  case 4:
                    // Editar telefone voluntário
                    EntradaSaida.solicitarId("alterar");
                    idVoluntario = scan.nextInt();
                    System.out.println(gv.alterarTelefoneVoluntario(idVoluntario));
                    break;
                  case 5:
                    EntradaSaida.escolherOpcaoMenuADM();
                    break;
                  default:
                    System.exit(0);
                    break;
                }
                break;
              default:
                break;
            }
          } while (opcao != 0);
        } else {
          do {
            EntradaSaida.escolherOpcaoMenuUsuario();
            opcao = scan.nextInt();

            switch (opcao) {
              case 1:
                // Solicitar dados e cadastrar doação no menu de categorias
                Doacao d = new Doacao();
                EntradaSaida.escolherOpcaoMenuCategorias();
                opcaoCategorias = scan.nextInt();

                switch (opcaoCategorias) {
                  case 1:
                    System.out.println("Insira a descrição da doação: ");
                    d.descricao = scan.next();
                    System.out.println("Insira a quantidade: ");
                    d.quantidade = scan.next();
                    d.categoria = "Vestuário";
                    ge.cadastrarDoacao(d);
                    EntradaSaida.escolherOpcaoMenuADM();
                    break;
                  case 2:
                    System.out.println("Insira a descrição da doação: ");
                    d.descricao = scan.next();
                    System.out.println("Insira a quantidade: ");
                    d.quantidade = scan.next();
                    d.categoria = "Alimento";
                    ge.cadastrarDoacao(d);
                    EntradaSaida.escolherOpcaoMenuADM();

                    break;
                  case 3:
                    System.out.println("Insira a descrição da doação: ");
                    d.descricao = scan.next();
                    System.out.println("Insira a quantidade: ");
                    d.quantidade = scan.next();
                    d.categoria = "Móveis";
                    ge.cadastrarDoacao(d);
                    EntradaSaida.escolherOpcaoMenuADM();

                    break;
                  case 4:
                    System.out.println("Insira a descrição da doação: ");
                    d.descricao = scan.next();
                    System.out.println("Insira o valor: ");
                    d.quantidade = scan.next();
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
              case 2:
                // Visualizar minhas doações cadastradas
                System.out.println(ge.mostrarDoacoesCadastradas());
                break;
              case 3:
                // Alterar descrição de alguma doação minha
                EntradaSaida.solicitarId("alterar");
                id = scan.nextInt();
                System.out.println(ge.alterarDescricaoDoacao(id));
                break;
              case 4:
                // Excluir cadastro
                EntradaSaida.solicitarId("excluir");
                id = scan.nextInt();
                System.out.println(ge.deletarDoacao(id - 1));
                break;
              case 5:
                // Realizar cadastro para voluntariado:
                Voluntario v = new Voluntario();
                System.out.println("Informe o nome do voluntário: ");
                v.nomeVoluntario = scan.next();
                while (voluntarioValido == false) {
                  System.out.println(
                    "Informe a idade (o voluntário tende a ser maior de 18): "
                  );
                  v.idadeVoluntario = scan.nextInt();
                  voluntarioValido =
                    Validacao.validarIdadeVoluntario(v.idadeVoluntario);
                }
                System.out.println("Informe o CPF: ");
                v.cpfVoluntario = scan.next();
                System.out.println("Informe o endereço: ");
                v.enderecoVoluntario = scan.next();
                System.out.println("Informe o telefone: ");
                v.telefone = scan.next();
                gv.adicionarVoluntario(v);
                System.out.print("Cadastro realizado com sucesso!\n");
                break;
              case 6:
                // Motrar meu cadastro:
                System.out.println(gv.mostrarCadastroUsuario());
                break;
              case 7:
                // Editar meu cadastro:
                EntradaSaida.escolherOpcaoMenuVoluntarios();
                opcaoMenuVoluntario = scan.nextInt();
                switch (opcaoMenuVoluntario) {
                  case 1:
                    // Editar nome voluntário
                    EntradaSaida.solicitarId("alterar");
                    id = scan.nextInt();
                    System.out.println(gv.alterarNomeVoluntario(id));
                    break;
                  case 2:
                    // Editar idade voluntário
                    EntradaSaida.solicitarId("alterar");
                    idVoluntario = scan.nextInt();
                    System.out.println(gv.alterarIdadeVoluntario(idVoluntario));
                    break;
                  case 3:
                    // Editar endereço voluntário
                    EntradaSaida.solicitarId("alterar");
                    idVoluntario = scan.nextInt();
                    System.out.println(gv.alterarEnderecoVoluntario(idVoluntario));

                    break;
                  case 4:
                    // Editar telefone voluntário
                    EntradaSaida.solicitarId("alterar");
                    idVoluntario = scan.nextInt();
                    System.out.println(gv.alterarTelefoneVoluntario(idVoluntario));
                    break;
                  case 5:
                    EntradaSaida.escolherOpcaoMenuADM();
                    break;
                }
                break;
              case 8:
                // Excluir meu cadastro
                System.out.println(
                  "Tem certeza que deseja excluir seu cadatro? \n-Sim \n-Não "
                );
                String resposta = scan.next();
                resposta.toLowerCase();
                if (resposta.equals("sim")) {
                  id = 0;
                  System.out.println(gv.deletarCadastro(id));
                } else {
                  EntradaSaida.escolherOpcaoMenuADM();
                }
                break;
              case 9:
                // Voltar para a tela de login

                break;
              default:
                System.exit(0);
                break;
            }
          } while (opcao != 0);
        }
    }
  }
}
