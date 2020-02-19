/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vithor G. Bertalan
 */

public class Entrada {

	private float peso; // peso da entrada
	private float valor; // valor da entrada

        // construtor de entrada, inicia com um valor
        public Entrada (float valorNovo) {
            valor = valorNovo;
        }
        
        // construtor de entrada, inicia com um valor e um peso
        public Entrada (float valorNovo, float pesoNovo) {
            valor = valorNovo;
            peso = pesoNovo;
        }
        
        // retorna o peso
	public float getPeso() {
		return peso;
	}
        
        // retorna o valor
	public float getValor() {
		return valor;
	}
        
        // modifica o peso
	public void setPeso(float peso) {
		this.peso = peso;
	}
        
        // modifica o valor
	public void setValor(float valor) {
		this.valor = valor;
	}
}

