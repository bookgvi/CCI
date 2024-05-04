package TMP.leetcode;

public class BoatsSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        final int MAX_PEOPLE = (int) 5e4;
        int peoples[] = new int[MAX_PEOPLE + 1];
        int res = 0;
        for (int p : people) {
            peoples[p] += 1;
        }
        for (int i = MAX_PEOPLE; i > 0; --i) {
            while (peoples[i] > 0) {
                --peoples[i];
                int rem = limit - i;
                while (rem > 0) {
                    if (peoples[rem] > 0) {
                        --peoples[rem];
                        break;
                    }
                    --rem;
                }
                res += 1;
            }
        }
        return res;
    }
}
