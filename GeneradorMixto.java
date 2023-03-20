import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.util.HashSet;
import java.util.Set;

public class GeneradorMixto {
    public static int[] generar(int a, int c, int m, int x0, int n) {
        int[] numeros = new int[n + 1];
        numeros[0] = x0;
        int[] uAleatorio = new int[n + 1];
        uAleatorio[0] = 000;
        for (int i = 1; i < n + 1; i++) {
            numeros[i] = (a * numeros[i - 1] + c) % m;
        }
        return numeros;
    }

    public static double[] generarUAleatorio(int a, int c, int m, int x0, int n) {
        double x = x0;
        double[] uAleatorio = new double[n + 1];
        uAleatorio[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            x = (a * x + c) % m;
            uAleatorio[i] = Math.round(x / m * 10000.0) / 10000.0;
        }
        return uAleatorio;
    }

    public static int cicloVida(int a, int c, int m, int x0, int n) {
        double x = x0;
        int cicloVida = 0;
        // double valorInicial = 0;
        double[] uAleatorio = new double[n + 1];
        uAleatorio[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            x = (a * x + c) % m;
            uAleatorio[i] = Math.round(x / m * 10000.0) / 10000.0;
            // if (i == 1) {
            //     valorInicial = uAleatorio[i];
            // }
        }
        // for (int i = 1; i < n; i++) {
        //     if (uAleatorio[i + 1] == valorInicial) {
        //         cicloVida = i;
        //         break;
        //     } else {
        //         cicloVida = n;
        //     }
        // }
        Set<Double> valoresUnicos = new HashSet<>();
        for (int i = 2; i < uAleatorio.length; i++) {
            if (!valoresUnicos.add(uAleatorio[i])) {
                cicloVida = i - 2;
                break;
            }
        }
        return cicloVida;
    }

    public static double[] generarMulti(double a, double m, double c, double x0, double n) {
        double[] numeros = new double[(int) n + 1];
        numeros[0] = x0;
        double[] uAleatorio = new double[(int) n + 1];
        uAleatorio[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            numeros[i] = (a * numeros[i - 1]) % (Math.pow(m, c));
        }
        return numeros;
    }

    public static double[] generarUAleatorioMulti(double a, double m, double c, double x0, double n) {
        double x = x0;
        double[] uAleatorio = new double[(int) n + 1];
        uAleatorio[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            x = (a * x) % (Math.pow(m, c));
            uAleatorio[i] = Math.round(x / ((Math.pow(m, c)) - 1) * 10000.0) / 10000.0;
        }
        return uAleatorio;
    }

    public static double cicloVidaMulti(double a, double m, double c, double x0, double n) {
        double x = x0;
        double cicloVida = n;
        double[] uAleatorio = new double[(int) n + 1];
        uAleatorio[0] = 0;
        for (int i = 2; i < n + 1; i++) {
            x = (a * x) % (Math.pow(m, c));
            uAleatorio[i] = Math.round(x / (Math.pow(m, c)) * 10000.0) / 10000.0;
        }
        Set<Double> valoresUnicos = new HashSet<>();
        for (int i = 2; i < uAleatorio.length; i++) {
            if (!valoresUnicos.add(uAleatorio[i])) {
                cicloVida = i - 2;
                break;
            }
        }
        return cicloVida;
    }
    

