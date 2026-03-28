class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

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

    // Getters
    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getAno() {
        return this.ano;
    }
}

public class Ex3{
    public static void main(String[] args) {

        // Primeiro objeto
        Veiculo carro1 = new Veiculo();
        carro1.setMarca("BMW");
        carro1.setModelo("X5");
        carro1.setAno(2022);

        // Segundo objeto
        Veiculo carro2 = new Veiculo();
        carro2.setMarca("Audi");
        carro2.setModelo("A4");
        carro2.setAno(2020);

        // Exibindo os dados usando getters
        System.out.println("Carro 1:");
        System.out.println(carro1.getMarca());
        System.out.println(carro1.getModelo());
        System.out.println(carro1.getAno());

        System.out.println("\nCarro 2:");
        System.out.println(carro2.getMarca());
        System.out.println(carro2.getModelo());
        System.out.println(carro2.getAno());
    }
}

























