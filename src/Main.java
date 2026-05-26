import entidades.Paciente;
import heap.FilaComPrioridadeHeap;

public class Main {
    public static void main(String[] args) {
        FilaComPrioridadeHeap<Paciente> fila = new FilaComPrioridadeHeap<>(10);

        Paciente[] pacientes = {
                new Paciente("Carlos", 2, 45, false),
                new Paciente("Maria", 5, 5, false),
                new Paciente("João", 3, 20, false),
                new Paciente("Beatriz", 3, 35, true),
                new Paciente("Pedro", 5, 2, false),
                new Paciente("Helena", 2, 45, true)
        };

        System.out.println("=== Chegada dos pacientes ===");
        for (Paciente paciente : pacientes) {
            fila.enfileirar(paciente);
            System.out.println("Paciente inserido: " + paciente);
            System.out.println("Estado interno do heap: " + fila);
            System.out.println();
        }

        System.out.println("=== Ordem de atendimento ===");
        int ordem = 1;
        while (!fila.estaVazia()) {
            System.out.println(ordem + ". " + fila.desenfileirar());
            ordem++;
        }
    }
}
