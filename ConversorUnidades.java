import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ConversorUnidades {
    public static void main(String[] args) {
        // Crear la ventana principal (JFrame)
        JFrame frame = new JFrame("Conversor de Unidades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

        // Crear el panel donde se colocarán los componentes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));  // Layout en forma de cuadrícula
        frame.add(panel);

        // Etiqueta para la unidad de entrada
        JLabel inputLabel = new JLabel("Valor a convertir:");
        panel.add(inputLabel);

        // Campo de texto para ingresar el valor
        JTextField inputField = new JTextField();
        panel.add(inputField);

        // Etiqueta para seleccionar la unidad de origen
        JLabel fromLabel = new JLabel("Unidad de origen:");
        panel.add(fromLabel);

        // Lista desplegable para seleccionar la unidad de origen
        String[] unidades = {"Metros", "Kilogramos", "Celsius"};
        JComboBox<String> fromComboBox = new JComboBox<>(unidades);
        panel.add(fromComboBox);

        // Etiqueta para seleccionar la unidad de destino
        JLabel toLabel = new JLabel("Unidad de destino:");
        panel.add(toLabel);

        // Lista desplegable para seleccionar la unidad de destino
        JComboBox<String> toComboBox = new JComboBox<>(unidades);
        panel.add(toComboBox);

        // Etiqueta para mostrar el resultado
        JLabel resultLabel = new JLabel("Resultado:");
        panel.add(resultLabel);

        // Campo de texto para mostrar el resultado
        JTextField resultField = new JTextField();
        resultField.setEditable(false);  // No se puede editar, solo mostrar resultado
        panel.add(resultField);

        // Botón para realizar la conversión
        JButton convertButton = new JButton("Convertir");
        panel.add(convertButton);

        // Acción al hacer clic en el botón de conversión
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener el valor ingresado y la unidad de origen y destino
                    double value = Double.parseDouble(inputField.getText());
                    String fromUnit = (String) fromComboBox.getSelectedItem();
                    String toUnit = (String) toComboBox.getSelectedItem();
                    
                    double result = 0;
                    String resultText = "";

                    // Realizar la conversión según las unidades seleccionadas
                    if (fromUnit.equals("Metros") && toUnit.equals("Kilómetros")) {
                        result = value / 1000;  // Convertir metros a kilómetros
                        resultText = result + " km";
                    } else if (fromUnit.equals("Kilogramos") && toUnit.equals("Libras")) {
                        result = value * 2.20462;  // Convertir kilogramos a libras
                        resultText = result + " lbs";
                    } else if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
                        result = (value * 9/5) + 32;  // Convertir Celsius a Fahrenheit
                        resultText = result + " °F";
                    } else {
                        resultText = "Conversión no disponible.";
                    }

                    // Mostrar el resultado en el campo de texto
                    resultField.setText(resultText);

                } catch (NumberFormatException ex) {
                    resultField.setText("Por favor ingresa un valor válido.");
                }
            }
        });

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
