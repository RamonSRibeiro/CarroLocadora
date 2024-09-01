import javax.swing.JOptionPane;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    public void cadastrarUsuario() {
        nome = JOptionPane.showInputDialog(null, "Informe o nome do cliente:");
        cpf = JOptionPane.showInputDialog(null, "Informe o CPF do cliente:");
        telefone = JOptionPane.showInputDialog(null, "Informe o telefone do cliente:");

        // Verificar se os valores foram inseridos e não são vazios
        if (nome == null || nome.isEmpty() || cpf == null || cpf.isEmpty() || telefone == null || telefone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
            cadastrarUsuario(); // Chamada recursiva para repetir o cadastro em caso de campos vazios
        }
    }

    public String mostrarDadosUsuario() {
        String dados = "Nome: " + nome + "\n" +
                       "CPF: " + cpf + "\n" +
                       "Telefone: " + telefone;
        return dados;
    }
}
