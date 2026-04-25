
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        //Menu Principal
        String menu = JOptionPane.showInputDialog("""
                                    XYZ COMERCIO DE PRODUTOS LTDA.
                                    SISTEMA DE CONTROLE DE ESTOQUE 
                                     
                                     MENU PRINCIPAL 
                                     
                                    1 - CADASTRO DE PRODUTOS
                                    2 - MOVIMENTAÇÃO
                                    3 - REAJUSTE DE PREÇOS
                                    4 - RELATÓRIOS
                                    0 - FINALIZAR \n
                                    DIGITE A OPÇÃO DESEJADA: """);
        char menuCHAR = menu.charAt(0);
        switch (menuCHAR) {
            case '1':
                //Menu principal -> Cadastro de Produtos
                String cadastro = JOptionPane.showInputDialog("""
                                    XYZ COMERCIO DE PRODUTOS LTDA.
                                    SISTEMA DE CONTROLE DE ESTOQUE
                                                                            
                                     CADASTRO DE PRODUTOS
                                    
                                    1 - INCLUSÃO 
                                    2 - ALTERAÇÃO 
                                    3 - CONSULTA 
                                    4 - EXCLUSÃO 
                                    0 - RETORNAR \n
                                    DIGITE A OPÇÃO DESEJADA: """);

                char cadastroCHAR = cadastro.charAt(0);
                switch (cadastroCHAR) {
                    //Menu principal -> Cadastro de Produtos -> Inclusão de produtos
                    case '1':
                        char newinclusaoCHAR;
                        do {
                            String nome = JOptionPane.showInputDialog("Informe o nome do produto a ser cadastrado: ");
                            double preco = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do produto a ser cadastrado: "));
                            int qtde = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade do produto a ser cadastrado: "));

                            String confirma = JOptionPane.showInputDialog("""
                    Você confirma a inclusão do produto?
                    S - Sim
                    N - Não
                    """);
                            char confirmaCHAR = confirma.charAt(0);

                            if (confirmaCHAR == 's' || confirmaCHAR == 'S') {
                                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Inclusão cancelada!");
                            }

                            String newinclusao = JOptionPane.showInputDialog("""
                    Você deseja realizar nova inclusão de produto?
                    S - Sim
                    N - Não
                    """);
                            newinclusaoCHAR = newinclusao.charAt(0);

                            if (newinclusaoCHAR == 'n' || newinclusaoCHAR == 'N') {
                                JOptionPane.showMessageDialog(null, "Encerrando o cadastro de produtos!");
                            }

                        } while (newinclusaoCHAR == 's' || newinclusaoCHAR == 'S');
                        break;
                    case '2':

                }
                break;
                // Menu principal -> Movimentação de produtos
            case '2':
                String movimentacao = JOptionPane.showInputDialog("""
                                    XYZ COMERCIO DE PRODUTOS LTDA.
                                    SISTEMA DE CONTROLE DE ESTOQUE
                                                                            
                                     MOVIMENTAÇÃO
                                    
                                    1 - ENTRADA 
                                    2 - SAÍDA 
                                    0 - RETORNAR \n
                                    DIGITE A OPÇÃO DESEJADA: """);
                break;
                // Menu principal -> Reajuste de preços
            case '3':
                String reajuste = JOptionPane.showInputDialog("""
                                    XYZ COMERCIO DE PRODUTOS LTDA.
                                    SISTEMA DE CONTROLE DE ESTOQUE
                                                                            
                                     REAJUSTE DE PREÇOS
                                                              """);
                break;
                // Menu principal -> Relatórios
            case '4':
                String relatorios = JOptionPane.showInputDialog("""
                                    XYZ COMERCIO DE PRODUTOS LTDA.
                                    SISTEMA DE CONTROLE DE ESTOQUE
                                                                            
                                     RELATÓRIOS
                                    
                                    1 - LISTA DE PREÇOS 
                                    2 - BALANÇO FÍSICO-FINANCEIRO 
                                    0 - RETORNAR \n
                                    DIGITE A OPÇÃO DESEJADA: """);
                break;
            default:
                break;
        }

    }
}
