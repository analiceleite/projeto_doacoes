import java.io.IOException;

public class Recursos {
    public static void limpatela() throws InterruptedException, IOException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
