public class Caminhao extends Veiculo {
    private double capacidadeCarga;
    private int numeroEixos;
    private String tipoCarroceria;
    
    public Caminhao(String marca, String modelo, int ano, String cor, double preco,
                   double capacidadeCarga, int numeroEixos, String tipoCarroceria) {
        super(marca, modelo, ano, cor, preco);
        this.capacidadeCarga = capacidadeCarga;
        this.numeroEixos = numeroEixos;
        this.tipoCarroceria = tipoCarroceria;
    }
    
    // Getters
    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }
    
    public int getNumeroEixos() {
        return numeroEixos;
    }
    
    public String getTipoCarroceria() {
        return tipoCarroceria;
    }
    
    // Setters
    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
    
    public void setNumeroEixos(int numeroEixos) {
        this.numeroEixos = numeroEixos;
    }
    
    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    
    @Override
    public void ligar() {
        System.out.println("Caminhao ligado - motor diesel funcionando!");
    }
}