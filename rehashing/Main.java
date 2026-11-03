import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Hash tabela = new Hash(100);
        Random random = new Random(1090);

        int totalColisoesGeral = 0;

        int chave1 = -1;
        int colisoes1 = -1;
        int chave2 = -1;
        int colisoes2 = -1;
        int chave3 = -1;
        int colisoes3 = -1;


        for (int i = 0; i < 100; i++) {
            if (tabela.getElementosInseridos() >= 90) {
                System.out.println("-> Tabela em 90% de ocupação\n");
                break;
            }

            int chave = random.nextInt(100001);

            // Tenta inserir e pega quantas colisões esse elemento específico teve
            int colisoesDestaChave = tabela.inserir(chave);

            if (colisoesDestaChave != -1) {
                totalColisoesGeral += colisoesDestaChave;

                // Atualiza o ranking do Top 3 colisões de forma simples
                if (colisoesDestaChave > colisoes1) {
                    colisoes3 = colisoes2; chave3 = chave2;
                    colisoes2 = colisoes1; chave2 = chave1;
                    colisoes1 = colisoesDestaChave; chave1 = chave;
                } else if (colisoesDestaChave > colisoes2) {
                    colisoes3 = colisoes2; chave3 = chave2;
                    colisoes2 = colisoesDestaChave; chave2 = chave;
                } else if (colisoesDestaChave > colisoes3) {
                    colisoes3 = colisoesDestaChave; chave3 = chave;
                }
            }
        }

        tabela.imprimirTabelaHash();

        // Imprime os dados
        System.out.println("============== ESTATÍSTICAS FINAIS ============");
        System.out.println("Total de elementos: " + tabela.getElementosInseridos());
        System.out.println("Total de colisões geral: " + totalColisoesGeral);
        System.out.print("Posições livres na matriz: ");
        for (int i = 0; i < 100; i++) {
            if (tabela.getValor(i) == -1) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        // Teste de busca com o Top 3
        System.out.println("============== TESTE DE BUSCA - 3 COLISÕES =============");
        System.out.println(" Chave: " + chave1 + " | Colisões: " + colisoes1);
        System.out.println(" Chave: " + chave2 + " | Colisões: " + colisoes2);
        System.out.println(" Chave: " + chave3 + " | Colisões: " + colisoes3);
    }
}