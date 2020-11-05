package alpha;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2){
            System.err.println("args: min max");
            System.exit(1);
        }
        int min = Integer.parseInt(args[0]);
        int max = Integer.parseInt(args[1]);
        MathClass math = new MathImpl();
        int hi = math.highestPrime(min, max);
        for (int p: math.allPrimes(min, max)){
            System.out.printf("%d", p);
            if (p != hi) {
                System.out.print(",");
            }
        }
        System.out.println();
    }
}
