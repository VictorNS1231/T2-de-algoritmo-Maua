public class MainFila {
    public static void main(String[] args) {
        EstacionamentoFila estacionamento = new EstacionamentoFila(5);

        estacionamento.entrada("AIA-4456");
        estacionamento.entrada("BAC-4141");
        estacionamento.entrada("CAC-6431");

        estacionamento.consulta("BAC-4141");

        estacionamento.relatorioOcupacao();

        estacionamento.saida("BAC-4141");
        estacionamento.consulta("AIA-4456");

        estacionamento.relatorioOcupacao();

        estacionamento.saida("AIA-4456");
        estacionamento.saida("CAC-6431");
    }
}
