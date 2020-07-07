import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int v = 0;
            int f = 0;
            Map<Character, Integer> mapA = new TreeMap<>();
            Map<Character, Integer> mapB = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                char a = sc.next().charAt(0);
                char b = sc.next().charAt(0);
                int re = match(a, b);
                if (re == 1) {
                    v++;
                    if (mapA.containsKey(a)) {
                        mapA.put(a, mapA.get(a) + 1);
                    } else {
                        mapA.put(a, 1);
                    }
 
                } else if (re == -1) {
                    f++;
                    if (mapB.containsKey(b)) {
                        mapB.put(b, mapB.get(b) + 1);
                    } else {
                        mapB.put(b, 1);
                    }
                }
            }
            System.out.println(v + " " + (n - v - f) + " " + f);
            System.out.println(f + " " + (n - v - f) + " " + v);
            int max = 0;
            for (Map.Entry<Character, Integer> m : mapA.entrySet()) {
                if (m.getValue() > max) {
                    max = m.getValue();
                }
            }
            if (max == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<Character, Integer> m : mapA.entrySet()) {
                    if (m.getValue() == max) {
                        System.out.print(m.getKey());
                        break;
                    }
                }
            }
            max = 0;
            System.out.print(" ");
            for (Map.Entry<Character, Integer> m : mapB.entrySet()) {
                if (m.getValue() > max) {
                    max = m.getValue();
                }
            }
            if (max == 0) {
                System.out.print("B");
            } else {
                for (Map.Entry<Character, Integer> m : mapB.entrySet()) {
                    if (m.getValue() == max) {
                        System.out.print(m.getKey());
                        break;
                    }
                }
            }
        }
    }
 
    public static int match(char a, char b) {
        if (a == b) {
            return 0;
        } else if ((a == 'C' && b == 'J') || (a == 'J' && b == 'B') || (a == 'B' && b == 'C')) {
            return 1;
        } else {
            return -1;
        }
    }
}