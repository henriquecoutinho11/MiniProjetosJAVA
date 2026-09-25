![senai_logo](images/logo.png)

# Mini Projeto: Conta Bancária - Básico

Profº.: Cainã Antunes Silva  
Tecnólogo em Análise e Desenvolvimento de Sistemas (ADS)
___


> O objetivo desta lista de exercícios é praticar a tarefa de converter as abstrações realizadas utilizando diagrama de classe em código, colocando em prática a essesncia do paradigma de programação orientada à objetos. Além disso, neste projeto você pode  

O paradigma de desenvolvimento de software intitulado Programação Orientada à Objetos é uma ferramenta poderosa que auxilia na construção de sistemas complexos. A abstração é um recurso indispensável para programadores que almejam dominar esta poderosa técnica de programação. Entretando, é necessário dominar a habilidade de converter abstrações em código, ou seja, trazer classes e objetos do mundo das ideias para o mundo real.

Para mais informações acesse [Aula 01: Paradigma POO.](https://cainaantunes.notion.site/Aula-01-Paradigma-POO-23fbde521b3b80149a11f08e9d1eac02?source=copy_link)

***

1. **Projeto 01:** Sistema de Conta Bancária
    <br>
    >**Contexto:** Construa um sistema simples de gerenciamento de contas bancárias.
    
    **Descrição:**
    ```mermaid
        classDiagram
        class ContaBancaria{
            - numero : int
            - saldo : double
            - nome : string
            + depositar (double value) : void
            + sacar (double value): void
        }
        class BankGUI{
            - JTextField txtInput
            - JTextField txtInput
            - JButton btnSaque    
            - JButton btnDeposito  
            - JLabel lblConta       
            - JLabel lblNome        
            - JLabel lblSaldo
            - ContaBancaria conta
            + actionPerformed(ActionEvent e): void
        }
        class JFrame{}
        class App{
            + main(): void
        }
        App *-- BankGUI
        BankGUI --|> JFrame
        ContaBancaria --* BankGUI
    ```
    ---

    **Tarefas:**
    1. Implemente a classe `ContaBancaria`. Se atente às possíveis operações inválidas que podem envolver os métodos `depositar(double valor)` e `sacar(double valor)`. Além disso também pessa na questão de encapsulamento para protejer seus atributos internos, espesiamente o `saldo`.
    2. A classe `BankGUI` é responsável por gerar uma interface gráfica para a aplicação utilizando a biblioteca `javax.swing`. Ela já está parcialmente implementada, mas você deve:
        * Instanciar um objeto `ContaBancaria` dentro desta classe (utilise `JOptionPane.showInputDialog()` para solicitar o nome do proprietário da conta).
        * Implementar as lógicas relacinadas aos cliques nos botões `btnDepositar` e `btnSacar`.
        * Atualizar as labels `lblNome`, `lblConta` e `lblSaldo`.
        
        Procure pelas indicações:

        ```Java
        /**************************************************
        ** IMPLEMENTAR AQUI                              **
        **************************************************/
        ```

    3. A classe `App` apenas inicializa a aplicação, você não precisa fazer alterações nela.
    <br>

***

## Extra: Criar Interfaces com `javax.swing`

O `javax.swing` é uma biblioteca para criar interfaces gráficas Desktop em Java. Ela possui total controle sobre a renderização, permitindo que a janela tenha o mesmo design independente do sistema operacional.

Veja a seguir alguns componentes disponibiliza pela bilbioteca: 

| Componente | Função no Projeto | Principais Métodos |
| :--- | :--- | :--- |
| **JFrame** | Janela principal que agrupa e exibe todos os outros elementos. | `setSize()`, `setVisible()`, `setDefaultCloseOperation()` |
| **JTextField** | Caixa de entrada de texto onde o usuário digita o número. | `getText()`, `setText()`, `setHorizontalAlignment()` |
| **JLabel** | Rótulo de texto estático usado para exibir os resultados. | `setText()`, `getText()` |
| **JButton** | Botão que age como gatilho para executar a conversão. | `addActionListener()`, `doClick()` |
| **JComboBox** | Lista suspensa usada para escolher as escalas. | `getSelectedItem()`, `setSelectedItem()` |

> ### A mecânica dos Eventos: `ActionListener` e `ActionEvent`
> O Java trabalha com a Orientação a Eventos utilizando "ouvintes". O `ActionListener` atua como um radar conectado a um componente (como o `JButton`). Quando o botão é clicado, o Java empacota todas as informações desse clique em um objeto chamado `ActionEvent` e o envia. O ouvinte captura essa "mensagem" instantaneamente através do método `actionPerformed` e executa a ação contida em sua implementação.

***
