import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import java.time.OffsetDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import org.junit.jupiter.api.Test;

public class MainTest {

    // Funzione per analizzare la data
    private OffsetDateTime analizzaData(String dataString) {
        return OffsetDateTime.parse(dataString);
    }

    @Test
    public void testAggiungiAnno() {
        OffsetDateTime data = analizzaData("2023-03-01T13:00:00Z");
        data = data.plusYears(1);  // Aggiungi un anno
        assertEquals(2024, data.getYear(), "L'anno dovrebbe essere 2024 dopo aver aggiunto un anno");
    }

    @Test
    public void testSottraiMese() {
        OffsetDateTime data = analizzaData("2023-03-01T13:00:00Z");
        data = data.minusMonths(1);  // Sottrai un mese
        assertEquals(Month.FEBRUARY, data.getMonth(), "Il mese dovrebbe essere febbraio dopo aver sottratto un mese");
        assertEquals(1, data.getDayOfMonth(), "Il giorno del mese dovrebbe rimanere 1");
    }

    @Test
    public void testAggiungiGiorni() {
        OffsetDateTime data = analizzaData("2023-03-01T13:00:00Z");
        data = data.plusDays(7);  // Aggiungi 7 giorni
        assertEquals(8, data.getDayOfMonth(), "Il giorno del mese dovrebbe essere 8 dopo aver aggiunto 7 giorni");
    }

    @Test
    public void testFormatoData() {
        OffsetDateTime data = analizzaData("2023-03-01T13:00:00Z");
        // Aggiungi un anno, sottrai un mese, aggiungi 7 giorni
        data = data.plusYears(1).minusMonths(1).plusDays(7);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss", Locale.ITALY);
        String dataFormattata = data.format(formatter);

        // Verifica il formato corretto
        assertEquals("08 marzo 2024, 13:00:00", dataFormattata, "Il formato della data formattata dovrebbe essere corretto");
    }

    @Test
    public void testDataInvalidFormat() {
        assertThrows(DateTimeParseException.class, () -> {
            // Prova a creare una data con formato errato
            analizzaData("invalid-date");
        }, "Dovrebbe sollevare un'eccezione di formato errato");
    }
}
