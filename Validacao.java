import java.io.IOException;

public class Validacao {

    static boolean existente = false;
    // Validar login
    public static Usuario validarLogin(GestaoUsuarios gu) throws InterruptedException, IOException {
        String login = EntradaSaida.solicitarDadosLogin("seu login: ");
        String senha = EntradaSaida.solicitarDadosLogin("sua senha: ");
        Usuario usuarioLogado = gu.buscarLogin(login, senha, null);
        if (usuarioLogado != null && usuarioLogado.getLogin() == "admin" ) {
            Validacao.validarLoginAdm();
        } else if (usuarioLogado != null) {
            do{
                switch (EntradaSaida.escolherOpcaoMenuUsuario()) {
                    case 1:
                        System.out.println("'case 1'");
                    break;
                    case 2:
                        System.out.println("'case 2'");
                    break;
                    case 3:
                    break;
                    case 4:
                    break;
                    default:
                    break;
                } 
            } while (!existente);
        } else {
            System.out.println("\nUsuário não encontrado!\nCadastre-se ou tente novamente.");
            EntradaSaida.limpatela();
        }
        return null;
    }

    public static Usuario validarLoginAdm() throws InterruptedException, IOException {
        do {
            switch (EntradaSaida.escolherOpcaoMenuADM()) {
            case 1: // Cadastrar doação no menu de categorias
                Doacao d = new Doacao();
                switch (EntradaSaida.escolherOpcaoMenuCategorias()) {
                case 1:
                    EntradaSaida.cadastrarDoacaoVestuario(d, null);
                    break;
                case 2:
                    System.out.println("case 2.");
                    // d.descricao = (System.console().readLine("\nInsira a descrição da doação: "));
                    // d.quantidade = (System.console().readLine("\nInsira a quantidade: "));
                    // d.categoria = "Alimento";
                    // ge.cadastrarDoacao(d);
                    // EntradaSaida.escolherOpcaoMenuADM();
                    break;
                case 3:
                    System.out.println("case 3.");
                    // d.descricao = (System.console().readLine("\nInsira a descrição da doação: "));
                    // d.quantidade = (System.console().readLine("\nInsira a quantidade: "));
                    // d.categoria = "Móveis";
                    // ge.cadastrarDoacao(d);
                    // EntradaSaida.escolherOpcaoMenuADM();
                    break;
                case 4:
                    System.out.println("case 4.");
                    // d.descricao = (System.console().readLine("\nInsira a descrição da doação: "));
                    // d.quantidade = (System.console().readLine("\nInsira a quantidade: "));
                    // d.categoria = "Dinheiro";
                    // ge.cadastrarDoacao(d);
                    // EntradaSaida.escolherOpcaoMenuADM();
                    break;
                case 5:
                System.out.println("case 5.");
                    // EntradaSaida.escolherOpcaoMenuADM();
                    break;
                default:
                    // System.exit(0);
                    break;
                }
            break;




        //     case 2: // Visualizar doações cadastradas
        //         System.out.println(ge.mostrarDoacoesCadastradas());
        //         break;
        //     case 3: // Alterar descrição de alguma doação
        //         EntradaSaida.solicitarId("alterar");
        //         id = scan.nextInt();
        //         System.out.println(ge.alterarDescricaoDoacao(id));
        //         break;
        //     case 4: // Excluir cadastro
        //         EntradaSaida.solicitarId("excluir");
        //         id = scan.nextInt();
        //         System.out.println(ge.deletarDoacao(id - 1));
        //         break;
        //     case 5: // Dar entrada em doações para o estoque
        //         break;
        //     case 6: // Consultar doações em estoque por ID
        //         break;
        //     case 7: // Consultar doações por categoria
        //         break;

            }
        } while (!existente);;
return null;

}
}
