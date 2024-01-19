import java.io.IOException;

public class EntradaSaida {

        
    public static void limpatela() throws InterruptedException, IOException {// Limpar tela
        try {
            // Aguarda por 2 segundos
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // Lida com a exceção se a thread for interrompida enquanto estiver dormindo
            e.printStackTrace();
        }
    
        // Limpa a tela
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static int selecionaOpcao() {// Selecionar opção int
        return Integer.parseInt(System.console().readLine("Opção --> "));
    }

    // Menus

    public static void titulo() { // Título
        System.out.println("------------ BEM VINDO AO MOVIMENTO DOAR ------------\n");
    }
    public static int menuPrincipal() {
        System.out.println("\nEscolha uma das operações a seguir:\n\n" +
                "[1]- Logar\n" +
                "[2]- Cadastrar\n" +
                "[3]- Sair \n");
        return selecionaOpcao();
    }
    public static int escolherOpcaoMenuADM() {
        System.out.println("\nEscolha uma opção para tratativas acerca de doações:\n\n" +
                "[1]- Cadastrar doação \n" +
                "[2]- Visualizar doações cadastradas \n" +
                "[3]- Alterar descrição de alguma doação \n" +
                "[4]- Excluir cadastro \n" +
                "\nEscolha uma opção para tratativas do estoque:\n\n" +
                "[5]- Dar entrada em doações para o estoque \n" +
                "[6]- Consultar doações em estoque por ID \n" +
                "[7]- Consultar doações por categoria \n" +
                "[8]- Voltar ao menu principal\n" +
                "[0]- Sair do programa \n");
            return selecionaOpcao();
    }
    public static int escolherOpcaoMenuUsuario() {
        System.out.println("\nDoações:\n\n" +
                "[1]- Cadastrar doação \n" +
                "[2]- Visualizar minhas doações cadastradas \n" +
                "[3]- Alterar descrição de alguma doação \n" +
                "[4]- Excluir cadastro \n");
        return selecionaOpcao();
    }
    public static int escolherOpcaoMenuCategorias() {

        System.out.print("Escolha uma opção: \n\n" +
                "[1]- Vestuário\n" +
                "[2]- Alimento \n" +
                "[3]- Móveis \n" +
                "[4]- Dinheiro \n" +
                "[5]- Voltar ao menu principal \n" +
                "[0]- Sair \n");
        return selecionaOpcao();
    }

    public static int cadastrarDoacaoVestuario(Doacao d, GestaoEstoque ge) {
         d.descricao = (System.console().readLine("\nInsira a descrição da doação: "));
         d.quantidade = Integer.parseInt(System.console().readLine("\nInsira a quantidade: "));
         d.categoria = "Vestuário";
         ge.cadastrarDoacao(d);
         EntradaSaida.escolherOpcaoMenuADM();
        
        return 0;
    }
    
    // Preencher infos 
    public static void solicitarId(String msg) {
        System.out.print("Informe o ID do cadastro que deseja " + msg + ":");
    }

    public static String solicitarDadosLogin(String mensagem) {
        return System.console().readLine("Informe " + mensagem);
    }

    public static String solicitarDadosCadastro(String mensagem) {
        return System.console().readLine("Informe " + mensagem + ": ");
    }
}
