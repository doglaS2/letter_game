package models;

import java.util.Random;

public class Matriz {
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

    private static Character tipoLetra(Character letra) {
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
} 