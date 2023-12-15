import java.util.Scanner;

public class Validacao {
    static Scanner scan = new Scanner(System.in);
    // Validar usuário
    public static boolean validarIdadeVoluntario(int idadeVoluntario) {
        boolean voluntarioValido = false;
        if (idadeVoluntario >= 18) {
            voluntarioValido = true;

            if (idadeVoluntario < 18) {

            }
            return voluntarioValido;
        }
        return voluntarioValido;
    }

    // Validar se é dinheiro a doação
    public static boolean validarSeForDinheiro(Doacao d) {
        boolean doarDinheiro = false;
        if (d.categoria == "Dinheiro") {
            doarDinheiro = true;

            if (d.categoria != "Dinheiro") {

            }
            return doarDinheiro;
        }
        return doarDinheiro;
    }
    
    // Validar cadastro usuário

    // Validar quantidade doação

    // Validar id doação


}
