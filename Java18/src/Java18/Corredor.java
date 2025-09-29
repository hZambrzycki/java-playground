/**
 *
 * @author hz
 */
public class Corredor {

    private static final int ENERGIA_MAX = 100;
    private static final int ENERGIA_MIN = 0;

    private int energia;

    public Corredor(int energia) {
        this.energia = verificarEnergia(energia);
    }

    public int verificarEnergia(int energia) {
        if (energia < ENERGIA_MIN) {
            System.out.println("La energia debe ser al menos 0");
            return 0;
        } else if (energia > ENERGIA_MAX) {
            return 100;
        } else {
            return energia;
        }
    }

    public void recargarEnergia(int energia) {
        this.energia += energia;
    }

    public void correr() {
        if (energiaAgotada()) {
            this.energia = 0;
            System.out.println("Energía del corredor agotada, energía actual= " + this.energia);
        } else {
            this.energia -= 10;
        }
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public boolean energiaAgotada() {
        if (this.energia < 10) {
            return true;
        } else {
            return false;
        }
    }

    public void entrenar() {
        if (this.energia + 15 > 100) {
            this.energia = 100;
        } else {
            this.energia += 15;
        }
    }

}
