import java.lang.ref.Cleaner;

public class Cliente {


    private String nome;
    private String dataNascimento;
    private String email;
    private char sexo;

    public Cliente(String nome, String dataNascimento, String email, char sexo) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public char getSexo() {
        return sexo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | " + "Nasc: " + dataNascimento + " | " + "Email: " + email + " | " + "Sexo: " + sexo;
    }


}

