import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class PlanoPanel extends Canvas {

	private static final long serialVersionUID = -6836672619062830798L;

	public static final double ESCALA = 30.0;

	private Punto origen;
	private Poligono poligono;

	public PlanoPanel() {
		super.setBackground(Color.BLACK);
		
		this.origen = new Punto();
		this.poligono = new Poligono();
	}

	public Poligono getPoligono() {
		return poligono;
	}

	public void dibujarPoligono(Poligono f) {
		Graphics g = super.getGraphics();
		g.setColor(Color.green);
		
		for (Linea lados : f.getLados()) {
			g.drawLine( (int)(lados.getA().getX() * ESCALA + origen.getX()), (int)(-lados.getA().getY() * ESCALA + origen.getY()), 
						(int)(lados.getB().getX() * ESCALA + origen.getX()), (int)(-lados.getB().getY() * ESCALA + origen.getY()));
		}
		

		this.poligono = f;
	}

	@Override
	public void paint(Graphics g) {
		this.origen = new Punto(getWidth() / 2, getHeight() / 2);
		
	    dibujarAsintotas(g);
		dibujarEscala(g);
		
		dibujarPoligono(poligono);
	}

	private void dibujarAsintotas(Graphics g) {
		Linea ejeX = new Linea(new Punto(0, getHeight() / 2), new Punto(getWidth(), getHeight() / 2));
		Linea ejeY = new Linea(new Punto(getWidth() / 2, 0),  new Punto(getWidth() / 2, getHeight()));

		g.drawLine((int) ejeX.getA().getX(), (int) ejeX.getA().getY(), (int) ejeX.getB().getX(), (int) ejeX.getB().getY());
		g.drawLine((int) ejeY.getA().getX(), (int) ejeY.getA().getY(), (int) ejeY.getB().getX(), (int) ejeY.getB().getY());
	}
	
	
	private void dibujarEscala(Graphics g) {
		for (int i = (int)origen.getX(); i < getWidth(); i += ESCALA) {
			g.drawLine(i, (int)origen.getY() + 5, i, (int)origen.getY() - 5);
		}

		for (int i = (int)origen.getX(); i > 0; i -= ESCALA) {
			g.drawLine(i, (int)origen.getY() + 5, i, (int)origen.getY() - 5);
		}

		for (int i = (int)origen.getY(); i < getHeight(); i += ESCALA) {
			g.drawLine((int)origen.getX() + 5, i, (int)origen.getX() - 5, i);
		}

		for (int i = (int)origen.getY(); i > 0; i -= ESCALA) {
			g.drawLine((int)origen.getX() + 5, i, (int)origen.getX() - 5, i);
		}
	}

	public Punto getOrigen() {
		return origen;
	}
}