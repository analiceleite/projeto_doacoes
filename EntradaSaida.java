import java.io.IOException;

public class EntradaSaida {

    GestaoEstoque ge = new GestaoEstoque();
    static boolean existente = false;


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
    public static int escolherOpcaoMenuUsuario(String tipoUsuario) throws InterruptedException, IOException {
        do {
        Recursos.limpatela();
        System.out.println(
                "\n[1]- Cadastrar doação \n" +
                "[2]- Visualizar minhas doações cadastradas \n" +
                "[3]- Alterar descrição de alguma doação \n" +
                "[4]- Excluir cadastro \n");
        if (tipoUsuario == "admin") {
                System.out.println(
                "[5]- Dar entrada em doações para o estoque \n" +
                "[6]- Consultar doações em estoque por ID \n" +
                "[7]- Consultar doações por categoria \n" +
                "[8]- Voltar ao menu principal\n"); 
        } 
        System.out.println("[0]- Sair do programa \n");
        int so = selecionaOpcao();
        if (tipoUsuario == "user" && so > 4 || so > 8) {
            System.out.println("\nOpção inválida! Tente novamente.");
            Thread.sleep(2000);
            EntradaSaida.escolherOpcaoMenuUsuario(tipoUsuario);
        }
        switch (so) {
            case 1: // Escolher categria
                do{
                    switch (escolherOpcaoMenuCategorias()) {
                        case 1:
                            cadastrarDoacaoVestuario();
                        break;
                        case 2:
                            cadastrarDoacaoAlimento();
                        break;
                        case 3:
                            cadastrarDoacaoMoveis();
                        break;
                        case 4:
                            cadastrarDoacaoDinheiro();
                        break;
                        case 5:
                            limpatela();
                            escolherOpcaoMenuUsuario(tipoUsuario);
                        break;
                    }
                } while (!existente);
            break;
            case 2: // Visualizar doações cadastradas
                GestaoEstoque.mostrarDoacoesCadastradas();
            break;
            case 3:
            break;
            case 4:
            break;
            case 5:
            break;
            case 6:
            break;
            case 7:
            break;
            case 8:
                menuPrincipal();
            break;
        }
    } while ( !existente);

    return selecionaOpcao();
} 
    public static int escolherOpcaoMenuCategorias() throws InterruptedException, IOException { // Verificar

        System.out.print("Escolha uma opção: \n\n" +
                "[1]- Vestuário\n" +
                "[2]- Alimento \n" +
                "[3]- Móveis \n" +
                "[4]- Dinheiro \n" +
                "[5]- Voltar ao menu principal \n\n" +
                "[0]- Sair \n\n");

        return selecionaOpcao();
    }

    public static int cadastrarDoacaoVestuario() throws InterruptedException, IOException {
         Doacao d = new Doacao();
         d.descricao = (System.console().readLine("\nInsira a descrição da doação: "));
         d.quantidade = Integer.parseInt(System.console().readLine("Insira a quantidade: "));
         d.categoria = "Vestuário";
         GestaoEstoque.cadastrarDoacao(d);
         System.out.println("\nDoação cadastrada com sucesso!\n");
         Thread.sleep(2000);
         Recursos.limpatela();
        return 0;
    }

    public static int cadastrarDoacaoAlimento() throws InterruptedException, IOException {
        Doacao d = new Doacao();
        d.descricao = (System.console().readLine("\nInsira a descrição da doação: "));
        d.quantidade = Integer.parseInt(System.console().readLine("Insira a quantidade: "));
        d.categoria = "Alimento";
        GestaoEstoque.cadastrarDoacao(d);
        System.out.println("\nDoação cadastrada com sucesso!\n");
        Thread.sleep(2000);
        Recursos.limpatela();
       return 0;
   }

   public static int cadastrarDoacaoMoveis() throws InterruptedException, IOException {
         Doacao d = new Doacao();
         d.descricao = (System.console().readLine("\nInsira a descrição da doação: "));
         d.quantidade = Integer.parseInt(System.console().readLine("Insira a quantidade: "));
         d.categoria = "Móveis";
         GestaoEstoque.cadastrarDoacao(d);
         System.out.println("\nDoação cadastrada com sucesso!\n");
         Thread.sleep(2000);
         Recursos.limpatela();
        return 0;
    }

    public static int cadastrarDoacaoDinheiro() throws InterruptedException, IOException {
        Doacao d = new Doacao();
        d.descricao = (System.console().readLine("\nInsira a descrição da doação (este campo é opcional): "));
            if (d.descricao == null) {
                d.descricao = " Campo não preenchido. ";
            }
        d.quantidade = Integer.parseInt(System.console().readLine("Insira o valor: "));
        d.categoria = "Dinheiro";
        GestaoEstoque.cadastrarDoacao(d);
        System.out.println("\nDoação cadastrada com sucesso!\n");
        Thread.sleep(2000);
        Recursos.limpatela();
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
