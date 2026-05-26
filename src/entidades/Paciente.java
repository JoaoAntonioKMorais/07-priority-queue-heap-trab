package entidades;

/**
 * Representa um paciente da triagem do Pronto-Socorro.
 *
 * A prioridade é definida em cascata:
 * 1. maior nível de urgência;
 * 2. maior tempo de espera;
 * 3. paciente vulnerável antes de paciente não vulnerável.
 */
public class Paciente implements Comparable<Paciente> {
    private String nome;
    private int nivelUrgencia;
    private int tempoEsperaMinutos;
    private boolean grupoVulneravel;

    /**
     * Cria um paciente com os dados usados na fila de prioridade.
     *
     * @param nome nome do paciente
     * @param nivelUrgencia nível de urgência de 1 a 5
     * @param tempoEsperaMinutos tempo de espera em minutos
     * @param grupoVulneravel true se pertence ao grupo vulnerável
     */
    public Paciente(String nome, int nivelUrgencia, int tempoEsperaMinutos, boolean grupoVulneravel) {
        if (nivelUrgencia < 1 || nivelUrgencia > 5) {
            throw new IllegalArgumentException("O nível de urgência deve estar entre 1 e 5.");
        }

        if (tempoEsperaMinutos < 0) {
            throw new IllegalArgumentException("O tempo de espera não pode ser negativo.");
        }

        this.nome = nome;
        this.nivelUrgencia = nivelUrgencia;
        this.tempoEsperaMinutos = tempoEsperaMinutos;
        this.grupoVulneravel = grupoVulneravel;
    }

    public String getNome() {
        return nome;
    }

    public int getNivelUrgencia() {
        return nivelUrgencia;
    }

    public int getTempoEsperaMinutos() {
        return tempoEsperaMinutos;
    }

    public boolean isGrupoVulneravel() {
        return grupoVulneravel;
    }

    /**
     * Compara dois pacientes pela prioridade clínica.
     *
     * Retorna valor positivo quando este paciente tem prioridade maior.
     */
    @Override
    public int compareTo(Paciente outro) {
        int comparacaoUrgencia = Integer.compare(this.nivelUrgencia, outro.nivelUrgencia);
        if (comparacaoUrgencia != 0) {
            return comparacaoUrgencia;
        }

        int comparacaoEspera = Integer.compare(this.tempoEsperaMinutos, outro.tempoEsperaMinutos);
        if (comparacaoEspera != 0) {
            return comparacaoEspera;
        }

        return Boolean.compare(this.grupoVulneravel, outro.grupoVulneravel);
    }

    /**
     * Retorna a cor associada ao nível de urgência.
     */
    public String getCorUrgencia() {
        switch (nivelUrgencia) {
            case 5:
                return "Vermelho";
            case 4:
                return "Laranja";
            case 3:
                return "Amarelo";
            case 2:
                return "Verde";
            case 1:
                return "Azul";
            default:
                return "Desconhecido";
        }
    }

    @Override
    public String toString() {
        return nome + " [" + getCorUrgencia()
                + ", urgência=" + nivelUrgencia
                + ", espera=" + tempoEsperaMinutos + "min"
                + ", vulnerável=" + (grupoVulneravel ? "sim" : "não")
                + "]";
    }
}
