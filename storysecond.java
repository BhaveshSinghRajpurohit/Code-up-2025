
import java.util.*;

public class storysecond {

    // 1. Count trend windows
    public static int countTrendWindows(List<Integer> data, int window) {
        int total = 0;

        for (int start = 0; start <= data.size() - window; start++) {
            List<Integer> freqList = new ArrayList<>();

            for (int i = start; i < start + window; i++) {
                int f = 0;
                for (int j = i; j < start + window; j++) {
                    if (data.get(i).equals(data.get(j))) {
                        f++;
                    }
                }
                freqList.add(f);
            }

            int maxFreq = 0;
            for (int val : freqList) {
                if (val > maxFreq) {
                    maxFreq = val;
                }
            }

            int maxCount = 0;
            for (int val : freqList) {
                if (val == maxFreq) {
                    maxCount++;
                }
            }

            if (maxCount == 1) {
                total++;
            }
        }

        return total;
    }

    // 2. Longest balanced array of 1 and 2
    public static int findBalancedLength(List<Integer> arr) {
        int answer = 0;

        for (int i = 0; i < arr.size(); i++) {
            int c1 = 0;
            int c2 = 0;

            for (int j = i; j < arr.size(); j++) {
                if (arr.get(j) == 1) c1++;
                else if (arr.get(j) == 2) c2++;

                if (c1 == c2) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }
        return answer;
    }

    // 3. Pair sum without reuse
    public static int findPairCount(List<Integer> arr, int target) {
        boolean used[] = new boolean[arr.size()];
        int pairCount = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (used[i]) continue;

            for (int j = i + 1; j < arr.size(); j++) {
                if (used[j]) continue;

                if (arr.get(i) + arr.get(j) == target) {
                    used[i] = true;
                    used[j] = true;
                    pairCount++;
                    System.out.println("Pair: " + i + " and " + j);
                    break;
                }
            }
        }
        return pairCount;
    }

    // 4. Scrambled substring checker
    public static boolean checkScramble(String big, String small) {
        int n = big.length();
        int m = small.length();

        int[] need = new int[26];
        for (int i = 0; i < m; i++) {
            need[small.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= n - m; i++) {
            int[] temp = new int[26];

            for (int j = i; j < i + m; j++) {
                temp[big.charAt(j) - 'a']++;
            }

            if (Arrays.equals(need, temp)) return true;
        }
        return false;
    }

    // 5. Most repeated path
    public static String getTopPath(List<String> logs) {

        boolean mark[] = new boolean[logs.size()];
        List<String> allPaths = new ArrayList<>();

        for (int i = 0; i < logs.size(); i++) {
            if (mark[i]) continue;

            String userId = logs.get(i).substring(0, 2);
            String prev = "";

            for (int j = i; j < logs.size(); j++) {
                if (mark[j]) continue;

                String checkUser = logs.get(j).substring(0, 2);
                String action = logs.get(j).substring(2);
                String shortPath = logs.get(j).substring(4);

                if (userId.equals(checkUser)) {
                    if (!prev.equals("")) {
                        prev = prev + action;
                        allPaths.add(prev);
                    }

                    prev = shortPath;
                    mark[j] = true;
                }
            }
        }

        int n = allPaths.size();
        int max = 0;
        int[] freq = new int[n];
        boolean used[] = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;

            int count = 0;
            for (int j = i; j < n; j++) {
                if (!used[j] && allPaths.get(i).equals(allPaths.get(j))) {
                    count++;
                    used[j] = true;
                }
            }

            freq[i] = count;
            if (count > max) max = count;
        }

        String best = "~~~~~~~~~~~"; // big string
        for (int i = 0; i < n; i++) {
            if (freq[i] == max && allPaths.get(i).compareTo(best) < 0) {
                best = allPaths.get(i);
            }
        }

        return best;
    }

    // Main method
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\nChoose Option:");
            System.out.println("1 -> Trend Window");
            System.out.println("2 -> Balanced Subarray");
            System.out.println("3 -> Pair Sum");
            System.out.println("4 -> Scrambled Substring");
            System.out.println("5 -> Most Frequent Path");
            System.out.println("0 -> Exit");

            char ch = input.next().charAt(0);

            switch (ch) {
                case '1':
                    System.out.println("Enter n and window:");
                    int n = input.nextInt();
                    int w = input.nextInt();

                    List<Integer> list1 = new ArrayList<>();
                    System.out.println("Enter numbers:");
                    for (int i = 0; i < n; i++) list1.add(input.nextInt());

                    System.out.println("Trend Count = " + countTrendWindows(list1, w));
                    break;

                case '2':
                    System.out.println("Enter size:");
                    int n2 = input.nextInt();

                    List<Integer> list2 = new ArrayList<>();
                    System.out.println("Enter numbers:");
                    for (int i = 0; i < n2; i++) list2.add(input.nextInt());

                    System.out.println("Longest Balanced Length = " + findBalancedLength(list2));
                    break;

                case '3':
                    System.out.println("Enter size and target:");
                    int s3 = input.nextInt();
                    int k = input.nextInt();

                    List<Integer> list3 = new ArrayList<>();
                    System.out.println("Enter numbers:");
                    for (int i = 0; i < s3; i++) list3.add(input.nextInt());

                    System.out.println("Total Pairs = " + findPairCount(list3, k));
                    break;

                case '4':
                    System.out.println("Enter full string:");
                    String big = input.next();

                    System.out.println("Enter small string:");
                    String small = input.next();

                    if (checkScramble(big, small))
                        System.out.println("Yes, scrambled match found");
                    else
                        System.out.println("No scrambled match");

                    break;

                case '5':
                    System.out.println("Enter number of records:");
                    int size = input.nextInt();
                    input.nextLine();

                    List<String> logList = new ArrayList<>();
                    System.out.println("Enter records:");
                    for (int i = 0; i < size; i++) {
                        logList.add(input.nextLine());
                    }

                    System.out.println("Most used path = " + getTopPath(logList));
                    break;

                case '0':
                    run = false;
                    break;

                default:
                    System.out.println("Wrong choice!");
            }
        }

        System.out.println("Program finished...");
        input.close();
    }
}

