
public class EntradaSaida {

    // Método para mostrar opções menu de login
    public static void escolherOpcaoMenuLogin() {

        System.out.println("------------ BEM VINDO AO MOVIMENTO DOAR ------------ \n" +
                "\nPor favor escolha uma das operações a seguir:\n\n" +
                "1 - Logar em sua conta \n" +
                "2 - Cadastrar uma nova conta \n"+
                "3 - Sair \n");
    }

    // Método para mostrar opções menu principal
    public static void escolherOpcaoMenuADM() {

        System.out.println("------------ BEM VINDO AO DONATION MANAGER ------------ \n" +
                "\nEscolha uma opção para tratativas acerca de doações:\n\n" +
                "1 - Cadastrar doação \n" +
                "2 - Visualizar doações cadastradas \n" +
                "3 - Alterar descrição de alguma doação \n" +
                "4 - Excluir cadastro \n" +
                "\nEscolha uma opção para tratativas acerca de inserção de doações no estoque:\n\n" +
                "5 - Dar entrada em doações para o estoque \n" +
                "6 - Consultar doações em estoque por ID \n" +
                "7 - Consultar doações por categoria \n" +
                "\nEscolha uma opção para tratativas acerca de voluntariado:\n\n" +
                "8 - Realizar cadastro para voluntariado \n" +
                "9 - Visualizar voluntários cadastrados\n" +
                "10 - Editar informações dos voluntários cadastrados\n" +
                "0 - Sair do programa \n");
    }

    // Método para mostrar opções menu principal
    public static void escolherOpcaoMenuUsuario() {

        System.out.println("------------ BEM VINDO AO MOVIMENTO DOAR ------------ \n" +
                "\nEscolha uma opção para tratativas acerca de doações:\n\n" +
                "1 - Cadastrar doação \n" +
                "2 - Visualizar minhas doações cadastradas \n" +
                "3 - Alterar descrição de alguma doação \n" +
                "4 - Excluir cadastro \n" +
                "\nEscolha uma opção para tratativas acerca de voluntariado:\n\n" +
                "5 - Realizar cadastro para voluntariado \n" +
                "6 - Visualizar informações do meu cadastro \n" +
                "7 - Editar informações do meu cadastro \n" +
                "8 - Excluir meu cadastro \n" +
                "0 - Sair do programa \n");
    }

    // Método para mostrar menu secundário (contendo as categorias)
    public static void escolherOpcaoMenuCategorias() {

        System.out.print("Escolha uma opção: \n" +
                "1 - Vestuário\n" +
                "2 - Alimento \n" +
                "3 - Móveis \n" +
                "4 - Dinheiro \n" +
                "5 - Voltar ao menu principal \n" +
                "0 - Sair \n");
    }

    // Solicitar ID
    public static void solicitarId(String msg) {
        System.out.print("Informe o ID do cadastro que deseja "+ msg +":" );
    }

    public static void escolherOpcaoMenuVoluntarios() {
             System.out.print("Oque você deseja alterar? \n" +
                "1 - Nome\n" +
                "2 - Idade \n" +
                "3 - Endereço \n" +
                "4 - Telefone \n" +
                "5 - Voltar ao menu principal \n");
    }

    // System.out.println("Insira o seu usuário: ");
    // String user = System.console().readLine();
    // return b.procurarUsuario(user, b);
    // return JOption.showInputDialog("Insira o seu usuário")

}
