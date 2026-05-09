package biblioteca;

import javax.swing.*;

public class ListaProdutosOrdenados {

    public static void mostrar(String[] nomes, int total) {

        if (total == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
            return;
        }

        String[] nomesOrdenados = new String[total];

        for (int i = 0; i < total; i++) {
            nomesOrdenados[i] = nomes[i];
        }

        for (int i = 0; i < total - 1; i++) {
            for (int j = 0; j < total - 1 - i; j++) {
                if (nomesOrdenados[j].compareToIgnoreCase(nomesOrdenados[j + 1]) > 0) {
                    String aux = nomesOrdenados[j];
                    nomesOrdenados[j] = nomesOrdenados[j + 1];
                    nomesOrdenados[j + 1] = aux;
                }
            }
        }

        String lista = "PRODUTOS CADASTRADOS\n\n";

        for (int i = 0; i < total; i++) {
            lista += (i + 1) + " - " + nomesOrdenados[i] + "\n";
        }

        JTextArea areaTexto = new JTextArea(lista, 10, 20);
        areaTexto.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaTexto);

        JOptionPane.showMessageDialog(
                null,
                scroll,
                "Lista de Produtos",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}