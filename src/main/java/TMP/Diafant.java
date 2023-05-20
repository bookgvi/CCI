package TMP;

public class Diafant {
    /**
     * Вычисление НОД
     * @param a - целое число
     * @param b - целое число
     * @return - НОД
     */
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * a * x + b * y = g
     * Пусть есть g = (b % a) * x1 + a * y1
     * тогда
     * a * x + b * y = (b % a) * x1 + a * y1
     * b % a = b - (b / a) * a;
     * b * x1 + a * (y1 - (b / a) * x1) = g;
     * @param a - целое число
     * @param b - целое число
     * @return int[], где [0] - НОД, [1] - a, [2] - b
     */
    public int[] diafant(int a, int b) {
        int[] res = new int[3];
        if (a == 0) {
            res[0] = b; // gcd
            res[2] = 1;
            return res;
        }
        res = diafant(b % a, a);
        int tmp = res[1];
        res[1] = res[2] - (b / a) * res[1];
        res[2] = tmp;
        return res;
    }

    /**
     * Вычисление НОК
     * @param a - целое число
     * @param b - целое число
     * @return - НОК
     */
    public int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return Math.abs(a * b) / gcd;
    }

    /**
     * Вычисление А и В по НОД и НОК (A + B = gcd(A, B))
     * @param gcd - НОД
     * @param lcm - НОК
     * @return - int[] - [0] - A, [1] - B
     */
    public int[] getAB(int gcd, int lcm) {
        int[] res = new int[2];
//        int a = gcd - b;
//        lcm * gcd / a = b;
//        a = gcd - lcm * gcd / a;
        return res;
    }
}
