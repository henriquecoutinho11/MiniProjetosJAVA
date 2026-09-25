package views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.Converter;

// Esta classe será utilizada para construir a GUI
public class TemperatureConverterGUI extends JFrame implements ActionListener {

    // Declaração dos componentes internos da GUI
    private JTextField txtInput; // Cria campo para o usuário inserir texto
    private JLabel lblResult; // Cria uma caixa de texto para a aplicação expor o resultado
    private JButton btnConverter; // Cria botão de conversão
    private JButton btnInvert; // Cria botão que inverte a conversão
    // Menu suspenso de opções de conversão
    private JComboBox<String> comboOrigem;
    private JComboBox<String> comboDestino;

    public TemperatureConverterGUI() {

        // 1. Configuração do JFrame (Janela)
        super("Conversor de Temperaturas");

        // Encerra o programa quando o usuário clica no 'X'.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // criamos um JPanel principal, colocamos o layout nele e adicionamos uma "Borda
        // Vazia"
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(2, 3, 10, 10)); // 2 linhas, 3 colunas, espaçamento 10px
        painelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20)); // Padding: Top, Left, Bottom, Right

        // Define este painel como o conteúdo principal da nossa janela
        setContentPane(painelPrincipal);

        // 2. Inicialização dos componentes visuais
        txtInput = new JTextField();
        txtInput.setHorizontalAlignment(JTextField.CENTER);

        btnConverter = new JButton("Converter");

        ImageIcon icon = new ImageIcon(getClass().getResource("/images/reverse_icon.png"));
        Image img = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        btnInvert = new JButton(new ImageIcon(img));

        lblResult = new JLabel("Resultado", SwingConstants.CENTER);

        // Inicializando e preenchendo as listas suspensas (JComboBox)
        // Podemos passar os itens diretamente no construtor através de um array
        String[] escalas = { "Celsius", "Fahrenheit", "Kelvin" };

        comboOrigem = new JComboBox<>(escalas);
        comboDestino = new JComboBox<>(escalas);

        // 3. Adicionando os componentes ao Painel Principal (respeitando o GridLayout)
        // LINHA 1
        painelPrincipal.add(txtInput); // Coluna 1
        painelPrincipal.add(btnConverter); // Coluna 2 (Fica entre o TextField e o Label)
        painelPrincipal.add(lblResult); // Coluna 3

        // LINHA 2
        painelPrincipal.add(comboOrigem); // Coluna 1 (Fica abaixo do TextField)
        painelPrincipal.add(btnInvert); // Coluna 2 (Separador)
        painelPrincipal.add(comboDestino); // Coluna 3 (Fica abaixo do Label de resultado)

        // 4. Configuração de Eventos
        // Adiciona um "monitor" de cliques ao botão
        btnConverter.addActionListener(this);
        btnInvert.addActionListener(this);

        // 5. Configurações finais de exibição
        setSize(450, 150); // Largura x Altura
        setLocationRelativeTo(null); // Centraliza a janela no meio da tela
        setVisible(true); // Exibe o JFrame
    }

    // Método obrigatório da interface ActionListener (captura do clique)
    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica se o evento veio realmente do nosso botão
        if (e.getSource() == btnConverter) {
            try {
                // Captura o que foi digitado e converte para double
                double valorDigitado = Double.parseDouble(txtInput.getText());

                // Captura as escalas selecionadas nos JComboBox
                // O getSelectedItem retorna Object, por isso fazemos o cast (String)
                String escalaOrigem = (String) comboOrigem.getSelectedItem();
                String escalaDestino = (String) comboDestino.getSelectedItem();
                String result = "";

                /*
                 * =========================================================
                 * INTEGRAÇÃO DA CLASSE DE CONVERSÃO AQUI ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
                 * =========================================================
                 */

                if (escalaOrigem.equals("Celsius") && escalaDestino.equals("Fahrenheit")) {
                    result = Converter.celsiusToFahrenheit(valorDigitado) + " °F";
                } else if (escalaOrigem.equals("Celsius") && escalaDestino.equals("Kelvin")) {
                    result = Converter.celsiusToKelvin(valorDigitado) + " K";
                } else if (escalaOrigem.equals("Fahrenheit") && escalaDestino.equals("Celsius")) {
                    result = Converter.fahrenheitToCelsius(valorDigitado) + " °C";
                } else if (escalaOrigem.equals("Fahrenheit") && escalaDestino.equals("Kelvin")) {
                    result = Converter.fahrenheitToKelvin(valorDigitado) + " K";
                } else if (escalaOrigem.equals("Kelvin") && escalaDestino.equals("Celsius")) {
                    result = Converter.kelvinToCelsius(valorDigitado) + " °C";
                } else if (escalaOrigem.equals("Kelvin") && escalaDestino.equals("Fahrenheit")) {
                    result = Converter.kelvinToFahrenheit(valorDigitado) + " °F";
                } else {
                    // Caso o usuário selecione a mesma escala para origem e destino
                    result = valorDigitado + " (mesma escala)";
                }

                /*
                 * =========================================================
                 * INTEGRAÇÃO DA CLASSE DE CONVERSÃO AQUI ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
                 * =========================================================
                 */

                // Exibe o resultado final formatado no Label
                lblResult.setText(result);

            } catch (NumberFormatException ex) {
                // Tratamento caso o usuario digite letras ou símbolos em vez de números
                lblResult.setText("Valor inválido!");
            }
        }
        if (e.getSource() == btnInvert) {
            int aux = comboDestino.getSelectedIndex();
            comboDestino.setSelectedIndex(comboOrigem.getSelectedIndex());
            comboOrigem.setSelectedIndex(aux);
        }
    }
}