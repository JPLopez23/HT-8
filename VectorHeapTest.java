import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class VectorHeapTest {
    private VectorHeap<Paciente> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
        heap.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        heap.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        heap.add(new Paciente("Ana Gómez", "intoxicación alimentaria", 'C'));
        heap.add(new Paciente("Daniel Torres", "quemaduras graves", 'B'));
    }

    @Test
    public void testAddAndPoll() {
        VectorHeap<Paciente> heap = new VectorHeap<>();
        heap.add(new Paciente("Juan Perez", "fractura de pierna", 'C'));
        heap.add(new Paciente("Maria Ramirez", "apendicitis", 'A'));
        heap.add(new Paciente("Ana Gómez", "intoxicación alimentaria", 'C'));
        heap.add(new Paciente("Daniel Torres", "quemaduras graves", 'B'));

        assertEquals("Maria Ramirez, apendicitis, A", heap.poll().toString());
        assertEquals("Daniel Torres, quemaduras graves, B", heap.poll().toString());
        // Sigue con los asserts para los otros pacientes si es necesario
    }


    @Test
    public void testIsEmpty() {
        assertFalse(heap.isEmpty()); // Verificar que el heap no está vacío después de añadir elementos.
        heap.poll();
        heap.poll();
        heap.poll();
        heap.poll();
        assertTrue(heap.isEmpty()); // Verificar que el heap está vacío después de retirar todos los elementos.
    }
}
