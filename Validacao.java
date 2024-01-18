import java.io.IOException;

public class Validacao {

    // Validar login
    public static Usuario validarLogin(GestaoUsuarios gu) throws InterruptedException, IOException {
        String login = EntradaSaida.solicitarDadosLogin("seu login: ");
        String senha = EntradaSaida.solicitarDadosLogin("sua senha: ");
        Usuario usuarioLogado = gu.buscarLogin(login, senha, null);
        if (usuarioLogado != null) {
            return usuarioLogado;
        }
        System.out.println("");
        return null;
    }

}
