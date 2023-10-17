import org.example.Bolig;
import org.example.Bud;
import org.example.Budgiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BudgiverTest {

    @DisplayName("Verifiserer at budgiver kan gi bud paa en bolig")
    @Test
    public void sjekkOmBudgiverKanGiBudPaaBolig() {
        Bolig bolig = new Bolig("Tollbugata 1", "1111", 2100000);
        Budgiver budgiver = new Budgiver("Ole", "12345678");
        budgiver.giBud(bolig, 2200000, 2, 0);
        Bud bud = bolig.hentHoyesteAktivtBud();

        assertNotNull(bud);
        assertEquals(budgiver, bud.getBudGiver());
    }

    @DisplayName("Sjekker endring av telefonnummer")
    @Test
    public void sjekkerOmBudgiverKanEndreTlfNummer() {
        Budgiver budgiver = new Budgiver("Ole", "12345678");
        budgiver.setTelefonNummer("87654321");
        assertEquals("87654321", budgiver.getTelefonNummer());
    }
}
