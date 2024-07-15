import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JPanel;

public class ControladorMovimento extends Thread {
	// Propriedades da classe
	private ArrayList<Bola> colecao = new ArrayList<Bola>();
	private JPanel objPainel = new JPanel();
	
	// Método construtor cheio da classe
	public ControladorMovimento(ArrayList<Bola> colecao, JPanel objPainel) {
		super();
		this.colecao = colecao;
		this.objPainel = objPainel;
	}
	
	// Método sobrescrito de execução paralela da classe
	public void run() {
		while (true) {
			// Posicionamento das bolas
			for (Bola objBola : colecao) {
				objBola.setX(objBola.getX() + objBola.getDx());
				objBola.setY(objBola.getY() + objBola.getDy());
				
				if ((objBola.getX() < 0) || 
					(objBola.getX() > (objPainel.getSize().getWidth()-
									   objBola.getTamanho()))) {
					objBola.setDx(-objBola.getDx());
				}
				
				if ((objBola.getY() < 0) || 
					(objBola.getY() > (objPainel.getSize().getHeight()-
									   objBola.getTamanho()))) {
					objBola.setDy(-objBola.getDy());
				}
			}
			
			objPainel.repaint();
			
			try {sleep(40);} catch (Exception e) {}
			
			// Colisão das bolas
			int segundoAtual =
						Calendar.getInstance().get(Calendar.SECOND);

			if (segundoAtual < (Janela.segundoInicial + 10)) {
				continue;
			}
			for (Bola objBola1 : colecao) {
				for (Bola objBola2 : colecao) {
					if ((! objBola1.equals(objBola2)) &&
						((objBola1.getX() -
						  objBola1.getTamanho()) < objBola2.getX()) &&
						((objBola1.getX() +
						  objBola1.getTamanho()) > objBola2.getX()) &&
						
						((objBola1.getY() -
						  objBola1.getTamanho()) < objBola2.getY()) &&
						((objBola1.getY() +
						  objBola1.getTamanho()) > objBola2.getY())){

						objBola1.setTamanho(95 * objBola1.getTamanho()/100);
						objBola1.setX(-objBola1.getX());
						objBola2.setTamanho(95 * objBola2.getTamanho()/100);
						objBola2.setX(-objBola2.getX());
					}
				}
			}
		}
	}
}