import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Ventana extends JFrame {

	private static final long serialVersionUID = -4601737718372115147L;

	private PlanoPanel plano;

	public Ventana() {
		super("SIMULACION SO");
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BorderLayout());
		super.setSize(980, 720);
		super.setResizable(false);
		super.setFont(new Font("Monospaced", Font.PLAIN, 20));

		this.plano = new PlanoPanel();
		super.add(plano, BorderLayout.CENTER);
		
		super.setBackground(Color.black);

		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}

	public void iniciarTriangulo() {
		Punto a = new Punto(2, 1);
		Punto b = new Punto(4, 3);
		Punto c = new Punto(6, 1);
		Punto d = new Punto(4, 6);

		Linea ab = new Linea(a, b);
		Linea bc = new Linea(b, c);
		Linea cd = new Linea(c, d);
		Linea da = new Linea(d, a);

		ArrayList<Linea> lados = new ArrayList<>();
		lados.add(ab);
		lados.add(bc);
		lados.add(cd);
		lados.add(da);

		Poligono p = new Poligono(lados);
		plano.dibujarPoligono(p);
	}

	public void animar() {
		Thread hilo = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					Poligono p = plano.getPoligono();

					for(int i = 0; i < 100; i++) {
						Punto t = new Punto(-i*0.1, 0);

						Poligono p2 = p.transladar(t);

						plano.dibujarPoligono(p2);
						
						try {
							Thread.sleep(50);
							plano.repaint();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					p = plano.getPoligono();
					for(int i = 0; i < 100; i++) {
						Punto t = new Punto(0, i*0.1);

						Poligono p2 = p.transladar(t);

						plano.dibujarPoligono(p2);
						try {
							Thread.sleep(50);
							plano.repaint();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					p = plano.getPoligono();
					for(int i = 0; i < 100; i++) {
						Punto t = new Punto(i*0.1, 0);

						Poligono p2 = p.transladar(t);

						plano.dibujarPoligono(p2);
						try {
							Thread.sleep(50);
							plano.repaint();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					p = plano.getPoligono();
					for(int i = 0; i < 100; i++) {
						Punto t = new Punto(0, -i*0.1);

						Poligono p2 = p.transladar(t);

						plano.dibujarPoligono(p2);
						try {
							Thread.sleep(50);
							plano.repaint();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});

		hilo.start();

	}



}