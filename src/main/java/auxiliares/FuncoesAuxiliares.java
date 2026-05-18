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
    
    public static double lerDouble(String mensagem) {
        while (true) {
            String entrada = JOptionPane.showInputDialog(mensagem);

            if (entrada == null) {
                return -1;
            }

            try {
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite apenas números.");
            }
        }
    }
    
    public static char lerSimNao(String mensagem) {
            while (true) {
                String resposta = JOptionPane.showInputDialog(mensagem + "\n\nS - Sim\nN - Não");

                if (resposta == null || resposta.length() != 1) {
                    JOptionPane.showMessageDialog(null, "Digite apenas S ou N.");
                    continue;
                }

                char opcao = resposta.charAt(0);

                if (opcao == 'S' || opcao == 's' || opcao == 'N' || opcao == 'n') {
                    return opcao;
                } else {
                JOptionPane.showMessageDialog(null, "Opção inválida. Digite S ou N.");
            }
        }
    }
    
    public static String lerUnidade(String mensagem) {
        while (true) {
            String unidade = JOptionPane.showInputDialog(mensagem);

            if (unidade == null) {
                return null;
            }

            unidade = unidade.trim();

            if (unidade.equalsIgnoreCase("Kg")
                    || unidade.equalsIgnoreCase("Un")
                    || unidade.equalsIgnoreCase("Cx")
                    || unidade.equalsIgnoreCase("Pct")
                    || unidade.equalsIgnoreCase("L")) {
                return unidade;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Unidade inválida!\nUse apenas: Kg, Un, Cx, Pct ou L.");
            }
        }
    }
}

