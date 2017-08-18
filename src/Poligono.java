

import java.util.ArrayList;

public class Poligono implements Matriz {

	private Punto origen;
	private ArrayList<Linea> lados;
	
	public Poligono() {
		this.lados = new ArrayList<>();
		this.origen = new Punto();
	}
	
	
	public Poligono(ArrayList<Linea> lados) {
		this.lados = lados;
		this.origen = new Punto();
	}

	public Punto getOrigen() {
		return origen;
	}

	public void setOrigen(Punto origen) {
		this.origen = origen;
	}

	public ArrayList<Linea> getLados() {
		return lados;
	}

	public void addLado(Linea lado) {
		this.lados.add(lado);
	}


	@Override
	public Poligono transladar(Punto punto) {
		Poligono nueva = new Poligono();

		for (Linea l : this.getLados()) {
			nueva.addLado(new Linea(Punto.sumar(l.getA(), punto), Punto.sumar(l.getB(), punto)));
		}

		nueva.setOrigen(Punto.sumar(getOrigen(), new Punto(punto.getX() * PlanoPanel.ESCALA, punto.getY() * PlanoPanel.ESCALA)));
		return nueva;
	}

}