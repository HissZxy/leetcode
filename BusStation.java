public class Main {

    public int work (int n, int[] a) {
        int res = 1;
        for(int i = 1; i < n; i++) {
            int distance = a[i] - a[i - 1];
            if(isPrime(distance))
                res++;
            else if(distance % 2 == 0 || isPrime(distance - 2))
                res += 2;
            else
                res += 3;
        }
        return res;
    }

    public boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n + 0.0); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] a = {0,3,10,15,16,24,28};
        System.out.println(new test().work(n, a));
    }
}
