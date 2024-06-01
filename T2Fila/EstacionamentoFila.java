import java.time.Duration;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class EstacionamentoFila {
    private Fila fila;
    private int manobrasTotal;

    public EstacionamentoFila(int capacidade) {
        this.fila = new Fila(capacidade);
        this.manobrasTotal = 0;
    }

    public void entrada(String placa) {
        CarroFila carro = new CarroFila(placa);
        if (fila.enfileira(carro)) {
            System.out.println("Carro " + carro.getPlaca() + " entrou às " + carro.getHorarioEntrada());
        } else {
            System.out.println("Estacionamento lotado.");
        }
    }

    public void saida(String placa) {
        LinkedList<CarroFila> tempQueue = new LinkedList<>();
        CarroFila carro = null;
        int manobras = 0;

    
        while (!fila.estaVazia()) {
            CarroFila current = fila.desenfileira();
            if (current.getPlaca().equals(placa)) {
                carro = current;
                break;
            } else {
                tempQueue.add(current);
                manobras++;
            }
        }

        while (!tempQueue.isEmpty()) {
            fila.enfileira(tempQueue.removeFirst());
        }

        if (carro != null) {
            LocalDateTime horarioSaida = LocalDateTime.now();
            Duration permanencia = Duration.between(carro.getHorarioEntrada(), horarioSaida);
            System.out.println("Carro " + carro.getPlaca() + " saiu às " + horarioSaida + ". Tempo de permanência: " + permanencia.toMinutes() + " minutos. Manobras realizadas: " + manobras);
           manobrasTotal += manobras;
        } else {
            System.out.println("Carro " + placa + " não encontrado no estacionamento.");
        }
    }

    public void consulta(String placa) {
        int posicao = 1;
        int i = fila.primeiro;
        boolean encontrado = false;
        while (true) {
            if (fila.dados[i] != null && fila.dados[i].getPlaca().equals(placa)) {
                System.out.println("Carro " + placa + " está na posição " + posicao + " da fila. Entrou às " + fila.dados[i].getHorarioEntrada() + ".");
                encontrado = true;
                break;
            }
            if (i == fila.ultimo) break;
            i = fila.proxima(i);
            posicao++;
        }
        if (!encontrado) {
            System.out.println("Carro não encontrado.");
        }
    }

    public void relatorioOcupacao() {
        System.out.println("Relatório de Ocupação Atual do Estacionamento:");
        System.out.println(fila.toString());
    }

    public int getTotalManobras() {
        return manobrasTotal;
    }
}