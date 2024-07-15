import java.awt.Color;

public class Bola {
	// Propriedades da classe
	private int x = 0;
	private int y = 0;
	private int dx = 0;
	private int dy = 0;
	private int tamanho = 0;
	private Color cor = null;
	
	// Método construtor da classe
	public Bola() {
		dx = ((int) (16 * Math.random()));
		dy = ((int) (16 * Math.random()));
		
		tamanho = (10 + ((int) (100 * Math.random())));
		
		int vermelho = ((int) (256 * Math.random()));
		int verde = ((int) (256 * Math.random()));
		int azul = ((int) (256 * Math.random()));
		cor = new Color(vermelho, verde, azul);
	}

	// Métodos get/set da classe
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public Color getCor() {
		return cor;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}
}