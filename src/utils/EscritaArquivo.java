package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritaArquivo {
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