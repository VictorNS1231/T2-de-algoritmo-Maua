import java.time.LocalDateTime;

public class CarroPilha {
    private String placa;
    private LocalDateTime horarioEntra;

    public CarroPilha(String placa) {
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
                "Placa='" + placa + '\'' +
                ", Horário de entrada=" + horarioEntra +
                '}';
    }
}
