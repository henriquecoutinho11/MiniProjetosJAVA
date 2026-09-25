import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class BankGUI extends JFrame implements ActionListener{
    
    // Declaração dos componentes internos da GUI
    private JTextField txtInput;    // Cria campo para o usuário inserir texto
    private JButton btnSaque;       // Cria botão de conversão
    private JButton btnDeposito;    // Cria botão que inverte a conversão
    private JLabel lblConta;        // Cria uma caixa de texto para a aplicação expor o numero da conta
    private JLabel lblNome;         // Cria uma caixa de texto para a aplicação expor o Nome do proprietário da conta
    private JLabel lblSaldo;        // Cria uma caixa de texto para a aplicação expor o saldo

    private ContaBancaria conta; // Cria a conta bancária

    public BankGUI() {

        
        // 1. Configuração do JFrame (Janela)
        super("Caixa Eletrônico");
        

        // Inicializa a conta bancária
        /*****************************************************
        ** IMPLEMENTAR LÓGICA DE INICIALIZAÇÃO DO NOME AQUI **
        *****************************************************/
        conta = new ContaBancaria(); 


        // Encerra o programa quando o usuário clica no 'X'.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // criamos um JPanel principal, colocamos o layout nele e adicionamos uma "Borda Vazia"
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(3, 2, 10, 10));        // 3 linhas, 2 colunas, espaçamento 10px
        painelPrincipal.setBorder(new EmptyBorder(20, 20, 20, 20));   // Padding: Top, Left, Bottom, Right
        
        // Define este painel como o conteúdo principal da nossa janela
        setContentPane(painelPrincipal);

        // 2. Inicialização dos componentes visuais
        txtInput = new JTextField();
        txtInput.setHorizontalAlignment(JTextField.CENTER); 
        
        btnSaque = new JButton("Sacar");
        btnDeposito = new JButton("Depositar");
        
        lblSaldo = new JLabel("Saldo: R$ ", SwingConstants.LEFT); 
        lblNome = new JLabel("Nome: ", SwingConstants.LEFT); 
        lblConta = new JLabel("Nº da Conta: ", SwingConstants.LEFT); 

        // 3. Adicionando os componentes ao Painel Principal (respeitando o GridLayout)
        // LINHA 1
        painelPrincipal.add(txtInput);   // Coluna 1
        painelPrincipal.add(lblConta);   // Coluna 2
        
        // LINHA 2
        painelPrincipal.add(btnDeposito);// Coluna 1
        painelPrincipal.add(lblNome);    // Coluna 2

        // LINHA 3
        painelPrincipal.add(btnSaque);   // Coluna 1
        painelPrincipal.add(lblSaldo);   // Coluna 2

        // 4. Configuração de Eventos
        // Adiciona um "monitor" de cliques aos botões
        btnSaque.addActionListener(this);
        btnDeposito.addActionListener(this);

        // 5. Configurações finais de exibição
        setSize(500, 200);  // Largura x Altura
        setLocationRelativeTo(null);    // Centraliza a janela no meio da tela
        setVisible(true);               // Exibe o JFrame
    }

    // Método obrigatório da interface ActionListener (captura do clique)
    @Override
    public void actionPerformed(ActionEvent e) {
        
        double valorDigitado; // Variável que armazenará o valor digitado pelo usuário
        
        try{
            // Captura o que foi digitado e converte para double
            valorDigitado = Double.parseDouble(txtInput.getText());
        
            if (e.getSource() == btnSaque) { // Verifica se o evento veio do botão Sacar
                
                /**************************************************
                ** IMPLEMENTAR LÓGICA DE SAQUE AQUI              **
                **************************************************/
                

            } else if (e.getSource() == btnDeposito) { // Verifica se o evento veio do botão Depositar
                
                /**************************************************
                ** IMPLEMENTAR LÓGICA DE DEPOSITO AQUI           **
                **************************************************/
                
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", 0);
            lblSaldo.setText("Valor Inválido!");
        }
        
        /***************************************************************************
        **Preencha os TextField abaixo com os valores de seu objeto ContaBancaria **
        ***************************************************************************/
        lblConta.setText("Nº da conta: ");
        lblNome.setText("Nome: ");
        lblSaldo.setText("Saldo: R$ ");
        
        // Limpa o JTextField
        txtInput.setText("");
        
    }
}
