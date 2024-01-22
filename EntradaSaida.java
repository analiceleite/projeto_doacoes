import java.io.IOException;
import java.util.Scanner;

public class EntradaSaida {
    private static Scanner scanner = new Scanner(System.in);
    static GestaoEstoque ge = new GestaoEstoque();
    static GestaoUsuarios gu = new GestaoUsuarios();
    static boolean existente = false;
    static int id = 0;

    public static void limpatela() throws InterruptedException, IOException {// Limpar tela
        try {
            // Aguarda por 2 segundos
            Thread.sleep(1400);
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
                "[1]- Controle de doações\n" +
                "[2]- Administração\n" +
                "[0]- Sair do programa \n");
        return selecionaOpcao();
    }
    
    public static int escolherOpcaoMenuAdm() throws InterruptedException, IOException {
        limpatela();
        System.out.println(
            "\n[1]- Cadastrar usuário \n" +
            "[2]- Exibir usuários cadastrados \n" +
            "[3]- Alterar senha usuário \n" +
            "[4]- Deletar usuário \n");

    System.out.println("[0]- Sair \n");
    int so = selecionaOpcao();
    String senhaUsuario;
    
    switch (so) {
        case 1: // Cadastrar usuário
            limpatela();
            Usuario u = new Usuario();
            u.setNome(solicitarDadosCadastro("nome"));
            u.setLogin(solicitarDadosCadastro("login"));
            u.setSenha(solicitarDadosCadastro("senha"));
            senhaUsuario =
            solicitarDadosCadastro("confirmação de senha");
            gu.adicionarUsuario(u, senhaUsuario);
            escolherOpcaoMenuAdm();
        break;
        case 2: // Exibir usuários cadastrados
            limpatela();
            GestaoUsuarios.mostrarUsuariosCadastrados();
            escolherOpcaoMenuAdm();
        break;

        case 3: // Alterar senha usuário
            limpatela();
            id = solicitarId();  
            gu.alterarSenhaUsuario(id); 
            escolherOpcaoMenuAdm();    
            break;
        case 4: // Excluir cadastro
            limpatela();
            id = solicitarId();  
            GestaoUsuarios.deletarCadastroUsuario(id);
            escolherOpcaoMenuAdm();
        break;
    }
        
    return 0;

    }

    public static int escolherOpcaoMenuUsuario(String tipoUsuario) throws InterruptedException, IOException {
        do {
        limpatela();
        System.out.println(
                "\n[1]- Cadastrar doação \n" +
                "[2]- Visualizar doações cadastradas \n" +
                "[3]- Alterar descrição \n" +
                "[4]- Excluir cadastro \n" +
                "[5]- Dar entrada no estoque \n" +
                "[6]- Dar baixa no estoque \n" +
                "[7]- Consultar doações em estoque por ID \n" +
                "[8]- Consultar doações por categoria \n");
        
        System.out.println("[0]- Voltar \n");
        int so = selecionaOpcao();
        if (tipoUsuario == "user" && so > 8) {
            System.out.println("\nOpção inválida! Tente novamente.");
            Thread.sleep(2000);
            escolherOpcaoMenuUsuario(tipoUsuario);
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
                        case 0:
                            limpatela();
                            escolherOpcaoMenuUsuario(tipoUsuario);
                        break;
                    }
                } while (so != 0);
            break;
            case 2: // Visualizar doações cadastradas
                GestaoEstoque.mostrarDoacoesCadastradas();
            break;
            case 3: // Alterar descrição doação
                limpatela();
                id = solicitarId();  
                GestaoEstoque.alterarDescricaoDoacao(id);
            break;
            case 4: // Deletar doação
                limpatela();
                id = solicitarId();
                GestaoEstoque.deletarDoacao(id);
            break;
            case 5: // Dar entrada em doações para o estoque
                limpatela();
                GestaoEstoque.mostrarDoacoesCadastradas();
                id = solicitarId();
                int qtdAtual = 0;
                System.out.println("Quantidade do produto que deseja dar baixa: ");
                qtdAtual = scanner.nextInt();
                GestaoEstoque.addQtdAtualProduto(id, qtdAtual);
            break;
            case 6: // Dar baixa em doações para o estoque
                limpatela();
                GestaoEstoque.mostrarDoacoesCadastradas();
                id = solicitarId();
                int qtdSaida = 0;
                System.out.println("Quantidade do produto que deseja dar baixa: ");
                qtdSaida = scanner.nextInt();
                GestaoEstoque.removeQtdAtualProduto(id, qtdSaida);
            break;
            case 7: // Consultar doações em estoque por ID
                limpatela();
                id = solicitarId();
                GestaoEstoque.mostrarDoacoesCadastradasPorId(id);
            break;
            case 8: // Consultar doações em estoque por categoria
                limpatela();
                int opCategoria = 0;
                System.out.print("Insira a categoria que deseja exibir: ");
                opCategoria = escolherOpcaoMenuCategorias();
                GestaoEstoque.mostrarDoacoesCadastradasPorCategoria(opCategoria);
            break;
            case 0: // Voltar ao menu principal
                limpatela();
                menuPrincipal();
            break;
        }
    } while ( !existente);

    return selecionaOpcao();
} 

    public static int escolherOpcaoMenuCategorias() throws InterruptedException, IOException { // Verificar

        System.out.print("\nEscolha uma opção: \n\n" +
                "[1]- Vestuário\n" +
                "[2]- Alimento \n" +
                "[3]- Móveis \n" +
                "[4]- Dinheiro \n\n" +
                "[0]- Voltar \n\n");
    
               

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
         limpatela();
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
        limpatela();
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
         limpatela();
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
        limpatela();
    return 0;
    }
    
    // Preencher infos 
    public static int solicitarId() {
        System.out.print("Informe o ID do cadastro --> ");
        int id = scanner.nextInt();
        return id;
    }

    public static String solicitarDadosCadastro(String mensagem) {
        return System.console().readLine("Informe " + mensagem + ": ");
    }
}