    public static void main(String[] args) {
        // Crea la ventana y el panel
        JFrame frame = new JFrame("Generador Congruencial Mixto y Múltiple");
        JPanel panel = new JPanel();

        // Crea los elementos para la entrada de datos
        JLabel labelA = new JLabel("a: ");
        JTextField inputA = new JTextField(5);
        JLabel labelC = new JLabel("c: ");
        JTextField inputC = new JTextField(5);
        JLabel labelM = new JLabel("m: ");
        JTextField inputM = new JTextField(5);
        JLabel labelX0 = new JLabel("x0: ");
        JTextField inputX0 = new JTextField(5);
        JLabel labelN = new JLabel("n: ");
        JTextField inputN = new JTextField(5);
        JButton botonGenerar = new JButton("Generar");

        // Crea los elementos para la entrada de datos
        JLabel labelD = new JLabel("a: ");
        JTextField inputD = new JTextField(5);
        JLabel labelF = new JLabel("m: ");
        JTextField inputF = new JTextField(5);
        JLabel labelE = new JLabel("exp: ");
        JTextField inputE = new JTextField(5);
        JLabel labelG = new JLabel("x0: ");
        JTextField inputG = new JTextField(5);
        JLabel labelH = new JLabel("n: ");
        JTextField inputH = new JTextField(5);
        JButton botonGenera = new JButton("Generar");

        // Crea el modelo de la tabla
        String[] columnas = { "i", "Xi=", "U = Aleatorio", "ciclo de vida" };
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Crea la tabla y le asigna el modelo
        JTable tabla = new JTable(modelo);

        // Crea el panel para los componentes de entrada de datos
        JPanel panelEntrada = new JPanel(new BorderLayout());

        // Crea un panel para los componentes de entrada de datos
        JPanel panelDatos = new JPanel();
        panelDatos.add(labelA);
        panelDatos.add(inputA);
        panelDatos.add(labelC);
        panelDatos.add(inputC);
        panelDatos.add(labelM);
        panelDatos.add(inputM);
        panelDatos.add(labelX0);
        panelDatos.add(inputX0);
        panelDatos.add(labelN);
        panelDatos.add(inputN);
        panelDatos.add(botonGenerar);
        panelEntrada.add(panelDatos, BorderLayout.CENTER);

        // Agrega el panel de entrada al panel principal
        panel.add(panelEntrada);

        // _______________________________________________________________________________
        // JLabel labelTextos = new JLabel("Generadores congruenciales multiplicativos:
        // ");
        // panelEntrada.add(labelTextos, BorderLayout.SOUTH);

        JLabel labelTexto = new JLabel("Generadores congruenciales mixtos y múltiples: ");
        panelEntrada.add(labelTexto, BorderLayout.NORTH);

        // Crea un panel para los componentes de entrada de datos
        JPanel panelData = new JPanel();
        panelData.add(labelD);
        panelData.add(inputD);
        panelData.add(labelF);
        panelData.add(inputF);
        panelData.add(labelE);
        panelData.add(inputE);
        panelData.add(labelG);
        panelData.add(inputG);
        panelData.add(labelH);
        panelData.add(inputH);
        panelData.add(botonGenera);
        panelEntrada.add(panelData, BorderLayout.SOUTH);

        // Agrega el panel de entrada al panel principal
        panel.add(panelEntrada);

        // Agrega el scroll pane y le agrega la tabla
        JScrollPane scroll = new JScrollPane(tabla);

        // Agrega los elementos para la entrada de datos al panel
        panel.add(scroll);

        // Agrega el panel a la ventana
        frame.add(panel);

        // Configura la ventana y la muestra
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Agrega un listener al botón para generar los números
        botonGenerar.addActionListener(e -> {
            if (e.getSource() == botonGenerar) {
                int a = Integer.parseInt(inputA.getText());
                int c = Integer.parseInt(inputC.getText());
                int m = Integer.parseInt(inputM.getText());
                int x0 = Integer.parseInt(inputX0.getText());
                int n = Integer.parseInt(inputN.getText());

                // Genera los números
                int[] resultados = generar(a, c, m, x0, n);
                double[] uAleatorio = generarUAleatorio(a, c, m, x0, n);
                int cicloVida = cicloVida(a, c, m, x0, n);

                // Borra los datos anteriores de la tabla
                modelo.setRowCount(0);

                // Agrega los nuevos datos al modelo de la tabla
                boolean primeraFila = true;
                for (int i = 0; i < resultados.length; i++) {
                    Object[] fila;
                    if (primeraFila) {
                        fila = new Object[] { i, resultados[i], uAleatorio[i], cicloVida };
                        primeraFila = false;
                    } else {
                        fila = new Object[] { i, resultados[i], uAleatorio[i], "" };
                    }
                    modelo.addRow(fila);
                }
            }
        });
        botonGenera.addActionListener(e -> {
            if (e.getSource() == botonGenera) {
                double a = Integer.parseInt(inputD.getText());
                double m = Integer.parseInt(inputF.getText());
                double c = Integer.parseInt(inputE.getText());
                double x0 = Integer.parseInt(inputG.getText());
                double n = Integer.parseInt(inputH.getText());

                // Genera los números
                double[] resultados = generarMulti(a, m, c, x0, n);
                double[] uAleatorio = generarUAleatorioMulti(a, m, c, x0, n);
                double cicloVida = cicloVidaMulti(a, m, c, x0, n);

                // Borra los datos anteriores de la tabla
                modelo.setRowCount(0);

                // Agrega los nuevos datos al modelo de la tabla
                boolean primeraFila = true;
                for (int i = 0; i < resultados.length; i++) {
                    Object[] fila;
                    if (primeraFila) {
                        fila = new Object[] { i, resultados[i], uAleatorio[i], cicloVida };
                        primeraFila = false;
                    } else {
                        fila = new Object[] { i, resultados[i], uAleatorio[i], "" };
                    }
                    modelo.addRow(fila);
                }
            }
        });
    }
}
