package auxiliares;

import javax.swing.JOptionPane;

public class FuncoesAuxiliares {

    public static int buscarProduto(String[] nomes, int total, String nomeBusca) {

        for (int i = 0; i < total; i++) {
            if (nomes[i].equalsIgnoreCase(nomeBusca)) {
                return i;
            }
        }

        return -1;
    }

    public static boolean estoqueVazio(int total) {

        if (total == 0) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
            return true;
        }

        return false;
    }
}
