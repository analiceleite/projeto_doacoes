
public class EntradaSaida {

    public static int selecionaOpcao() {
        return Integer.parseInt(System.console().readLine("Opção --> "));
    }

    // Menus
    public static void titulo() {
        System.out.println("------------ BEM VINDO AO MOVIMENTO DOAR ------------\n");
    }

    public static int menuPrincipal() {
        System.out.println("\n Escolha uma das operações a seguir:\n\n" +
                "[1]- Logar\n" +
                "[2]- Cadastrar\n" +
                "[3]- Sair \n");
        return selecionaOpcao();
    }

    public static void escolherOpcaoMenuADM() {
        System.out.println("------------ BEM VINDO AO MOVIMENTO DOAR ------------ \n" +
                "\nEscolha uma opção para tratativas acerca de doações:\n\n" +
                "[1]- Cadastrar doação \n" +
                "[2]- Visualizar doações cadastradas \n" +
                "[3]- Alterar descrição de alguma doação \n" +
                "[4]- Excluir cadastro \n" +
                "\nEscolha uma opção para tratativas do estoque:\n\n" +
                "[5]- Dar entrada em doações para o estoque \n" +
                "[6]- Consultar doações em estoque por ID \n" +
                "[7]- Consultar doações por categoria \n" +
                "[8]- Voltar ao menu principal\n" +
                "\n[0]- Sair do programa \n");
    }

    public static void escolherOpcaoMenuUsuario() {
        System.out.println("------------ BEM VINDO AO MOVIMENTO DOAR ------------ \n" +
                "\nDoações:\n\n" +
                "[1]- Cadastrar doação \n" +
                "[2]- Visualizar minhas doações cadastradas \n" +
                "[3]- Alterar descrição de alguma doação \n" +
                "{4}- Excluir cadastro \n");
    }

    public static void escolherOpcaoMenuCategorias() {

        System.out.print("Escolha uma opção: \n\n" +
                "[1]- Vestuário\n" +
                "[2]- Alimento \n" +
                "[3]- Móveis \n" +
                "[4]- Dinheiro \n" +
                "[5]- Voltar ao menu principal \n" +
                "[0]- Sair \n");
    }

    public static void solicitarId(String msg) {
        System.out.print("Informe o ID do cadastro que deseja " + msg + ":");
    }

    // Preencher infos login

    public static String solicitarDadosLogin(String mensagem) {
        return System.console().readLine("Insira " + mensagem);
    }
}
