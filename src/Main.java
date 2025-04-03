import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Month;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        // Creo un oggetto OffsetDateTime dalla stringa
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        // Aggiungo un anno
        data = data.plusYears(1);

        // Sottraggo un mese
        data = data.minusMonths(1);

        // Aggiungo 7 giorni
        data = data.plusDays(7);

        // Formattiamo il risultato in un formato localizzato per l'Italia
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss", Locale.ITALY);
        String dataFormattata = data.format(formatter);

        // Stampa il risultato localizzato
        System.out.println("Data finale: " + dataFormattata);
    }
}
