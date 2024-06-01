public class MainPilha {
    public static void main(String[] args) {
        EstacionamentoPilha  estacionamento = new EstacionamentoPilha (5);

        estacionamento.push(new CarroPilha("AIA-4456"));
        estacionamento.push(new CarroPilha("BAC-4141"));
        estacionamento.push(new CarroPilha("CAC-6431"));

        estacionamento.consulta("BAC-4141");

        estacionamento.relatorioOcupacao();

        estacionamento.sair("BAC-4141");
        estacionamento.consulta("BAC-4141");

        estacionamento.relatorioOcupacao();

        System.out.println("Total de manobras realizadas: " + estacionamento.getTotalManobras());
    }
}
