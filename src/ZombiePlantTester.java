
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZombiePlantTester {

    private ZombiePlant zombiePlant;

    public void setUp() {
        zombiePlant = new ZombiePlant(10,3);
    }

    public void tearDown() {
        zombiePlant = null;
    }

    @Test
    public void TestConstructor() {
        setUp();
        assertEquals(10, zombiePlant.getPotencyRequired(), "Ensure that your constructor is implemented correctly!");
        assertEquals(3, zombiePlant.treatmentsNeeded(), "Ensure that your constructor is implemented correctly!");
        tearDown();
    }

    @Test
    public void TestIsDangerous() {
        setUp();
        assertEquals(true, zombiePlant.isDangerous(), "Ensure that your isDangerous method is implemented correctly!");
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterTreatments() {
        setUp();
        zombiePlant.treat(7);
        zombiePlant.treat(8);
        zombiePlant.treat(9);
        assertEquals(false, zombiePlant.isDangerous(), "Ensure that your treatment and isDangerous methods are implemented correctly!");
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterTreatmentsNotAllSuccessful() {
        setUp();
        zombiePlant.treat(7);
        zombiePlant.treat(8);
        zombiePlant.treat(10);
        assertEquals(false, zombiePlant.isDangerous(), "Ensure that your treatment and isDangerous methods are implemented correctly!");
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterSuccessfulAndUnsuccessfulTreatments() {
        setUp();
        zombiePlant.treat(7);
        zombiePlant.treat(8);
        zombiePlant.treat(11);
        assertEquals(true, zombiePlant.isDangerous(), "Ensure that your treatment and isDangerous methods are implemented correctly!");
        tearDown();
    }

    @Test
    public void TestSuccessfulTreatment() {
        setUp();
        zombiePlant.treat(7);
        assertEquals(2, zombiePlant.treatmentsNeeded(), "Ensure that your treat method is implemented correctly!");
        tearDown();
    }

    @Test
    public void TestUnsuccessfulTreatment() {
        setUp();
        zombiePlant.treat(11);
        assertEquals(4, zombiePlant.treatmentsNeeded(), "Ensure that your treat method is implemented correctly!");
        tearDown();
    }

    @Test
    public void TestTreatmentOfPotencyZeroHasNoEffect() {
        setUp();
        zombiePlant.treat(0);
        assertEquals(3, zombiePlant.treatmentsNeeded(), "Ensure that a treatment of 0 potency is neither successful or unsuccessful!");
        tearDown();
    }

    @Test
    public void TestTreatmentOfPotencyLessThanZeroHasNoEffect() {
        setUp();
        for (int i = -100; i < 0; i++) {
            zombiePlant.treat(i);
        }
        assertEquals(3, zombiePlant.treatmentsNeeded(), "Ensure that a treatment of negative potency is neither successful or unsuccessful.");
        tearDown();
    }

    @Test
    public void TestSuccessfulTreatmentWhenTreatmentRequiredIsZero() {
        setUp();
        zombiePlant.treat(10);
        zombiePlant.treat(9);
        zombiePlant.treat(8);
        zombiePlant.treat(7);
        assertEquals(0, zombiePlant.treatmentsNeeded(), "When the treatments required is equal to 0, any successful treatment should not decrement the treatments required.");
        tearDown();
    }

    @Test
    public void TestUnSuccessfulTreatmentWhenTreatmentRequiredIsZero() {
        setUp();
        zombiePlant.treat(10);
        zombiePlant.treat(9);
        zombiePlant.treat(8);
        zombiePlant.treat(11);
        assertEquals(1, zombiePlant.treatmentsNeeded(), "When the treatments required is equal to 0, any unsuccessful treatment should increment the treatments required to 1.");
        tearDown();
    }

}