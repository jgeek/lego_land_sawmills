package legoland;

import java.util.ArrayList;
import java.util.List;
import logoland.TrunksProfitCalculator;
import org.junit.Assert;
import org.junit.Test;

public class BasicTests {

    @Test
    public void test2_3_1() {
        List<Integer> trunks = new ArrayList<>();
        trunks.add(2);
        trunks.add(3);
        trunks.add(1);
        TrunksProfitCalculator calculator = new TrunksProfitCalculator(new ArrayList<>(trunks));
        int profit = calculator.calculate();
        Assert.assertEquals(4, profit);
    }

    @Test
    public void test1_4() {
        List<Integer> trunks = new ArrayList<>();
        trunks.add(1);
        trunks.add(4);
        TrunksProfitCalculator calculator = new TrunksProfitCalculator(new ArrayList<>(trunks));
        int profit = calculator.calculate();
        Assert.assertEquals(5, profit);
    }
}
