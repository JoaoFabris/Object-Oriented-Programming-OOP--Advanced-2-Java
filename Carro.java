public class Carro extends Veiculo {
    private int nPortas;
    private String tipoCombustivel;
    private double capacidadePortaMalas;

    // Construtor corrigido - tipos consistentes
    public Carro(String marca, String modelo, int ano, String cor, double preco,
            int nPortas, String tipoCombustivel, double capacidadePortaMalas) {
        super(marca, modelo, ano, cor, preco);
        this.nPortas = nPortas;
        this.tipoCombustivel = tipoCombustivel;
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    // Métodos específicos do carro
    public void abrirPortaMalas() {
        System.out.println("Abrindo porta-malas...");
    }

    public void fecharPortaMalas() {
        System.out.println("Fechando porta-malas...");
    }

    // Getters
    public int getnPortas() {
        return nPortas;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public double getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    // Setters
    public void setnPortas(int nPortas) {
        this.nPortas = nPortas;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public void setCapacidadePortaMalas(double capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    // Polimorfismo - sobrescrita do método
    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Tipo de combustível: " + tipoCombustivel);
        System.out.println("Número de portas: " + nPortas);
        System.out.println("Capacidade porta-malas: " + capacidadePortaMalas + " litros");
    }
}