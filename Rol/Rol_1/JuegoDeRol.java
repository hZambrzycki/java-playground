
public class JuegoDeRol {

	public JuegoDeRol() {

	}

	public static void main(String[] args) {
		Personaje[] personajes = new Personaje[3];

		personajes[0] = new Mago("Gnomo Ilusionista", "Gnomo", 1, 10, 100, 100, 3, null);

		personajes[1] = new Mago("Elfo Guerrero", "Elfo", 5, 10, 100, 100, 1, null);
		
	/*	try {
			personajes[1] = new Mago("Elfo Guerrero", "Elfo", 5, 9, 100, 100, 1, null);
		} catch (MagoException me) {
			if (me.getTipo() == 1) {
				System.err.println(me.getMessage() + "Se ajustara la inteligencia al valor minimo");
				personajes[1] = new Mago("Elfo Guerrero", "Elfo", 5, 10, 100, 100, 1, null);
			} else if (me.getTipo() == 2) {
				personajes[1] = new Mago("Elfo Guerrero", "Elfo", 5, 10, 100, 100, 1, null);
				System.err.println(me.getMessage() + "Se ajustara la fuerza al valor maximo");
			}

			me.printStackTrace();
		}*/
		
		
		personajes[2] = new Clerigo("Chaman", "Tauren", 2, 15, 200, 200, "Dios Sol");

		System.out.println(personajes[0].toString());
		System.out.println(personajes[1].toString());

		Hechizo fuego = crearHechizo("Fuego", 10);
		Hechizo tierra = crearHechizo("Tierra", 20);
		Hechizo aire = crearHechizo("Aire", 30);
		Hechizo agua = crearHechizo("Agua", 30);

		((Mago) personajes[0]).aprendeHechizo(fuego);
		((Mago) personajes[0]).aprendeHechizo(tierra);
		((Mago) personajes[0]).aprendeHechizo(aire);
		System.out.println(personajes[0].toString());

		((Mago) personajes[1]).aprendeHechizo(agua);
		System.out.println(personajes[1].toString());

		try {
			((Mago) personajes[0]).lanzaHechizo(personajes[1], tierra);
		} catch (HechizoException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

		try {
			((Mago) personajes[1]).lanzaHechizo(personajes[0]);
		} catch (HechizoException e1) {
			System.err.println(e1.getMessage());
			e1.printStackTrace();
		}

		((Clerigo) personajes[2]).curar(personajes[1]);

		try {
			((Mago) personajes[0]).lanzaHechizo(personajes[1], aire);
		} catch (HechizoException e2) {
			System.err.println(e2.getMessage());
			e2.printStackTrace();
		}

		System.out.println("/***************************************************************/");

		System.out.println(personajes[0].toString());
		System.out.println(personajes[1].toString());
		System.out.println(personajes[2].toString());

	}

	public static Hechizo crearHechizo(String tipo, int potencia) {
		return new Hechizo(tipo, potencia);
	}

}
