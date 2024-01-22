import java.io.IOException;

public class Validacao {

    static boolean existente = false;
    // Validar login
    public static int validarLogin(GestaoUsuarios gu) throws InterruptedException, IOException {
        EntradaSaida.limpatela();
        String login = EntradaSaida.solicitarDadosCadastro("seu login: ");
        String senha = EntradaSaida.solicitarDadosCadastro("sua senha: ");
        Usuario usuarioLogado = gu.buscarLogin(login, senha);
        
        int inputusuario = 0;

        if (usuarioLogado != null && usuarioLogado.getLogin() == "user" ) {
            inputusuario = EntradaSaida.escolherOpcaoMenuUsuario("user"); 
        } else if (usuarioLogado != null) {
            inputusuario = EntradaSaida.escolherOpcaoMenuUsuario("user");
        } else {
            System.out.println(Cor.RED + "\nUsuário inválido!");
            Thread.sleep(2000);
        }
        return inputusuario;
    }

    public static boolean validarLoginAdm(GestaoUsuarios gu) throws InterruptedException, IOException {
        boolean admValido = false;

        EntradaSaida.limpatela();
        String login = EntradaSaida.solicitarDadosCadastro("seu login: ");
        String senha = EntradaSaida.solicitarDadosCadastro("sua senha: ");
        Usuario usuarioLogado = gu.buscarLogin(login, senha);

        if (usuarioLogado != null && usuarioLogado.getLogin() == "admin" ) {
            admValido = true;
        } else {
            System.out.println(Cor.RED +"\nUsuário inválido!");
            Thread.sleep(2000);
        }
        return admValido;
    }

    
}
