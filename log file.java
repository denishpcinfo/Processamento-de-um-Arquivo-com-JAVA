import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class PDVLogger {
    private static final Path LOG_PATH = Path.of("logs/pdv.log");

    public static void registrarEvento(String mensagem) {
        String logEntry = LocalDateTime.now() + " - " + mensagem + "\n";
        try {
            Files.writeString(LOG_PATH, logEntry, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Log registrado!");
        } catch (IOException e) {
            System.err.println("Erro ao gravar log: " + e.getMessage());
        }
    }

    public static void mostrarLogs() {
        try {
            String logs = Files.readString(LOG_PATH);
            System.out.println("🔹 Logs do PDV:\n" + logs);
        } catch (IOException e) {
            System.err.println("Erro ao ler logs: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        registrarEvento("Venda realizada: R$50,00");
        registrarEvento("Pagamento aprovado via cartão de crédito.");
        registrarEvento("Cupom fiscal impresso.");
        mostrarLogs();
    }
}
