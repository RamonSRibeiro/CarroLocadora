
import javax.swing.JOptionPane;

public class Carro {
    private int id;
    private String modelo;
    private String marca;
    private double valorPorKm;

    public void cadastrarCarro() {
        modelo = JOptionPane.showInputDialog(null, "Informe o modelo do carro:");
        marca = JOptionPane.showInputDialog(null, "Informe a marca do carro:");
        String inputValorPorKm = JOptionPane.showInputDialog(null, "Informe o valor por Km:");

        // Verificar se os valores foram inseridos e não são vazios
        if (modelo == null || modelo.isEmpty() || marca == null || marca.isEmpty() || inputValorPorKm == null || inputValorPorKm.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente!");
            cadastrarCarro(); // Chamada recursiva para repetir o cadastro em caso de campos vazios
        } else {
            valorPorKm = Double.parseDouble(inputValorPorKm);
        }
    }

    public void mostrarDadosCarro() {
        String dados = "Modelo: " + modelo + "\n" +
                       "Marca: " + marca + "\n" +
                       "Valor por Km: " + valorPorKm;
        JOptionPane.showMessageDialog(null, dados, "Dados do Carro", JOptionPane.INFORMATION_MESSAGE);
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorPorKm() {
        return valorPorKm;
    }

    public void setValorPorKm(double valorPorKm) {
        this.valorPorKm = valorPorKm;
    }
}


        
    
    

    
