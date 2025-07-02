public class Veiculo implements InterfaceVeiculo {
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private double preco;
    private int velocidade;

    public Veiculo(String marca, String modelo, int ano, String cor, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.preco = preco;
        this.velocidade = 0;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public double getPreco() {
        return preco;
    }

    public int getVelocidade() {
        return velocidade;
    }

    // Setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public void ligar() {
        System.out.println("Veiculo ligado...");
    }

    @Override
    public void desligar() {
        System.out.println("Veiculo desligado...");
    }

    @Override
    public void acelerar(int velocidade) {
        this.velocidade += velocidade;
        System.out.println("Veiculo acelerando...");
        System.out.println("Velocidade atual: " + this.velocidade + " km/h");
    }

    @Override
    public void frear(int velocidade) {
        this.velocidade -= velocidade;
        if (this.velocidade < 0)
            this.velocidade = 0;
        System.out.println("Veiculo desacelerando...");
        System.out.println("Velocidade atual: " + this.velocidade + " km/h");
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("=== INFORMAÇÕES DO VEÍCULO ===");
        System.out.println("Marca:  " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano:    " + ano);
        System.out.println("Cor:    " + cor);
        System.out.println("Preço:  R$ " + preco);
    }
}