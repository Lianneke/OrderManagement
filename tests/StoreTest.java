import org.junit.Test;

import static org.junit.Assert.*;

public class StoreTest {
    Medicine medicine = new Medicine("A15", "paracetamol", 1.90);

    @Test
    public void addNewMedicine() {
        assertEquals("A15", medicine.getNumber());
    }

    @Test
    public void printListOfMedicines() {
    }

    @Test
    public void removeMedicine() {
    }

    @Test
    public void queryMedicine() {
    }

    @Test
    public void testQueryMedicine() {
    }


}