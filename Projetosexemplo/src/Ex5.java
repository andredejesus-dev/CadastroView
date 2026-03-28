// Superclasse
class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularBonus() {
        return salario * 0.05;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: R$" + salario);
        System.out.println("Bônus: R$" + calcularBonus());
        System.out.println("--------------------");
    }
}

// Subclasse Gerente
class Gerente extends Funcionario {
    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.10;
    }
}

// Subclasse Diretor
class Diretor extends Funcionario {
    public Diretor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return salario * 0.20;
    }
}

// Classe principal
public class Ex5 {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Ana", 3000);
        Funcionario f2 = new Gerente("Carlos", 5000);
        Funcionario f3 = new Diretor("Mariana", 10000);

        f1.exibirInformacoes();
        f2.exibirInformacoes();
        f3.exibirInformacoes();
    }
}
