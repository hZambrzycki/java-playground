import java.util.Random;

/**
 *
 * @author hz
 */
public class randomNumber {

    Random rd = new Random();

    int x = rd.nextInt(999);

    public int getX() {

        return x;

    }

}
