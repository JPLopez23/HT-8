import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SistemaEmergencias {

    public static void main(String[] args) {
        VectorHeap<Paciente> colaEmergencias = new VectorHeap<>();

        // Cargar pacientes desde archivo
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datosPaciente = line.split(",");
                if (datosPaciente.length == 3) {
                    Paciente paciente = new Paciente(datosPaciente[0], datosPaciente[1], datosPaciente[2].charAt(0));
                    colaEmergencias.add(paciente);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de pacientes: " + e.getMessage());
            return;
        }

        // Procesar y mostrar pacientes en orden de prioridad
        System.out.println("Pacientes a ser atendidos en orden de prioridad:");
        while (!colaEmergencias.isEmpty()) {
            Paciente paciente = colaEmergencias.poll();
            System.out.println(paciente);
        }
    }
}
