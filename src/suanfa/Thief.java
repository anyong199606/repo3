package suanfa;

/**
 * A说：“我不是小偷。”    x !=0
 * B说：“C 是小偷。”     x = 2
 * C说：“小偷肯定是 D。”  x = 3  !
 * D说：“C 是在冤枉人。”  x != 3
 */
public class Thief {
    public static void main(String[] args) {
        whoIsThief();
    }

    public static void whoIsThief() {
        for (int x = 0; x < 4; x++) {
            int dis_a = (x != 0) ? 1 : 0;
            int dis_b = (x == 2) ? 1 : 0;
            int dis_c = (x == 3) ? 1 : 0;
            int dis_d = 1 - dis_c;
            if (dis_a + dis_b + dis_c + dis_d == 3) {
                System.out.println("小偷是:" + x);
                break;
            }
        }
    }
}
