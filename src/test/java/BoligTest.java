import org.example.Bolig;
import org.example.Bud;
import org.example.Budgiver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoligTest {

    @DisplayName("Legger til nye budgivere og bud")
    @Test
    public void burdeLeggeTilBud() {
        Bolig bolig = new Bolig("Tollbugata 1", "1111", 2500000);
        Budgiver budgiver = new Budgiver("TestGiver", "12345678");
        Budgiver budgiver1 = new Budgiver("TestGiver1", "87654321");
        budgiver.giBud(bolig, 2600000, 2, 0);
        budgiver1.giBud(bolig, 5500000, 1, 0);
        assertFalse(bolig.hentAktiveBud().isEmpty());
    }

    @DisplayName("Henter hoyeste bud")
    @Test
    public void burdeHenteHoyesteBud() {
        Bolig bolig = new Bolig("Tollbugata 1", "1111", 2500000);

        Budgiver budgiver1 = new Budgiver("Ole", "12345678");
        budgiver1.giBud(bolig, 2600000, 2, 0);

        Budgiver budgiver2 = new Budgiver("Kari", "87654321");
        budgiver2.giBud(bolig, 2700000, 2, 0);

        Bud hoyesteBud = bolig.hentHoyesteAktivtBud();
        assertEquals(2700000, hoyesteBud.getPris(), 0);
    }

    @DisplayName("Kaster en IllegalArgumentException ved ugyldig input")
    @Test
    public void burdeBenekteUgyldigBud() {
        Bolig bolig = new Bolig("Tollbugata 1", "1111", 2500000);
        Budgiver budgiver = new Budgiver("Ole", "12345678");
        
        Bud ugyldigBud = new Bud(bolig, budgiver, 2600000, 1, 0);
        assertThrows(IllegalArgumentException.class, () -> new Bud(bolig, budgiver, 2600000, -3, 0));

        /**
        Bud ugyldigBud = new Bud(bolig, budgiver, -2600000, 1, 0);
        assertThrows(IllegalArgumentException.class, () -> new Bud(bolig, budgiver, -2600000, 3, 0));
         **/

        bolig.aksepterBud(ugyldigBud);
    }

    @DisplayName("Kaster IllegalArgumentException ved negative timer, minutter og bud")
    @Test
    public void burdeKasteExceptionVedNegativeTall() {
        Bolig bolig = new Bolig("Tollbugata 1", "1111", 2500000);
        Budgiver budgiver = new Budgiver("Ola", "12345678");

        /** Tester med negative timer **/
        assertThrows(IllegalArgumentException.class, () -> new Bud(bolig, budgiver, 2000000, -1, 30), "Feilmelding: Negative timer er ikke tillatt");
        /** Tester med både negative timer og minutter **/
        assertThrows(IllegalArgumentException.class, () -> new Bud(bolig, budgiver, 2000000, -1, -30), "Feilmelding: Negative timer og minutter er ikke tillatt");
        /** Tester ved negativt input av belop **/
        assertThrows(IllegalArgumentException.class, () -> new Bud(bolig, budgiver, -200000, 1, 30), "Feilmelding: Negativt belop er ikke tillatt" );
    }
}







