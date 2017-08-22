import java.util.Random;

/**
 * @author 张红杰 13022800618
 * @version 1.0, 2017.8.10 20:07
 */
public class demo {

	public static void main(String[] args) {
		for (int i = 0; i < 30; i++) {
			Random random = new Random();
			int q = random.nextInt(500);
			System.out.println(q);
		}
	}
}
