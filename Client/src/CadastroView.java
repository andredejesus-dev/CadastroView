import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class CadastroView extends JFrame {

    private JTextField txtNome = new JTextField(30);
    private JFormattedTextField txtdata;
    private JTextField txtemail = new JTextField(30);
    private JComboBox<String> cbSexo = new JComboBox<>(new String[]{"Masculino", "Feminino", "Outro"});
    private JTextArea areaLista = new JTextArea(10, 40);

    private int proximId = 1;
    private Integer idEmEdicao = null;

    public CadastroView() {

        try {
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
            txtdata = new JFormattedTextField(mascaraData);
            txtdata.setColumns(8);
        } catch (ParseException e) {
            txtdata = new JFormattedTextField();
            e.printStackTrace();
        }

        setTitle("Sistema de Cadastro - Time Team");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel painelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        painelFormulario.add(new JLabel("Nome: "), gbc);

        gbc.gridx = 1;
        painelFormulario.add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        painelFormulario.add(new JLabel("Data de nasc: "), gbc);

        gbc.gridx = 1;
        painelFormulario.add(txtdata, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painelFormulario.add(new JLabel("Email: "), gbc);

        gbc.gridx = 1;
        painelFormulario.add(txtemail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painelFormulario.add(new JLabel("Sexo: "), gbc);

        gbc.gridx = 1;
        painelFormulario.add(cbSexo, gbc);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar");
        JButton btnDeletar = new JButton("Remover ID");
        JButton btnAltera = new JButton("Alterar ID");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnDeletar);
        painelBotoes.add(btnAltera);

        btnCadastrar.addActionListener(e -> {

            String nome = txtNome.getText();
            String data = txtdata.getText();
            String email = txtemail.getText();
            String sexo = cbSexo.getSelectedItem().toString();

            if (idEmEdicao != null) {

                String[] linhas = areaLista.getText().split("\n");
                StringBuilder novoTexto = new StringBuilder();

                for (String linhaAtual : linhas) {
                    if (!linhaAtual.startsWith("Id: " + idEmEdicao + " ")) {
                        novoTexto.append(linhaAtual).append("\n");
                    }
                }

                novoTexto.append("Id: " + idEmEdicao +
                        " | Nome: " + nome +
                        " | Data: " + data +
                        " | Email: " + email +
                        " | Sexo: " + sexo + "\n");

                areaLista.setText(novoTexto.toString());

                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                idEmEdicao = null;

            } else {
                // 🔹 Cadastro normal
                int idAtual = proximId++;
                areaLista.append("Id: " + idAtual +
                        " | Nome: " + nome +
                        " | Data: " + data +
                        " | Email: " + email +
                        " | Sexo: " + sexo + "\n");
            }

            limparCampos();
        });

        btnDeletar.addActionListener(e -> {

            String idDigitado = JOptionPane.showInputDialog(
                    this,
                    "Digite o id que deseja remover"
            );

            if (idDigitado != null && !idDigitado.isEmpty()) {

                String[] linhas = areaLista.getText().split("\n");
                StringBuilder novoTexto = new StringBuilder();
                boolean removido = false;

                for (String linhaAtual : linhas) {
                    if (!linhaAtual.startsWith("Id: " + idDigitado + " ")) {
                        novoTexto.append(linhaAtual).append("\n");
                    } else {
                        removido = true;
                    }
                }

                areaLista.setText(novoTexto.toString());

                if (removido) {
                    JOptionPane.showMessageDialog(this, "Registro removido com sucesso");
                } else {
                    JOptionPane.showMessageDialog(this, "Id não encontrado");
                }
            }
        });

        btnAltera.addActionListener(e -> {

            String idDigitado = JOptionPane.showInputDialog(
                    this,
                    "Digite o ID que deseja alterar"
            );

            if (idDigitado != null && !idDigitado.isEmpty()) {

                String[] linhas = areaLista.getText().split("\n");
                boolean encontrado = false;

                for (String linhaAtual : linhas) {

                    if (linhaAtual.startsWith("Id: " + idDigitado + " ")) {

                        idEmEdicao = Integer.parseInt(idDigitado);

                        String[] partes = linhaAtual.split("\\|");

                        txtNome.setText(partes[1].replace("Nome:", "").trim());
                        txtdata.setText(partes[2].replace("Data:", "").trim());
                        txtemail.setText(partes[3].replace("Email:", "").trim());
                        cbSexo.setSelectedItem(partes[4].replace("Sexo:", "").trim());

                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    JOptionPane.showMessageDialog(this, "ID não encontrado!");
                }
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        painelFormulario.add(painelBotoes, gbc);

        add(painelFormulario, BorderLayout.NORTH);
        areaLista.setEditable(false);
        add(new JScrollPane(areaLista), BorderLayout.CENTER);

        setVisible(true);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtdata.setText("");
        txtemail.setText("");
        cbSexo.setSelectedIndex(0);
        txtNome.requestFocus();
    }
}

