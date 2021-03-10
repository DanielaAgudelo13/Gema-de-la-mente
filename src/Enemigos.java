import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Enemigos {

	int posX;
	int posY;
	int vida;
	int ancho;
	int alto;
	int tipo;
	PImage thanos;
	PImage zombie;
	PImage veneno;
	PImage gema;
	PApplet app;

	ArrayList<Balas> balas = new ArrayList<Balas>();

	public Enemigos(int posX, int posY, int vida, int tipo, PImage thanos, PImage zombie, PImage veneno, PImage gema,
			PApplet app) {

		// Variables constructor

		this.posX = posX;
		this.posY = posY;
		this.vida = vida;
		this.thanos = thanos;
		this.zombie = zombie;
		this.veneno = veneno;
		this.gema = gema;
		this.app = app;
		this.ancho = 80;
		this.alto = 120;
		this.tipo = tipo;

	}

	public void pintar() {

		mover();
		disparar();

		switch (this.tipo) {

		case 0:

			app.image(thanos, posX, posY, ancho, alto);

			break;

		case 1:

			app.image(zombie, posX, posY, ancho, alto);

			break;

		}

		for (int i = 0; i < balas.size(); i++) {

			balas.get(i).pintar();
		}

		for (int i = 0; i < balas.size(); i++) {

			if (balas.get(i).posX < 0) {
				balas.remove(i);
			}
		}
	}

	public void mover() {

		posX -= 2;
	}

	public void disparar() {

		if (app.frameCount % 60 == 0) {

			if (this.tipo == 0) {

				balas.add(new Balas(this.posX, this.posY + 20, 80, 80, 2, this.app));

			}

			else {

				balas.add(new Balas(this.posX, this.posY + 20, 80, 80, 3, this.app));
			}

		}
	}
}
