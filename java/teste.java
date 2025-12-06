import java.util.HashMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class teste extends JFrame {

    private JTextField[] campos = new JTextField[5];
    private JTextArea resultadoArea = new JTextArea(8, 20);

    public teste() {
        super("contador de numeros");

        setLayout(new FlowLayout());

        add(new JLabel("Digite cinco números:"));

        // Criar 5 campos (não 6)
        for (int i = 0; i < 5; i++) {
            campos[i] = new JTextField(5);
            add(campos[i]);
        }

        JButton botao = new JButton("contar");
        add(botao);

        add(new JScrollPane(resultadoArea));

        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executarContagem();
            }
        });

        // CONFIGURAÇÕES DO FRAME (tem que ficar dentro do construtor!)
        setSize(300, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void executarContagem() {
        int[] numeros = new int[5];

        try {
            // Lendo os 5 números
            for (int i = 0; i < 5; i++) {
                numeros[i] = Integer.parseInt(campos[i].getText());
            }

            HashMap<Integer, Integer> mapa = new HashMap<>();

            // Contando com HashMap
            for (int n : numeros) {
                if (mapa.containsKey(n)) {
                    mapa.put(n, mapa.get(n) + 1);
                } else {
                    mapa.put(n, 1);
                }
            }

            // Mostrar resultado 
            resultadoArea.setText("Contagem dos números:\n");
            for (int chave : mapa.keySet()) {
                resultadoArea.append("Número " + chave + " apareceu " + mapa.get(chave) + " vezes\n");
            }

        } catch (Exception erro) {
            resultadoArea.setText("Por favor, insira apenas números inteiros válidos.");
        }
    }

    public static void main(String[] args) {
        new teste();
    }
}
