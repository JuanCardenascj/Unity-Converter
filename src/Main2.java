import java.awt.event.*;  // Importamos las clases de Swing
import java.util.Random;  // Importamos las clases de eventos
import javax.swing.*;

public class Main2 {
    public static void main(String[] args) {
        // Crear la ventana principal (JFrame)
        JFrame frame = new JFrame("Juego de Adivinanza de Números");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Cerrar la ventana al salir
        frame.setSize(400, 300);  // Tamaño de la ventana
        frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

        // Crear el panel donde se colocarán los componentes
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        // Etiqueta para mostrar el mensaje de bienvenida
        JLabel label = new JLabel("Estoy pensando en un número entre 1 y 100.");
        label.setBounds(50, 20, 300, 25);
        panel.add(label);

        // Campo de texto para que el usuario ingrese su adivinanza
        JTextField inputField = new JTextField();
        inputField.setBounds(50, 80, 200, 30);
        panel.add(inputField);

        // Etiqueta para mostrar si el número es mayor, menor o si adivinó correctamente
        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(50, 150, 300, 25);
        panel.add(resultLabel);

        // Botón para enviar la adivinanza
        JButton guessButton = new JButton("Adivinar");
        guessButton.setBounds(50, 120, 100, 30);
        panel.add(guessButton);

        // Creamos un objeto Random para generar el número aleatorio
        Random random = new Random();
        int numeroSecreto = random.nextInt(100) + 1;
        int intentos = 0;

        // Acción cuando el usuario hace clic en el botón de "Adivinar"
        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Leemos el número introducido por el usuario
                    int intento = Integer.parseInt(inputField.getText());
                    intento++;

                    // Comprobamos si el número es mayor, menor o igual
                    if (intento < numeroSecreto) {
                        resultLabel.setText("El número es mayor. ¡Intenta de nuevo!");
                    } else if (intento > numeroSecreto) {
                        resultLabel.setText("El número es menor. ¡Intenta de nuevo!");
                    } else {
                        resultLabel.setText("¡Felicidades! Adivinaste el número en " + intentos + " intentos.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Por favor, ingresa un número válido.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
