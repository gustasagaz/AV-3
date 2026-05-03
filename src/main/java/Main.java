
import javax.swing.*;

public class Main {

    static String[] nomes = new String[100];
    static double[] precos = new double[100];
    static double[] quantidades = new double[100];
    static String[] unidades = new String[100];
    static int total = 0;

    public static void main(String[] args) {

        char menuCHAR;

        // MENU PRINCIPAL 
        do {
            String menu = JOptionPane.showInputDialog("""
                                    XYZ COMERCIO DE PRODUTOS LTDA.
                                    SISTEMA DE CONTROLE DE ESTOQUE 
                                     
                                     MENU PRINCIPAL 
                                     
                                    1 - CADASTRO DE PRODUTOS
                                    2 - MOVIMENTAÇÃO
                                    3 - REAJUSTE DE PREÇOS
                                    4 - RELATÓRIOS
                                    0 - FINALIZAR
                                    
                                    DIGITE A OPÇÃO DESEJADA: """);

            menuCHAR = menu.charAt(0);

            switch (menuCHAR) {
                case '1':
                    menuCadastro();
                    break;

                case '2':
                    menuMovimentacao();
                    break;

                case '3':
                    reajuste();
                    break;

                case '4':
                    menuRelatorios();
                    break;
            }

        } while (menuCHAR != '0');
    }

    // ================= MEUNU CADASTRO =================
    static void menuCadastro() {
        char cadastroCHAR;

        do {
            String cadastro = JOptionPane.showInputDialog("""
                                    XYZ COMERCIO DE PRODUTOS LTDA.
                                    SISTEMA DE CONTROLE DE ESTOQUE
                                                          
                                    CADASTRO DE PRODUTOS
                                    
                                    1 - INCLUSÃO 
                                    2 - ALTERAÇÃO 
                                    3 - CONSULTA 
                                    4 - EXCLUSÃO 
                                    0 - RETORNAR
                                    
                                    DIGITE A OPÇÃO: """);

            cadastroCHAR = cadastro.charAt(0);

            switch (cadastroCHAR) {
                case '1':
                    incluir();
                    break;
                case '2':
                    alterar();
                    break;
                case '3':
                    consultar();
                    break;
                case '4':
                    exclusao();
                    break;
            }

        } while (cadastroCHAR != '0');
    }

    // ================= INCLUSÃO =================
    static void incluir() {
        char newinclusaoCHAR;

        do {
            String nome = JOptionPane.showInputDialog("Informe o nome do produto: ");
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Nome: " + nome + "\nInforme o preço: "));
            String Uni = JOptionPane.showInputDialog("Nome: " + nome + "\nPreço: R$" + String.format("%.2f", preco) + "\nInforme a unidade de medida (ex: Kg,Un,Cx): ");
            double qtde = Double.parseDouble(JOptionPane.showInputDialog("Nome: " + nome + "\nPreço: R$" + String.format("%.2f", preco) + "\nUnidade de medida: " + Uni + "\nInforme a quantidade: "));

            String confirma = JOptionPane.showInputDialog("Confirma inclusão?\n\n"
                    + "Nome: " + nome
                    + "\nPreço: R$" + String.format("%.2f", preco)
                    + "\nQuantidade: " + String.format("%.3f", qtde) + Uni
                    + "\n\nS - Sim"
                    + "\nN - Não");

            char confirmaCHAR = confirma.charAt(0);

            if (confirmaCHAR == 's' || confirmaCHAR == 'S') {
                nomes[total] = nome;
                precos[total] = preco;
                unidades[total] = Uni;
                quantidades[total] = qtde;
                total++;

                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Inclusão cancelada!");
            }

            String newinclusao = JOptionPane.showInputDialog("""
                    Deseja nova inclusão?
                    S - Sim
                    N - Não
                    """);

            newinclusaoCHAR = newinclusao.charAt(0);

        } while (newinclusaoCHAR == 's' || newinclusaoCHAR == 'S');
    }

