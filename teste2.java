import java.io.*;
import java.util.*;

public class teste2 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        boolean jogoAtivo = true;

        while (jogoAtivo) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Começar um novo jogo");
            System.out.println("2. Continuar um jogo salvo");
            System.out.println("3. Sair");
            int escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    iniciarNovoJogo(entrada);
                    break;
                case 2:
                    if (new File("save.txt").exists()) {
                        continuarJogo(entrada);
                    } else {
                        System.out.println("Nenhum arquivo de jogo salvo encontrado.");
                        System.out.println("Deseja começar um novo jogo? (1. Sim / 2. Não)");
                        int novaEscolha = entrada.nextInt();
                        if (novaEscolha == 1) {
                            iniciarNovoJogo(entrada);
                        } else {
                            jogoAtivo = false;
                        }
                    }
                    break;
                case 3:
                    jogoAtivo = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }

        entrada.close();
    }

    public static void iniciarNovoJogo(Scanner entrada) {
        int linhaMatriz = 0;
        int colunaMatriz = 0;
        char letraEscolhida = ' ';
        int turnoJogador = 1;
        boolean jogoAtivo = true;
        boolean letraOkay = true;
        Matriz matrizTabuleiro = new Matriz(3, 3);

        char[] vetorMinusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] vetorMaiusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        ArrayList<String> maiusculasUsadas = new ArrayList<>();
        ArrayList<String> minusculasUsadas = new ArrayList<>();

        // Inicialização da matriz

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizTabuleiro.aplicaLetra(i, j, '-');
            }
        }
        imprimirTabuleiro(matrizTabuleiro.imprimeMatriz());

        // Início do jogo
        do {
            System.out.println("Turno: " + turnoJogador);
            if (turnoJogador % 2 == 1) { // Se o turno for ímpar, é o turno das minúsculas
                System.out.println("Turno das minúsculas");
                System.out.print("Suas letras disponíveis:");
                for (int i = 0; i < 26; i++) {
                    if (vetorMinusculas[i] != '0') {
                        System.out.print(vetorMinusculas[i] + " ");
                    }
                }
                System.out.println(' ');

                linhaMatriz = obterEntradaInteiraValida(entrada, "Informe a linha que deseja jogar: ", turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                if (linhaMatriz == -1) break; // verifica se é para salvar e parar

                colunaMatriz = obterEntradaInteiraValida(entrada, "Informe a coluna que deseja jogar: ", turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                if (colunaMatriz == -1) break; // verifica se é para salvar e parar

                boolean letraValida;
                do {
                    letraValida = true;
                    System.out.print("Informe sua letra: ");
                    String input = entrada.next();
                    if (input.length() != 1) {
                        System.out.println("Entrada inválida! Por favor, insira uma única letra.");
                        letraValida = false;
                        continue;
                    }
                    letraEscolhida = input.toLowerCase().charAt(0);

                    if (letraEscolhida == '@') {
                        salva(turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                        jogoAtivo = false;
                        break;
                    }

                    letraOkay = false;
                    for (int i = 0; i < 26; i++) {
                        if (letraEscolhida == vetorMinusculas[i]) {
                            letraOkay = true;
                            vetorMinusculas[i] = '0';
                            minusculasUsadas.add(String.valueOf(letraEscolhida));
                            break;
                        }
                    }
                    if (!letraOkay) {
                        System.out.print("Letra já usada ou inválida! Digite novamente. ");
                        letraValida = false;
                    }
                } while (!letraValida);

                if (letraOkay && validaJogada(matrizTabuleiro, letraEscolhida, linhaMatriz, colunaMatriz, turnoJogador)) {
                    matrizTabuleiro.aplicaLetra(linhaMatriz, colunaMatriz, letraEscolhida);
                    turnoJogador++;
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }

            } else { // Se for par é o turno das MAIÚSCULAS
                System.out.println("Turno das MAIÚSCULAS");
                System.out.print("Suas letras disponíveis:");
                for (int i = 0; i < 26; i++) {
                    if (vetorMaiusculas[i] != '0') {
                        System.out.print(vetorMaiusculas[i] + " ");
                    }
                }
                System.out.println(' ');

                linhaMatriz = obterEntradaInteiraValida(entrada, "Informe a linha que deseja jogar: ", turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                if (linhaMatriz == -1) break; // verifica se é para salvar e parar

                colunaMatriz = obterEntradaInteiraValida(entrada, "Informe a coluna que deseja jogar: ", turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                if (colunaMatriz == -1) break; // verifica se é para salvar e parar

                boolean letraValida;
                do {
                    letraValida = true;
                    System.out.print("Informe sua letra: ");
                    String input = entrada.next();
                    if (input.length() != 1) {
                        System.out.println("Entrada inválida! Por favor, insira uma única letra.");
                        letraValida = false;
                        continue;
                    }
                    letraEscolhida = input.toUpperCase().charAt(0);

                    if (letraEscolhida == '@') {
                        salva(turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                        jogoAtivo = false;
                        break;
                    }

                    letraOkay = false;
                    for (int i = 0; i < 26; i++) {
                        if (letraEscolhida == vetorMaiusculas[i]) {
                            letraOkay = true;
                            vetorMaiusculas[i] = '0';
                            maiusculasUsadas.add(String.valueOf(letraEscolhida));
                            break;
                        }
                    }
                    if (!letraOkay) {
                        System.out.print("Letra já usada ou inválida! Digite novamente. ");
                        letraValida = false;
                    }
                } while (!letraValida);

                if (letraOkay && validaJogada(matrizTabuleiro, letraEscolhida, linhaMatriz, colunaMatriz, turnoJogador)) {
                    matrizTabuleiro.aplicaLetra(linhaMatriz, colunaMatriz, letraEscolhida);
                    turnoJogador++;
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            }

            imprimirTabuleiro(matrizTabuleiro.imprimeMatriz());

            if (matrizTabuleiro.fimDeJogo()) {
                System.out.println("Fim de jogo!");
                break;
            }

            if (maiusculasUsadas.size() == 26 || minusculasUsadas.size() == 26) {
                System.out.println("Empate!");
                break;
            }

        } while (jogoAtivo);
    }

    public static void continuarJogo(Scanner entrada) {
        int linhaMatriz = 0;
        int colunaMatriz = 0;
        char letraEscolhida = ' ';
        int turnoJogador = 1;
        boolean jogoAtivo = true;
        boolean letraOkay = true;
        Matriz matrizTabuleiro = new Matriz(3, 3);

        ArrayList<String> maiusculasUsadas = new ArrayList<>();
        ArrayList<String> minusculasUsadas = new ArrayList<>();

        // Carregar o estado salvo do jogo
        try {
            BufferedReader reader = new BufferedReader(new FileReader("save.txt"));
            turnoJogador = reader.readLine().equals("M") ? 2 : 1;
            maiusculasUsadas.addAll(Arrays.asList(reader.readLine().split("")));
            minusculasUsadas.addAll(Arrays.asList(reader.readLine().split("")));
            for (int i = 0; i < 3; i++) {
                String linha = reader.readLine();
                for (int j = 0; j < 3; j++) {
                    matrizTabuleiro.aplicaLetra(i, j, linha.charAt(j));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        char[] vetorMinusculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] vetorMaiusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        for (String letra : maiusculasUsadas) {
            if (!letra.isEmpty()) {
                vetorMaiusculas[letra.charAt(0) - 'A'] = '0';
            }
        }
        for (String letra : minusculasUsadas) {
            if (!letra.isEmpty()) {
                vetorMinusculas[letra.charAt(0) - 'a'] = '0';
            }
        }

        imprimirTabuleiro(matrizTabuleiro.imprimeMatriz());

        // Continuar o jogo

        do {
            System.out.println("Turno: " + turnoJogador);
            if (turnoJogador % 2 == 1) { // Se o turno for ímpar, é o turno das minúsculas
                System.out.println("Turno das minúsculas");
                System.out.print("Suas letras disponíveis:");
                for (int i = 0; i < 26; i++) {
                    if (vetorMinusculas[i] != '0') {
                        System.out.print(vetorMinusculas[i] + " ");
                    }
                }
                System.out.println(' ');

                linhaMatriz = obterEntradaInteiraValida(entrada, "Informe a linha que deseja jogar: ", turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                if (linhaMatriz == -1) break; // verifica se é para salvar e parar

                colunaMatriz = obterEntradaInteiraValida(entrada, "Informe a coluna que deseja jogar: ", turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                if (colunaMatriz == -1) break; // verifica se é para salvar e parar

                boolean letraValida;
                do {
                    letraValida = true;
                    System.out.print("Informe sua letra: ");
                    String input = entrada.next();
                    if (input.length() != 1) {
                        System.out.println("Entrada inválida! Por favor, insira uma única letra.");
                        letraValida = false;
                        continue;
                    }
                    letraEscolhida = input.toLowerCase().charAt(0);

                    if (letraEscolhida == '@') {
                        salva(turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                        jogoAtivo = false;
                        break;
                    }

                    letraOkay = false;
                    for (int i = 0; i < 26; i++) {
                        if (letraEscolhida == vetorMinusculas[i]) {
                            letraOkay = true;
                            vetorMinusculas[i] = '0';
                            minusculasUsadas.add(String.valueOf(letraEscolhida));
                            break;
                        }
                    }
                    if (!letraOkay) {
                        System.out.print("Letra já usada ou inválida! Digite novamente. ");
                        letraValida = false;
                    }
                } while (!letraValida);

                if (letraOkay && validaJogada(matrizTabuleiro, letraEscolhida, linhaMatriz, colunaMatriz, turnoJogador)) {
                    matrizTabuleiro.aplicaLetra(linhaMatriz, colunaMatriz, letraEscolhida);
                    turnoJogador++;
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }

            } else { // Se for par é o turno das MAIÚSCULAS
                System.out.println("Turno das MAIÚSCULAS");
                System.out.print("Suas letras disponíveis:");
                for (int i = 0; i < 26; i++) {
                    if (vetorMaiusculas[i] != '0') {
                        System.out.print(vetorMaiusculas[i] + " ");
                    }
                }
                System.out.println(' ');

                linhaMatriz = obterEntradaInteiraValida(entrada, "Informe a linha que deseja jogar: ", turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                if (linhaMatriz == -1) break; // verifica se é para salvar e parar

                colunaMatriz = obterEntradaInteiraValida(entrada, "Informe a coluna que deseja jogar: ", turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                if (colunaMatriz == -1) break; // verifica se é para salvar e parar

                boolean letraValida;
                do {
                    letraValida = true;
                    System.out.print("Informe sua letra: ");
                    String input = entrada.next();
                    if (input.length() != 1) {
                        System.out.println("Entrada inválida! Por favor, insira uma única letra.");
                        letraValida = false;
                        continue;
                    }
                    letraEscolhida = input.toUpperCase().charAt(0);

                    if (letraEscolhida == '@') {
                        salva(turnoJogador, maiusculasUsadas, minusculasUsadas, matrizTabuleiro.getMatriz());
                        jogoAtivo = false;
                        break;
                    }

                    letraOkay = false;
                    for (int i = 0; i < 26; i++) {
                        if (letraEscolhida == vetorMaiusculas[i]) {
                            letraOkay = true;
                            vetorMaiusculas[i] = '0';
                            maiusculasUsadas.add(String.valueOf(letraEscolhida));
                            break;
                        }
                    }
                    if (!letraOkay) {
                        System.out.print("Letra já usada ou inválida! Digite novamente. ");
                        letraValida = false;
                    }
                } while (!letraValida);

                if (letraOkay && validaJogada(matrizTabuleiro, letraEscolhida, linhaMatriz, colunaMatriz, turnoJogador)) {
                    matrizTabuleiro.aplicaLetra(linhaMatriz, colunaMatriz, letraEscolhida);
                    turnoJogador++;
                } else {
                    System.out.println("Jogada inválida! Tente novamente.");
                }
            }

            imprimirTabuleiro(matrizTabuleiro.imprimeMatriz());

            if (matrizTabuleiro.fimDeJogo()) {
                System.out.println("Fim de jogo!");
                break;
            }

            if (maiusculasUsadas.size() == 26 || minusculasUsadas.size() == 26) {
                System.out.println("Empate!");
                break;
            }

        } while (jogoAtivo);
    }

    public static int obterEntradaInteira(Scanner entrada, String mensagem, int turnoJogador, ArrayList<String> maiusculasUsadas, ArrayList<String> minusculasUsadas, char[][] matriz) {
        while (true) {
            System.out.print(mensagem);
            String input = entrada.next();
            if (input.equals("@")) {
                salva(turnoJogador, maiusculasUsadas, minusculasUsadas, matriz);
                return -1; // Indica que o jogo deve parar
            }
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro ou '@' para salvar.");
            }
        }
    }

    public static int obterEntradaInteiraValida(Scanner entrada, String mensagem, int turnoJogador, ArrayList<String> maiusculasUsadas, ArrayList<String> minusculasUsadas, char[][] matriz) {
        int valor;
        do {
            valor = obterEntradaInteira(entrada, mensagem, turnoJogador, maiusculasUsadas, minusculasUsadas, matriz);
            if (valor == -1) return -1; // Indica que o jogo deve parar
            if (valor < 0 || valor > 2) {
                System.out.println("Entrada inválida! Por favor, insira um valor entre 0 e 2.");
            }
        } while (valor < 0 || valor > 2);
        return valor;
    }

    // método para verificar se a letra é valida na jogada
    public static boolean validaJogada(Matriz matrizTabuleiro, char letraJogada, int linhaJogada, int colunaJogada, int turnoJogador) {
        if (matrizTabuleiro.obtemValor(linhaJogada, colunaJogada) == '-') {
            return true;
        }
        if (turnoJogador % 2 == 1) { // se for turno das minúsculas
            if (Character.isLowerCase(matrizTabuleiro.obtemValor(linhaJogada, colunaJogada))) {
                return false; // posição já ocupada por uma letra minúscula
            } else {
                return (letraJogada - 32) > matrizTabuleiro.obtemValor(linhaJogada, colunaJogada); // minúscula é maior que MAIÚSCULA
            }
        } else { // se for turno das MAIÚSCULAS
            if (Character.isUpperCase(matrizTabuleiro.obtemValor(linhaJogada, colunaJogada))) {
                return false; // posição já ocupada por uma letra MAIÚSCULA
            } else {
                return (letraJogada + 32) > matrizTabuleiro.obtemValor(linhaJogada, colunaJogada); // MAIÚSCULA é maior que minúscula
            }
        }
    }

    public static void salva(int turnoJogador, ArrayList<String> maiusculasUsadas, ArrayList<String> minusculasUsadas, char[][] matriz) {
        EscritaArquivo writer = new EscritaArquivo();
        if (turnoJogador % 2 == 0) {
            writer.escreve("M");
        } else {
            writer.escreve("m");
        }

        writer.escreve(String.join("", maiusculasUsadas));
        writer.escreve(String.join("", minusculasUsadas));

        for (int i = 0; i < matriz.length; i++) {
            writer.escreve(new String(matriz[i]));
        }
        
        writer.fecha();
    }

    // método para Imprimir tabuleiro

    public static void imprimirTabuleiro(char matrizTabuleiro[][]) {
        System.out.println();
        System.out.println("   0    1    2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrizTabuleiro[i][j]);
                if (j < 2) {
                    System.out.print("  | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("   ------------");
            }
        }
    }

    
     //retorna 'M' se é uma letra maiúscula ou 'm' se é uma letra minúscula.     
    

    public static Character tipoLetra(Character letra) {
        char[] caracteresParaPreencherMatriz = {'!', '@', '#', '$', '%', '&', '*', '(', ')', '1', '2', '3', '4', '5'};
        Random random = new Random();
        int randomIndex = random.nextInt(caracteresParaPreencherMatriz.length);
        char randomChar = caracteresParaPreencherMatriz[randomIndex];

        if (letra == null) {
            return randomChar;
        }

        if (Character.isUpperCase(letra)) {
            return 'M';
        } else if (Character.isLowerCase(letra)) {
            return 'm';
        }
        return randomChar;
    }

    public static class Matriz {
        private char matrizClasse[][];

        public char[][] getMatriz() {
            return this.matrizClasse;
        }

        public Matriz(int numeroLinhas, int numeroColunas) {
            matrizClasse = new char[numeroLinhas][numeroColunas];
        }

        public void aplicaLetra(int linha, int coluna, char valor) {
            matrizClasse[linha][coluna] = valor;
        }

        public char obtemValor(int linha, int coluna) {
            return matrizClasse[linha][coluna];
        }

        public char[][] imprimeMatriz() {
            return matrizClasse;
        }

        public boolean fimDeJogo() {
            if (venceuNasLinhas(this.matrizClasse)) {
                return true;
            }
            if (venceuNasColunas(this.matrizClasse)) {
                return true;
            }
            if (venceuNasDiagonais(this.matrizClasse)) {
                return true;
            }
            return false;
        }

        public static boolean venceuNasLinhas(char[][] matriz) {
            for (int i=0; i < 3; i++) {
                Character tipoLetraPrimeiraColuna = tipoLetra(matriz[i][0]);
                Character tipoLetraSegundaColuna = tipoLetra(matriz[i][1]);
                Character tipoLetraTerceiraColuna = tipoLetra(matriz[i][2]);
                if (tipoLetraPrimeiraColuna.equals(tipoLetraSegundaColuna) && tipoLetraSegundaColuna.equals(tipoLetraTerceiraColuna)) {
                    System.out.println("Fim de jogo! Vencedor: ".concat(tipoLetraPrimeiraColuna.toString()));
                    return true;
                }
            }
            return false;
        }

        public static boolean venceuNasColunas(char[][] matriz) {
            for (int i=0; i < 3; i++) {
                Character tipoLetraPrimeiraLinha = tipoLetra(matriz[0][i]);
                Character tipoLetraSegundaLinha = tipoLetra(matriz[1][i]);
                Character tipoLetraTerceiraLinha = tipoLetra(matriz[2][i]);
                if (tipoLetraPrimeiraLinha.equals(tipoLetraSegundaLinha) && tipoLetraSegundaLinha.equals(tipoLetraTerceiraLinha)) {
                    System.out.println("Fim de jogo! Vencedor: ".concat(tipoLetraPrimeiraLinha.toString()));
                    return true;
                }
            }
            return false;
        }

        public static boolean venceuNasDiagonais(char[][] matriz) {
            if (tipoLetra(matriz[0][0]).equals(tipoLetra(matriz[1][1])) && tipoLetra(matriz[1][1]).equals(tipoLetra(matriz[2][2]))) {
                System.out.println("Fim de jogo! Vencedor: ".concat(tipoLetra(matriz[0][0]).toString()));
                return true;
            }
            if (tipoLetra(matriz[0][2]).equals(tipoLetra(matriz[1][1])) && tipoLetra(matriz[1][1]).equals(tipoLetra(matriz[2][0]))) {
                System.out.println("Fim de jogo! Vencedor: ".concat(tipoLetra(matriz[0][2]).toString()));
                return true;
            }
            return false;
        }
    }

    public static class EscritaArquivo {
        private BufferedWriter writer;

        public EscritaArquivo() {
            try {
                writer = new BufferedWriter(new FileWriter("save.txt", false));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void escreve(String texto) {
            try {
                writer.write(texto);
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void fecha() {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
