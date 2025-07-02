import java.time.LocalDateTime;

public class Venda {
    private Veiculo veiculo;
    private Pessoa comprador;
    private double valor;
    private LocalDateTime dataVenda;

    public Venda(Veiculo veiculo, Pessoa comprador, double valor, LocalDateTime dataVenda) {
        this.veiculo = veiculo;
        this.comprador = comprador;
        this.valor = valor;
        this.dataVenda = dataVenda;
    }

    public Pessoa getComprador() {
        return comprador;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public double getValor() {
        return valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setComprador(Pessoa comprador) {
        this.comprador = comprador;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void exibirDetalhesDaVenda() {
        double lucro = calcularLucro();
        
        System.out.println("=== DETALHES DA VENDA ===");
        System.out.println("Veiculo: " + veiculo.getModelo() + " - Ano: " + veiculo.getAno());
        System.out.println("Comprador: " + comprador.getNome());
        System.out.println("Contato: " + comprador.getTelefone());
        System.out.println("Preço original: R$ " + String.format("%.2f", veiculo.getPreco()));
        System.out.println("Valor da venda: R$ " + String.format("%.2f", valor));
        System.out.println("Resultado: " + getTipoResultado() + " de R$ " + String.format("%.2f", Math.abs(lucro)));
        System.out.println("Data da venda: " + dataVenda);
        System.out.println("==========================");
    }


    // add para o ex4


    public double calcularLucro() {
        // Lucro = Valor da Venda - Preço Original do Veículo
        return valor - veiculo.getPreco();
    }
    
    public String getTipoResultado() {
        double lucro = calcularLucro();
        if (lucro > 0) {
            return "LUCRO";
        } else if (lucro < 0) {
            return "PREJUÍZO";
        } else {
            return "NEUTRO";
        }
    }
}