    // ================= altereção ================= 
    static void alterar() {
        char newalteracaoChar;

        do {
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
            String nomeBusca = JOptionPane.showInputDialog("Informe o nome do produto que deseja alterar:");
            int pos = -1;

            for (int i = 0; i < total; i++) {
                if (nomes[i].equalsIgnoreCase(nomeBusca)) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Produto encontrado!\n"
                        + "Nome: " + nomes[pos]
                        + "\nPreço: R$" + String.format("%.2f", precos[pos])
                        + "\nQuantidade: " + String.format("%.3f", quantidades[pos]) + unidades[pos]);

                double novoPreco = Double.parseDouble(JOptionPane.showInputDialog("O preço antigo é : R$" + String.format("%.2f", precos[pos]) + "\nDigite novo preço ou repita para manter:"));
                String novaUni = JOptionPane.showInputDialog("Unidade antiga: " + unidades[pos] + "\nInforme a nova unidade de medida ou digite a mesma para manter (ex: Kg,Un,Cx,Pct):");
                double novaQtd = Double.parseDouble(JOptionPane.showInputDialog("A quantidade antiga é: " + String.format("%.3f", quantidades[pos]) + "\nInforme a nova quantidade ou digite a mesma para manter:"));

                String confirma = JOptionPane.showInputDialog("Confirma alteração?\n"
                        + "Nome: " + nomes[pos]
                        + "\nPreço antigo: R$" + precos[pos] + " -> novo preço R$" + String.format("%.2f", novoPreco)
                        + "\nQuantidade antiga: " + String.format("%.3f", quantidades[pos]) + unidades[pos] + " -> nova quantidade " + String.format("%.3f", novaQtd) + novaUni
                        + "\n\nS - Sim"
                        + "\nN - Não");

                char confirmaChar = confirma.charAt(0);

                if (confirmaChar == 'S' || confirmaChar == 's') {
                    precos[pos] = novoPreco;
                    unidades[pos] = novaUni;
                    quantidades[pos] = novaQtd;

                    JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Alteração cancelada!");
                }
            }

            String nova = JOptionPane.showInputDialog("""
                Deseja alterar outro produto?
                S - Sim
                N - Não
                """);

            newalteracaoChar = nova.charAt(0);

        } while (newalteracaoChar == 'S' || newalteracaoChar == 's');
    }

    // ================= CONSULTA ================
    static void consultar() {
        char newconsultaChar;

        do {
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
            String nomeConsulta = JOptionPane.showInputDialog("Informe o nome do produto que deseja consultar: ");
            int posConsulta = -1;

            for (int i = 0; i < total; i++) {
                if (nomes[i].equalsIgnoreCase(nomeConsulta)) {
                    posConsulta = i;
                    break;
                }
            }
            if (posConsulta == -1) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            } else {
                JOptionPane.showMessageDialog(null,
                        "Produto encontrado!\n"
                        + "Nome: " + nomes[posConsulta]
                        + "\nPreço: R$" + String.format("%.2f", precos[posConsulta])
                        + "\nQuantidade: " + String.format("%.3f", quantidades[posConsulta]) + unidades[posConsulta]);
            }
            String novaconsulta = JOptionPane.showInputDialog("""
                Deseja consultar outro produto?
                S - Sim
                N - Não
                """);

            newconsultaChar = novaconsulta.charAt(0);

        } while (newconsultaChar == 'S' || newconsultaChar == 's');
    }

    // ================= exclusão ====================
    static void exclusao() {
        char newexclusaoChar;

        do {
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
            if (total == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                return;
            }

            String nomeBusca = JOptionPane.showInputDialog("Informe o nome do produto que deseja excluir:");

            int pos = -1;

            for (int i = 0; i < total; i++) {
                if (nomes[i].equalsIgnoreCase(nomeBusca)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            } else {

                JOptionPane.showMessageDialog(null,
                        "Produto encontrado!\n\n"
                        + "Nome: " + nomes[pos]
                        + "\nPreço: R$ " + precos[pos]
                        + "\nUnidade: " + unidades[pos]
                        + "\nQuantidade: " + quantidades[pos]);

                String confirma = JOptionPane.showInputDialog("""
                Confirma exclusão?
                S - Sim
                N - Não
                """);

                char confirmaChar = confirma.charAt(0);

                if (confirmaChar == 'S' || confirmaChar == 's') {

                    for (int i = pos; i < total - 1; i++) {
                        nomes[i] = nomes[i + 1];
                        precos[i] = precos[i + 1];
                        unidades[i] = unidades[i + 1];
                        quantidades[i] = quantidades[i + 1];
                    }

                    total--;

                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");

                } else {
                    JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
                }
            }

            String novaexclusao = JOptionPane.showInputDialog("""
                Deseja excluir outro produto?
                S - Sim
                N - Não
                """);

            newexclusaoChar = novaexclusao.charAt(0);

        } while (newexclusaoChar == 'S' || newexclusaoChar == 's');
    }

    // ================= MOVIMENTAÇÃO =================
    static void menuMovimentacao() {
        char op;

        do {
            String movimentacao = JOptionPane.showInputDialog("""
                                    XYZ COMERCIO DE PRODUTOS LTDA.
                                    SISTEMA DE CONTROLE DE ESTOQUE
                                                              
                                    MOVIMENTAÇÃO
                                    
                                    1 - ENTRADA 
                                    2 - SAÍDA 
                                    0 - RETORNAR
                                    
                                    DIGITE A OPÇÃO: """);

            op = movimentacao.charAt(0);

            switch (op) {
                case '1':
                    entrada();
                    break;
                case '2':
                    saida();
                    break;
            }

        } while (op != '0');
    }

    // ================= entrada ==================
    static void entrada() {
        char novaEntradaChar;

        do {
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
            if (total == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                return;
            }

            String nomeBusca = JOptionPane.showInputDialog("Informe o nome do produto:");

            int pos = -1;

            for (int i = 0; i < total; i++) {
                if (nomes[i].equalsIgnoreCase(nomeBusca)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            } else {

                JOptionPane.showMessageDialog(null,
                        "PRODUTO: " + nomes[pos]
                        + "\nQTDE ATUAL: " + quantidades[pos] + unidades[pos]);

                int entrada = Integer.parseInt(
                        JOptionPane.showInputDialog("Informe a quantidade de entrada: ")
                );

                if (entrada <= 0) {
                    JOptionPane.showMessageDialog(null, "Quantidade inválida!");
                } else {

                    double qtdeFinal = quantidades[pos] + entrada;

                    JOptionPane.showMessageDialog(null,
                            "QTDE FINAL: " + qtdeFinal + unidades[pos]);

                    String confirma = JOptionPane.showInputDialog("""
                        Confirma entrada?
                        S - Sim
                        N - Não
                        """);

                    char confirmaChar = confirma.charAt(0);

                    if (confirmaChar == 'S' || confirmaChar == 's') {
                        quantidades[pos] = qtdeFinal;

                        JOptionPane.showMessageDialog(null, "Entrada realizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação cancelada!");
                    }
                }
            }

            String novaEntrada = JOptionPane.showInputDialog("""
                Deseja realizar nova entrada?
                S - Sim
                N - Não
                """);

            novaEntradaChar = novaEntrada.charAt(0);

        } while (novaEntradaChar == 'S' || novaEntradaChar == 's');
    }
    // ================= saida ==================

    static void saida() {
        char novaSaidaChar;

        do {
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
            if (total == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                return;
            }

            String nomeBusca = JOptionPane.showInputDialog("Informe o nome do produto:");
            int pos = -1;

            for (int i = 0; i < total; i++) {
                if (nomes[i].equalsIgnoreCase(nomeBusca)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            } else {

                JOptionPane.showMessageDialog(null,
                        "PRODUTO: " + nomes[pos]
                        + "\nQTDE ATUAL: " + quantidades[pos] + unidades[pos]);

                int saida = Integer.parseInt(
                        JOptionPane.showInputDialog("Informe a quantidade de saída:")
                );

                if (saida <= 0) {
                    JOptionPane.showMessageDialog(null, "Quantidade inválida!");
                } else if (saida > quantidades[pos]) {
                    JOptionPane.showMessageDialog(null, "Estoque insuficiente!");
                } else {

                    double qtdeFinal = quantidades[pos] - saida;

                    JOptionPane.showMessageDialog(null,
                            "QTDE FINAL: " + qtdeFinal + unidades[pos]);

                    String confirma = JOptionPane.showInputDialog("""
                        Confirma saída?
                        S - Sim
                        N - Não
                        """);

                    char confirmaChar = confirma.charAt(0);

                    if (confirmaChar == 'S' || confirmaChar == 's') {
                        quantidades[pos] = qtdeFinal;

                        JOptionPane.showMessageDialog(null, "Saída realizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Operação cancelada!");
                    }
                }
            }

            String novaSaida = JOptionPane.showInputDialog("""
                Deseja realizar nova saída?
                S - Sim
                N - Não
                """);

            novaSaidaChar = novaSaida.charAt(0);

        } while (novaSaidaChar == 'S' || novaSaidaChar == 's');
    }

        // ================= REAJUSTE =================
static void reajuste() {
    char novoReajusteChar;

    do {
        String opcao = JOptionPane.showInputDialog("""
                XYZ COMERCIO DE PRODUTOS LTDA.
                SISTEMA DE CONTROLE DE ESTOQUE
                
                REAJUSTE DE PREÇOS
                
                1 - REAJUSTE GERAL
                2 - REAJUSTE DE UM PRODUTO
                
                DIGITE A OPÇÃO:
                """);

        char opcaoChar = opcao.charAt(0);

        if (opcaoChar == '2') {

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
            String nomeBusca = JOptionPane.showInputDialog("Informe o nome do produto:");
            int pos = -1;

            for (int i = 0; i < total; i++) {
                if (nomes[i].equalsIgnoreCase(nomeBusca)) {
                    pos = i;
                    break;
                }
            }

            if (pos == -1) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            } else {

                double percentual = Double.parseDouble(JOptionPane.showInputDialog(
                                "PRODUTO: " + nomes[pos]
                                + "\nUNIDADE: " + unidades[pos]
                                + "\nPREÇO ATUAL: R$" + String.format("%.2f", precos[pos])
                                + "\n\nPERCENTUAL DE REAJUSTE:"
                        )
                );

                double novoPreco = precos[pos] + (precos[pos] * percentual / 100);

                String confirma = JOptionPane.showInputDialog(
                        "CONFIRMA REAJUSTE?\n\n"
                        + "PRODUTO: " + nomes[pos]
                        + "\nPREÇO ATUAL: R$" + String.format("%.2f", precos[pos])
                        + "\nNOVO PREÇO: R$" + String.format("%.2f", novoPreco)
                        + "\n\nS - SIM"
                        + "\nN - NÃO"
                );

                char confirmaChar = confirma.charAt(0);

                if (confirmaChar == 'S' || confirmaChar == 's') {
                    precos[pos] = novoPreco;
                    JOptionPane.showMessageDialog(null, "Reajuste realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Reajuste cancelado!");
                }
            }

        } else if (opcaoChar == '1') {

            if (total == 0) {
                JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!");
                return;
            }

            double percentual = Double.parseDouble(
                    JOptionPane.showInputDialog("Informe o percentual de reajuste geral:")
            );

            String confirma = JOptionPane.showInputDialog(
                    "CONFIRMA REAJUSTE GERAL DE " + percentual + "% ?\n\n"
                    + "S - SIM"
                    + "\nN - NÃO"
            );

            char confirmaChar = confirma.charAt(0);

            if (confirmaChar == 'S' || confirmaChar == 's') {

                for (int i = 0; i < total; i++) {
                    precos[i] = precos[i] + (precos[i] * percentual / 100);
                }

                JOptionPane.showMessageDialog(null, "Reajuste geral realizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Reajuste cancelado!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida!");
        }

        String novoReajuste = JOptionPane.showInputDialog("""
                NOVO REAJUSTE?
                S - SIM
                N - NÃO
                """);

        novoReajusteChar = novoReajuste.charAt(0);

    } while (novoReajusteChar == 'S' || novoReajusteChar == 's');
}

    // ================= RELATÓRIOS =================
    static void menuRelatorios() {
        char op;

        do {
            String relatorios = JOptionPane.showInputDialog("""
                                    RELATÓRIOS
                                    
                                    1 - LISTA DE PREÇOS 
                                    2 - BALANÇO FÍSICO-FINANCEIRO 
                                    0 - RETORNAR
                                    
                                    DIGITE A OPÇÃO: """);

            op = relatorios.charAt(0);

            switch (op) {
                case '1':
                    JOptionPane.showMessageDialog(null, "Lista de preços.");
                    break;
                case '2':
                    JOptionPane.showMessageDialog(null, "Balanço físico-financeiro.");
                    break;
            }

        } while (op != '0');
    }
}
