![senai_logo](./images/logo.png)

# Mini Projeto: Conversor de temperatura.

Profº.: Cainã Antunes Silva  
Tecnólogo em Análise e Desenvolvimento de Sistemas (ADS)
___

> O objetivo deste mini projeto é praticar o uso das Classes Java apresentadas em aula. Além disso esta atividade ajudará a compreender o funcionamento de classes estáticas, modificador final, sobrecarga de métodos e exceções.  

O projeto apresenta uma interface gráfica (`TemperatureConverterGUI`), que é composto um painel (`JPanel`) com *grid layout* de 2 linhas e 3 colunas. Um `JTextField` coleta a entrada do usuário. O usuário também pode selecionar a escala de origem e destino utilizando 2 `JComboBox`. Por fim, um `JButton` dispara a conversão quando acionado.

***

## Descrição do Projeto:
   
Você foi contratado para desenvolver uma pequena biblioteca de utilidades que permita a conversão entre diferentes unidades de temperatura.

> Utilizando a Interface Gráfica previamente desenvolvida com `javax.swing` implemente uma classe em Java que permita ao usuário converter temperaturas entre Celsius, Fahrenheit e Kelvin.

O sistema deverá atender aos seguintes requisitos:

1. A classe deve se chamar `TemperatureConverter`.
2. A classe deve ser estática, pois não faz sentido criar instâncias para ela.
    > **Como cria classes estáticas em Java:** Declare a classe como public. Crie um construtor privado para impedir que outras partes do código usem o operador new. Adicione apenas métodos e atributos static.
3. Devem existir métodos para conversão entre todas as principais escalas de temperatura: Celsius (°C), Fahrenheit (°F) e Kelvin (K).
4. Cada método deverá ser público e estático e receber um valor `double` como parâmetro, retornando também um `double`.
5. Se atentar à valores abaixo do zero absoluto.

**Diagrama de Classes:**

```mermaid
    classDiagram
    class TemperatureConverter {
        + final ABSOLUTE_ZERO_CELSIUS : double
        + final ABSOLUTE_ZERO_FAHRENHEIT : double
        + final ABSOLUTE_ZERO_KELVIN : double
        + celsiusToFahrenheit(celsius : double) : double
        + celsiusToKelvin(celsius : double) : double
        + fahrenheitToCelsius(fahrenheit : double) : double
        + fahrenheitToKelvin(fahrenheit : double) : double
        + kelvinToCelsius(kelvein : double) : double
        + kelvinToFahrenheit(kelvin : double) : double
    }
    class TemperatureConverterGUI{
        - txtImput : JTextField
        - lblResult : JLabel
        - btnConverter : JButton
        - btnInvert : JButton
        - comboDestino : JComboBox
        - comboOrigem : JComboBox

        + actionPerformed(ActionEvent e) :: void
    }
    class App {
        + TemperatureConverterGUI
        + main() :: void
    }
    class JFrame{}

    JFrame <|-- TemperatureConverterGUI
    TemperatureConverter --> TemperatureConverterGUI
    TemperatureConverterGUI --> App
```

> **Como implementar o projeto:** Crie sua classe dentro da pasta models. Depois utilize-a dentro da classe `TemperatureConverterGUI` no espaço indicado com comentários, procure por **INTEGRAÇÃO DA CLASSE DE CONVERSÃO AQUI**. Não é necessário alterar outras partes do projeto.


**Fundamentos teóricos:**

<p align="center">
    <img src="https://static.mundoeducacao.uol.com.br/mundoeducacao/2023/09/escalas-termometricas.jpg" width="400px">
</p>

$$
\frac{C}{5}=\frac{(F-32)}{9}=\frac{(K-273)}{5}
$$
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