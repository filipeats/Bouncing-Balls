import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Painel extends JPanel {
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	private ArrayList<Bola> colecao = new ArrayList<Bola>();

	// Método construtor cheio da classe
	public Painel(ArrayList<Bola> colecao) {
		super();
		this.colecao = colecao;
	}
	
	// Método sobrescrito de desenho
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (Bola objBola : colecao) {
			g.setColor(objBola.getCor());
			g.fillOval(objBola.getX(),
					   objBola.getY(),
					   objBola.getTamanho(),
					   objBola.getTamanho());
		}
	}
}