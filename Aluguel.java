import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Aluguel {
    private int id;
    private Carro carro;
    private Cliente cliente;
    private int qtdDias;
    private int kmInicial;
    private int kmFinal;
    private double valorTotalAluguel;

    public void iniciarLocacao() {
        cliente = new Cliente();
        cliente.cadastrarUsuario();
        carro = new Carro();
        carro.cadastrarCarro();

        // Solicitar a quantidade de dias do aluguel
        String inputQtdDias = JOptionPane.showInputDialog(null, "Informe a quantidade de dias do aluguel:");
        if (inputQtdDias != null && !inputQtdDias.isEmpty()) {
            qtdDias = Integer.parseInt(inputQtdDias);
        } else {
            JOptionPane.showMessageDialog(null, "Informe a quantidade de dias corretamente!");
            iniciarLocacao();
        }

        // Solicitar o Km Inicial do veículo
        String inputKmInicial = JOptionPane.showInputDialog(null, "Informe o Km Inicial do veículo:");
        if (inputKmInicial != null && !inputKmInicial.isEmpty()) {
            kmInicial = Integer.parseInt(inputKmInicial);
        } else {
            JOptionPane.showMessageDialog(null, "Informe o Km Inicial corretamente!");
            iniciarLocacao();
        }
    }

    public void fecharLocacao() {
        String inputKmFinal = JOptionPane.showInputDialog(null, "Informe o Km Final:");
        if (inputKmFinal != null && !inputKmFinal.isEmpty()) {
            kmFinal = Integer.parseInt(inputKmFinal);

            // Calcular a quantidade de dias locados * valor por km
            double valorAluguel = qtdDias * carro.getValorPorKm() * (kmFinal - kmInicial);

            // Aplicar os descontos conforme as regras
            if (qtdDias > 20) {
                valorAluguel *= 0.8; // Desconto de 20% para mais de 20 dias de aluguel
            } else if (qtdDias > 10) {
                valorAluguel *= 0.9; // Desconto de 10% para mais de 10 dias de aluguel
            }

            valorTotalAluguel = valorAluguel;
        } else {
            JOptionPane.showMessageDialog(null, "Informe o Km Final corretamente!");
            fecharLocacao();
        }
    }

    public void mostrarResumoLocacao() {
        DecimalFormat df = new DecimalFormat("#.00"); // Formato para duas casas decimais

        String resumo = "Resumo Aluguel\n\n" +
                        "Cliente\n" +
                        cliente.mostrarDadosUsuario() + "\n\n" +
                        "Carro\n" +
                        "Modelo: " + carro.getModelo() + "\n" +
                        "Marca: " + carro.getMarca() + "\n" +
                        "Valor por Km: " + carro.getValorPorKm() + "\n\n" +
                        "Aluguel\n" +
                        "Quantidade de dias: " + qtdDias + "\n" +
                        "Km Inicial: " + kmInicial + "\n" +
                        "Km Final: " + kmFinal + "\n" +
                        "Valor Total: R$" + df.format(valorTotalAluguel); // Formatação do valor

        // Exibir o resumo do aluguel através de JOptionPane.
        JOptionPane.showMessageDialog(null, resumo, "Resumo Aluguel", JOptionPane.INFORMATION_MESSAGE);
    }
}