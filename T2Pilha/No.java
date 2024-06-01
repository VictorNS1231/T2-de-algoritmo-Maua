public class No {
    private CarroPilha info;
    private No proximo;

    public No(CarroPilha info) {
        this.info = info;
    }

    public CarroPilha getInfo() {
        return info;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
