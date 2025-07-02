public class Moto extends Veiculo {
    private int cilindradas;
    private boolean partidaEletrica;
    private String categoria;

    public Moto(String marca, String modelo, int ano, String cor, double preco, int cilindradas,
            boolean partidaEletrica, String categoria) {
        super(marca, modelo, ano, cor, preco);
        this.categoria = categoria;
        this.partidaEletrica = partidaEletrica;
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public boolean ispartidaEletrica() {
        return partidaEletrica;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Categorias: " + categoria);
        System.out.println("Cilindradas: " + cilindradas);
        System.out.println("Partida eletrica: " + (partidaEletrica ? "Sim" : "Não"));
    }

    public void empinar() {
        System.out.println("Moto" + getModelo()+ "empinando");
    }
}
