import java.util.ArrayList;
import java.util.List;

public class LogoLand {

    public static void main(String[] args) {

        List<Integer> trunks = new ArrayList<>();
        trunks.add(1);
        trunks.add(4);
        // trunks.add(2);
        // trunks.add(3);

        TrunksProfitCalculator calculator = new TrunksProfitCalculator(new ArrayList<>(trunks));
        int profit = calculator.calculate();
        System.out.println(profit);

    }
}
