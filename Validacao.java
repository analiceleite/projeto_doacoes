import java.io.IOException;

public class Validacao {

    static boolean existente = false;
    // Validar login
    public static int validarLogin(GestaoUsuarios gu) throws InterruptedException, IOException {
        Recursos.limpatela();
        String login = EntradaSaida.solicitarDadosLogin("seu login: ");
        String senha = EntradaSaida.solicitarDadosLogin("sua senha: ");
        Usuario usuarioLogado = gu.buscarLogin(login, senha);
        
        int inputusuario = 0;

        if (usuarioLogado != null && usuarioLogado.getLogin() == "admin" ) {
            inputusuario = EntradaSaida.escolherOpcaoMenuUsuario("admin"); 
        } else if (usuarioLogado != null) {
            inputusuario = EntradaSaida.escolherOpcaoMenuUsuario("user");
        } else {
            System.out.println("\nUsuário inválido!");
            Thread.sleep(2000);
        }
        return inputusuario;
    }
}
