import java.util.ArrayList;

public class ClienteRepository {


    private ArrayList<Cliente> ListaDeClientes = new ArrayList<>();

    //Metodo para adicionar um cliente na lista
    public void adicionar(Cliente cliente) {
        ListaDeClientes.add(cliente);

    }

    //Metodo para devolver a lista de clientes inteira para quem pedir
    public ArrayList<Cliente> buscarTodos() {
        return ListaDeClientes;

    }

    //Metodo para remover um cliente a listaArray usando a posição do (indice)
    public void remover(int index) {
        if (index >= 0 && index < ListaDeClientes.size()) {
            ListaDeClientes.remove(index);
        }
    }

    public void atualizar(int id, Cliente Cliente) {
        if (id >= 0 && id < ListaDeClientes.size()) {
            ListaDeClientes.set(id, Cliente);
        }
    }

    public Cliente buscarPordl(int id) {
        if (id >= 0 && id < ListaDeClientes.size()) {
            return ListaDeClientes.get(id);
        }
        return null;
    }
}




