import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

public class GeneratePrimesBenchmarkTest {

    @Test
    public void GivenMaxValue_IsTen() {
        int[] actualPrimes = GeneratePrimes.generatePrimes(10);
        Assert.assertArrayEquals(new int[]{2, 3, 5, 7}, actualPrimes);
    }

    @Test
    public void GivenMaxValue_Is100() {
        int[] actualPrimes = GeneratePrimes.generatePrimes(100);
        System.out.println(new Gson().toJson(actualPrimes));
        Assert.assertArrayEquals(
                new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97},
                actualPrimes);
    }
}