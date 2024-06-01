import java.time.LocalDateTime;

public class CarroFila {
    private String placa;
    private LocalDateTime horarioEntra;

    public CarroFila(String placa) {
        this.placa = placa;
        this.horarioEntra = LocalDateTime.now();
    }

    public String getPlaca() {
        return placa;
    }

    public LocalDateTime getHorarioEntrada() {
        return horarioEntra;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", horário de entrada=" + horarioEntra +
                '}';
    }
}
