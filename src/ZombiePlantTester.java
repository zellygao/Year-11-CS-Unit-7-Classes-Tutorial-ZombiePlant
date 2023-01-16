import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals("Ensure that your constructor is implemented correctly!", zombiePlant.getPotencyRequired(), 10);
        assertEquals("Ensure that your constructor is implemented correctly!", zombiePlant.treatmentsNeeded(), 3);
        tearDown();
    }

    @Test
    public void TestIsDangerous() {
        setUp();
        assertEquals("Ensure that your isDangerous method is implemented correctly!", zombiePlant.isDangerous(), true);
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterTreatments() {
        setUp();
        zombiePlant.treat(7);
        zombiePlant.treat(8);
        zombiePlant.treat(9);
        assertEquals("Ensure that your treatment and isDangerous methods are implemented correctly!", zombiePlant.isDangerous(), false);
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterTreatmentsNotAllSuccessful() {
        setUp();
        zombiePlant.treat(7);
        zombiePlant.treat(8);
        zombiePlant.treat(10);
        assertEquals("Ensure that your treatment and isDangerous methods are implemented correctly!", zombiePlant.isDangerous(), false);
        tearDown();
    }

    @Test
    public void TestIsDangerousAfterSuccessfulAndUnsuccessfulTreatments() {
        setUp();
        zombiePlant.treat(7);
        zombiePlant.treat(8);
        zombiePlant.treat(11);
        assertEquals("Ensure that your treatment and isDangerous methods are implemented correctly!", zombiePlant.isDangerous(), true);
        tearDown();
    }

    @Test
    public void TestSuccessfulTreatment() {
        setUp();
        zombiePlant.treat(7);
        assertEquals("Ensure that your treat method is implemented correctly!", zombiePlant.treatmentsNeeded(), 2);
        tearDown();
    }

    @Test
    public void TestUnsuccessfulTreatment() {
        setUp();
        zombiePlant.treat(11);
        assertEquals("Ensure that your treat method is implemented correctly!", zombiePlant.treatmentsNeeded(), 4);
        tearDown();
    }

    @Test
    public void TestTreatmentOfPotencyZeroHasNoEffect() {
        setUp();
        zombiePlant.treat(0);
        assertEquals("Ensure that a treatment of 0 potency is neither successful or unsuccessful!", zombiePlant.treatmentsNeeded(), 3);
        tearDown();
    }

    @Test
    public void TestTreatmentOfPotencyLessThanZeroHasNoEffect() {
        setUp();
        for (int i = -100; i < 0; i++) {
            zombiePlant.treat(i);
        }
        assertEquals("Ensure that a treatment of negative potency is neither successful or unsuccessful.", zombiePlant.treatmentsNeeded(), 3);
        tearDown();
    }

    @Test
    public void TestSuccessfulTreatmentWhenTreatmentRequiredIsZero() {
        setUp();
        zombiePlant.treat(10);
        zombiePlant.treat(9);
        zombiePlant.treat(8);
        zombiePlant.treat(7);
        assertEquals("When the treatments required is equal to 0, any successful treatment should not decrement the treatments required.", zombiePlant.treatmentsNeeded(), 0);
        tearDown();
    }

    @Test
    public void TestUnSuccessfulTreatmentWhenTreatmentRequiredIsZero() {
        setUp();
        zombiePlant.treat(10);
        zombiePlant.treat(9);
        zombiePlant.treat(8);
        zombiePlant.treat(11);
        assertEquals("When the treatments required is equal to 0, any unsuccessful treatment should increment the treatments required to 1.", zombiePlant.treatmentsNeeded(), 1);
        tearDown();
    }

}