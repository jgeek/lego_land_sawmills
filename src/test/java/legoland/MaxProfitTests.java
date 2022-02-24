package legoland;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import logoland.MaxFinder;
import logoland.TrunksProfitCalculator;
import org.junit.Assert;
import org.junit.Test;

public class MaxProfitTests {

    @Test
    public void maxProfitOf1_2_3() {
        List<Integer> trunks = new ArrayList<>();
        trunks.add(1);
        trunks.add(2);
        trunks.add(3);
        var list = new MaxFinder(trunks).find();
        Assert.assertTrue(list.contains(List.of(1, 3, 2)));
        Assert.assertTrue(list.contains(List.of(2, 3, 1)));
    }
}
