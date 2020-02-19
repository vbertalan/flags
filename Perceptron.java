/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vithor G. Bertalan
 */
import java.util.LinkedList;
import java.util.List;

public class Perceptron {

    static List<Neuronio> neuronios = new LinkedList<Neuronio>(); // vetor de neurônios
    static List<Integer> saidas = new LinkedList<Integer>(); // vetor de saídas esperadas
    static Neuronio saida = new Neuronio(); // neurônio de saída
    static float alfa = 1; // taxa de aprendizagem, inicia a 1
    static int iteracoes = 0; // contador de iterações

    // inicia neurônio de saída com 7 entradas de peso e valor 0
    static public void iniciaNeuronio() {
        for (int i = 0; i < 7; i++) {
            Entrada nova = new Entrada(0, 0);
            saida.addEntrada(nova);
        }
    }

    // executa o algoritmo do Perceptron
    public static void fazTreinamento() {

        float totalTemp = 0;
        float valorNeuronio = 0;
        float saidaNova = 0;
        float saidaVelha = 0;
        float biasNovo = 0;
        float y_in = 0;
        int y = 0;
        boolean mudouPesos = false;

        do {      
            mudouPesos = false; // supõe que os pesos não mudaram
            
            // faz o treinamento para cada neurônio no vetor de treinamento
            for (int i = 0; i < neuronios.size(); i++) {

                // calcula o somatório entre as entradas novas 
                // e os valores do neurônio de saída
                for (int j = 0; j < 7; j++) {
                    valorNeuronio = neuronios.get(i).getEntradas().get(j).getValor();
                    totalTemp += valorNeuronio * saida.getEntradas().get(j).getValor();
                }

                // soma o somatório total com o bias do neurônio de saída
                y_in = neuronios.get(i).getB().getValor() + totalTemp;

                // calcula y
                if (y_in > saida.getTeta()) {
                    y = 1;
                } else if (y_in < saida.getTeta()) {
                    y = -1;
                } else {
                    y = 0;
                }

                // atualiza pesos e bias se ocorreram erros no padrão
                if (y != saidas.get(i)) {

                    // atualiza pesos
                    for (int z = 0; z < 7; z++) {
                        saidaVelha = saida.getEntradas().get(z).getValor();
                        // wz(novo) = wz(velho) + α*t*xz
                        saidaNova = saidaVelha + alfa * saidas.get(i) *
                                neuronios.get(i).getEntradas().get(z).getValor();
                        saida.getEntradas().get(z).setValor(saidaNova);
                           
                        // se os pesos mudaram, reafirma a mudança
                        if (saidaVelha != saidaNova) mudouPesos = true;
                    }

                    // atualiza bias
                    biasNovo = saida.getB().getValor();
                    biasNovo += alfa * saidas.get(i);
                    saida.getB().setValor(biasNovo);                   
                }
            }

            // imprime o número da iteração, o alfa e os pesos do neurônio de saída
            System.out.println("ITERAÇÃO " + ++iteracoes + ", com ALFA = " + alfa);
            for (int w = 0; w < 7; w++) 
                System.out.println("Peso " + w + ": " + saida.getEntradas().get(w).getValor());
            System.out.println("\n");
            
             // divide o alfa por 2
            alfa /= 2;
                   
        } 
        // testa a condição de parada
        while (mudouPesos);
    }

    // executável do Perceptron
    public static void main(String[] args) {
        iniciaNeuronio();
        Insercoes.defineEntradas(neuronios);
        Insercoes.defineSaidas(saidas);
        fazTreinamento();
    }
}
