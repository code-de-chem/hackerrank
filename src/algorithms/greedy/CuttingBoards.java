package algorithms.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Saurabh Singh
 */
public class CuttingBoards {

    static final long MOD = (long) Math.pow(10, 9) + 7;

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int t = in.nextInt();
            while (t > 0) {
                t--;
                long m = in.nextLong();
                long n = in.nextLong();
                long h = 1, w = 1;
                PriorityQueue<Long> queueH = new PriorityQueue<>(new Comparator<Long>() {
                    @Override
                    public int compare(Long l1, Long l2) {
                        if (l1 < l2) {
                            return 1;
                        } else if (l1 > l2) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                PriorityQueue<Long> queueW = new PriorityQueue<>(new Comparator<Long>() {
                    @Override
                    public int compare(Long l1, Long l2) {
                        if (l1 < l2) {
                            return 1;
                        } else if (l1 > l2) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                for (int i = 0; i < m - 1; i++) {
                    queueH.add(in.nextLong());
                }
                for (int i = 0; i < n - 1; i++) {
                    queueW.add(in.nextLong());
                }
                long sum = 0;
                for (long i = 0; i < m + n - 2; i++) {
                    if (!queueH.isEmpty() && !queueW.isEmpty()) {
                        if (queueH.peek() > queueW.peek()) {
                            sum += queueH.poll() % MOD * w % MOD;
                            sum %= MOD;
                            h++;
                        } else if (queueH.peek() < queueW.peek()) {
                            sum += queueW.poll() % MOD * h % MOD;
                            sum %= MOD;
                            w++;
                        } else{
                            if (queueH.peek()%MOD * w%MOD > queueW.peek()%MOD * h%MOD) {
                                sum += queueW.poll() % MOD * h % MOD;
                                sum %= MOD;
                                w++;
                            } else {
                                sum += queueH.poll() % MOD * w % MOD;
                                sum %= MOD;
                                h++;
                            }
                        }
                    } else if (!queueW.isEmpty()) {
                        sum += queueW.poll() % MOD * h % MOD;
                        sum %= MOD;
                        w++;
                    } else {
                        sum += queueH.poll() % MOD * w % MOD;
                        sum %= MOD;
                        h++;
                    }
                }
                System.out.println(sum%MOD);
            }
        }
    }
}
