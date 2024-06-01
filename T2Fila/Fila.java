public class Fila {
    private int primeiro;
    private int ultimo;
    private CarroFila[] dados;
    private int tamanho;

    public static final int CAPACIDADE_MINIMA = 10;

    public Fila(int capacidade) {
        dados = new CarroFila[capacidade];
        ultimo = -1;
        primeiro = 0;
        tamanho = 0;
    }

    public Fila() {
        this(CAPACIDADE_MINIMA);
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public boolean estaCheia() {
        return tamanho == dados.length;
    }

    int proxima(int pos) {
        return (pos + 1) % dados.length;
    }

    public boolean enfileira(CarroFila carro) {
        if (estaCheia()) return false;
        ultimo = proxima(ultimo);
        dados[ultimo] = carro;
        tamanho++;
        return true;
    }

    public CarroFila desenfileira() {
        if (estaVazia()) return null;
        CarroFila temp = dados[primeiro];
        dados[primeiro] = null; 
        primeiro = proxima(primeiro);
        tamanho--;
        return temp;
    }

    public int getPrimeiro() {
        return primeiro;
    }

    public int getUltimo() {
        return ultimo;
    }

    public CarroFila[] getDados() {
        return dados;
    }

    @Override
    public String toString() {
        if (estaVazia()) return "fila vazia";
        StringBuilder s = new StringBuilder();
        int i = primeiro;
        int count = 0;
        while (count < tamanho) {
            s.append(dados[i].getPlaca()).append(" entrou às ").append(dados[i].getHorarioEntrada()).append("\n");
            i = proxima(i);
            count++;
        }
        return s.toString();
    }

    public String vetorToString() {
        if (estaVazia())
            return "_ _ _ _ _ _ _ _ _ _";
        StringBuilder s = new StringBuilder();
        int i;
        if (primeiro <= ultimo) {
            for (i = 0; i < primeiro; i++)
                s.append("_ ");
            for (i = primeiro; i <= ultimo; i++)
                s.append(dados[i]).append(" ");
            for (i = ultimo + 1; i < dados.length; i++)
                s.append("_ ");
        } else {
            for (i = 0; i <= ultimo; i++)
                s.append(dados[i]).append(" ");
            for (i = ultimo + 1; i < primeiro; i++)
                s.append("_ ");
            for (i = primeiro; i < dados.length; i++)
                s.append(dados[i]).append(" ");
        }
        return s.toString();
    }
}
