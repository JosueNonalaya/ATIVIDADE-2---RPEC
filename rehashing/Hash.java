public class Hash {
    private int[] tabela;
    private int capacidade;
    private int elementosInseridos;

    public Hash(int capacidade) {
        this.capacidade = capacidade;
        this.tabela = new int[capacidade];
        this.elementosInseridos = 0;

        for (int i = 0; i < capacidade; i++) {
            tabela[i] = -1; // inicia com -1
        }
    }

    public int getElementosInseridos() {
        return elementosInseridos;
    }

    public int getValor(int i) {
        return tabela[i];
    }


    public int inserir(int chave) {
        int i = chave % capacidade; // Função Hash
        int colisoes = 0;


        while (tabela[i] != -1) {  // Rehashing linear
            colisoes++;
            i = (i + 1) % capacidade; // Próxima posição circular
        }

        tabela[i] = chave; // Insere
        elementosInseridos++;

        return colisoes;
    }

    public int buscar(int chave) {
        int i = chave % capacidade;
        int inicio = i;

        while (tabela[i] != -1) {
            if (tabela[i] == chave) {
                return i;
            }
            i = (i + 1) % capacidade;
            if (i == inicio) {
                break;
            }
        }
        return -1;
    }

    public void imprimirTabelaHash() {
        System.out.println("|  Indice  |    Chave    |");
        System.out.println(" ------------------------ ");
        for (int i = 0; i < capacidade; i++) {
            System.out.print("|   " + (i < 10 ? " " + i : i) + "    |   ");

            System.out.print(" " + tabela[i] + (tabela[i] < 10000 && tabela[i] != -1 ? "  " : " "));

            System.out.println(" |");
        }
        System.out.println(" ________________________\n");
    }
}