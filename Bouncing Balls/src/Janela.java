import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame {
	// Constantes da classe
	public static final int segundoInicial =
						Calendar.getInstance().get(Calendar.SECOND);
	
	// Propriedades da classe
	private static final long serialVersionUID = 1L;
	private ArrayList<Bola> colecao = new ArrayList<Bola>();
	private Painel objPainel = new Painel(colecao);
	private JButton btnOk = new JButton("Ok");
	
	// Método principal de execução da classe
	public static void main(String[] args) {
		new Janela().setVisible(true);
	}
	
	// Método construtor da classe
	public Janela() {
		// Configuração da janela
		setTitle("!!! Java Bouncing Balls !!!");
		setSize(800, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// Configuração do painel
		objPainel.setLayout(null);
		setContentPane(objPainel);
		
		// Configuração da thread
		new ControladorMovimento(colecao, objPainel).start();
		
		// Configuração do botão
		btnOk.setBounds(370, 720, 50, 20);
		objPainel.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colecao.add(new Bola());
			}
		});
	}
}