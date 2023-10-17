import org.example.Bolig;
import org.example.Bud;
import org.example.Budgiver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BudTest {

    @DisplayName("Sjekker om akseptfrist er gyldig i fremtiden")
    @Test
    public void sjekkerOmGyldigAkseptfrist() {
        Bolig bolig = new Bolig("Tollbugata 1", "1111", 2500000);
        Budgiver budgiver = new Budgiver("Ole", "12345678");
        Bud bud = new Bud(bolig, budgiver, 2600000, 1, 30);

        assertTrue(bud.getAkseptFrist().isAfter(LocalDateTime.now()));
    }

    @DisplayName("Validerer om budet er gitt med korrekt pris")
    @Test
    public void sjekkOmKorrektPris() {
        Bolig bolig = new Bolig("Tollbugata 1", "0010", 2500000);
        Budgiver budgiver = new Budgiver("Ole", "12345678");
        Bud bud = new Bud(bolig, budgiver, 2600000, 1, 30);
        assertEquals(2600000, bud.getPris(), 0);
    }


    /**
    @Test
    public void testEndrePris() {
        Bolig bolig = new Bolig("Storgata 1", "0010", 2500000);
        Budgiver budgiver = new Budgiver("TestGiver", "12345678");
        Bud bud = new Bud(bolig, budgiver, 2600000, 1, 30);
        bud.setPris(2700000);
        assertEquals(2700000, bud.getPris(), 0);
    }
     **/

    /**
    @Test
    public void testEndreBudGiver() {
        Bolig bolig = new Bolig("Storgata 1", "0010", 2500000);
        Budgiver budgiver1 = new Budgiver("TestGiver1", "12345678");
        Bud bud = new Bud(bolig, budgiver1, 2600000, 1, 30);

        Budgiver budgiver2 = new Budgiver("TestGiver2", "87654321");
        bud.setBudGiver(budgiver2);
        assertEquals(budgiver2, bud.getBudGiver());
    }
    **/
}

