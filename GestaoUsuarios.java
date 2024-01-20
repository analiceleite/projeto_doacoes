import java.util.ArrayList;
import java.util.Scanner;

public class GestaoUsuarios {
  Scanner scan = new Scanner(System.in);
  public static ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

  public void adicionarUsuario(Usuario Usuario, String Senha) {
      int id = 1;
      boolean confirmarSenha = true;
      for (Usuario u : listaDeUsuarios) {
          if (u.idUsuario >= id) {
              id = u.idUsuario + 1;
          }
      }
      Usuario.idUsuario = id;
      do {
        if (!Usuario.getSenha().equals(Senha)) {
          confirmarSenha = false;
          System.out.println("\nAs senhas não coincidem, tente novamente!\n");
          Usuario.setSenha(System.console().readLine("Informe a senha da sua conta: "));
          Senha = System.console().readLine("Informe a senha da sua conta: ");
        } 
        else {
          listaDeUsuarios.add(Usuario);
          System.out.println("\nUsuário cadastrado com sucesso!");
          break;
          //EntradaSaida.menuPrincipal();
        }
      } while (!confirmarSenha);
      
  }

  public static void cadastrarUsuarioAdmin () {
    Usuario u = new Usuario();
    u.idUsuario = 1;
    u.setNome("Administrator"); 
    u.setLogin("admin");
    u.setSenha("admin");
    listaDeUsuarios.add(u);
  } 

   public Usuario buscarLogin(String login, String senha) {
        for (Usuario u : listaDeUsuarios) {
          if ((u.getLogin().equals(login)) && (u.getSenha().equals(senha))) {
           return u;
          }
        }
        return null;
    } 
    
    // Mostrar usuários cadastrados
    public String mostrarUsuariosCadastrados() {
        String mensagem = "";
        mensagem += "\nAs informações dos usuários cadastrados são: \n ";
        for (Usuario u : listaDeUsuarios) {
            mensagem += "\n ID do cadastro: " + u.idUsuario + "\n Login: " +
                    u.getLogin() +
                    "\n Senha: " + u.getSenha() + "\n";
        }
        return mensagem;
    }

  // Editar senha usuario
  public String alterarSenhaUsuario(int id) {
    boolean encontrado = false;

    for (Usuario u : listaDeUsuarios) {
      encontrado = true;
  
      if (u.idUsuario == id) {
        System.out.println("Informe o nova senha: ");
        // u.setSenha() = scan.next();
      }
    }
    if (encontrado == true) {
      return ("Senha alterada com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }

  }


}