import java.util.ArrayList;
import java.util.Scanner;


public class GestaoVoluntario {

  public ArrayList<Voluntario> listaDeVoluntarios = new ArrayList<Voluntario>();
  Scanner scan = new Scanner(System.in);

  public void adicionarVoluntario(Voluntario Voluntario) {
    int id = 1;
    for (Voluntario v : this.listaDeVoluntarios) {
      if (v.idVoluntario >= id) {
        id = v.idVoluntario + 1;
      }
    }
    Voluntario.idVoluntario = id;
    this.listaDeVoluntarios.add(Voluntario);
  }

  // Mostrar voluntários cadastrados
  public String mostrarVoluntariosCadastrados() {
    String mensagem = "";
    mensagem += "\nAs informações dos voluntários cadastrados são: \n ";
    for (Voluntario v : this.listaDeVoluntarios) {
      
      mensagem +="\n ID do cadastro: "+v.idVoluntario +"\n Nome: " +
          v.nomeVoluntario +
          "\n Idade: " +
          v.idadeVoluntario +
          "\n CPF: " +
          v.cpfVoluntario +
          "\n Endereço: " +
          v.enderecoVoluntario +
          "\n Telefone: " +
          v.telefone+"\n";
    }
    return mensagem;
  }

   // Mostrar cadastro do usuário
  public String mostrarCadastroUsuario() {
    String mensagem = "";
    mensagem += "\nAs informações do seu cadastro são: \n ";
    for (Voluntario v : this.listaDeVoluntarios) {
      
      mensagem +="\n ID do cadastro: "+v.idVoluntario +"\n Nome: " +
          v.nomeVoluntario +
          "\n Idade: " +
          v.idadeVoluntario +
          "\n CPF: " +
          v.cpfVoluntario +
          "\n Endereço: " +
          v.enderecoVoluntario +
          "\n Telefone: " +
          v.telefone+"\n";
    }
    return mensagem;
  }


  // Editar nome voluntário
  public String alterarNomeVoluntario(int id) {
    boolean encontrado = false;

    for (Voluntario v : this.listaDeVoluntarios) {
      encontrado = true;
      if (v.idVoluntario == id) {
        System.out.println("Informe o novo nome do voluntário: ");
        v.nomeVoluntario = scan.next();
      }
    }
    if (encontrado == true) {
      return ("Nome alterado com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }

  }

  // Editar idade voluntário
  public String alterarIdadeVoluntario(int id) {
    boolean encontrado = false;

    for (Voluntario v : this.listaDeVoluntarios) {
      encontrado = true;
      if (v.idVoluntario == id) {
        System.out.println("Informe a nova idade do voluntário: ");
        v.idadeVoluntario = scan.nextInt();
      }
    }
    if (encontrado == true) {
      return ("Idade alterada com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }

  }

  // Editar endereço voluntário
  public String alterarEnderecoVoluntario(int id) {
    boolean encontrado = false;

    for (Voluntario v : this.listaDeVoluntarios) {
      encontrado = true;
      if (v.idVoluntario == id) {
        System.out.println("Informe o endereço atualizado: ");
        v.enderecoVoluntario = scan.next();
      }
    }
    if (encontrado == true) {
      return ("Endereço alterado com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }

  }

  // Editar telefone voluntário
  public String alterarTelefoneVoluntario(int id) {
    boolean encontrado = false;

    for (Voluntario v : this.listaDeVoluntarios) {
      encontrado = true;
      if (v.idVoluntario == id) {
        System.out.println("Informe o contato atualizado: ");
        v.telefone = scan.next();
      }
    }
    if (encontrado == true) {
      return ("Contato alterado com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }

  }

  public String deletarCadastro(int id) {
  
    this.listaDeVoluntarios.remove(id);
    return "Cadastro removido com sucesso!";
  }

}
