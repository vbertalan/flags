/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vithor G. Bertalan
 */

import java.util.ArrayList;
import java.util.List;

public class Neuronio {
    
    private int teta = 0; // threshold
    private List<Entrada> entradas = new ArrayList<Entrada>(); // vetor de entradas
    private Entrada b; // bias

    // construtor, inicia com bias 1
    public Neuronio() {
        b = new Entrada(1);
    }

    // adiciona um entrada ao neurônio
    public void addEntrada(Entrada lig) {
        entradas.add(lig);
    }

    // retorna o teta do neurônio
    public int getTeta() {
        return teta;
    }

    // modifica o teta do neurônio
    public void setTeta(int teta) {
        this.teta = teta;
    }

    // retorna a entrada com o bias do neurônio
    public Entrada getB() {
        return b;
    }

    // retorna a lista de entradas do neurônio
    public List<Entrada> getEntradas() {
        return entradas;
    }

    // modifica a lista de entradas do neurônio
    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    // retira as entradas do neurônio de um vetor de inteiros,
    // sendo cada posição do vetor uma entrada nova.
    public void retiraEntradas(int[] valores) {
        for (int i = 0; i < valores.length; i++) {
            Entrada nova = new Entrada(valores[i]);
            addEntrada(nova);
        }
    }
}

