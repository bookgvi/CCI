package TMP;

public class Pizza {
}

class ChickenBBQ extends Pizza {

    private static final int[] radiusArr = new int[]{23, 30, 35, 40};
    private static final int[] costs = new int[]{499, 729, 899, 1069};

    public static void main(String[] args) {
        calculate(radiusArr, costs);
    }

    public static void calculate(int[] radiusArr, int[] costs) {
        int len = radiusArr.length;
        double[] squares = new double[len];
        double[] oneSquareQuantitys = new double[len];
        for (int i = 0; i < len; i += 1) {
            double square = Math.PI * pow(radiusArr[i], 2);
            double cost = costs[i] / square;
            squares[i] = square;
            oneSquareQuantitys[i] = cost;
        }

        for (int i = 0; i < len; i += 1) {
            System.out.printf("Пицца радиусом %d см стоит %d рублей.\t Площадь = %.2f кв. см, стоимость 1 кв. см равна %.2f руб.\t" +
                            "Расчетная стоимость равна %.2f руб.\n",
                    radiusArr[i], costs[i], squares[i], oneSquareQuantitys[i], squares[i] * oneSquareQuantitys[i]);
        }
    }

    private static double pow(int num, int pow) {
        double res = 1;
        while (pow > 0) {
            if ((pow & 1) == 1) {
                res *= num;
            }
            num *= num;
            pow >>= 1;
        }
        return res;
    }
}
