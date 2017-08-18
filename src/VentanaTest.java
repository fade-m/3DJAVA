import javax.swing.SwingUtilities;

public class VentanaTest {

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Ventana v = new Ventana();
				v.iniciarTriangulo();
				v.animar();
			}
			
		});
	}
	
}