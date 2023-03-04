import org.graalvm.polyglot.*;

public class Main {
    private static double probability(int n, int x) {
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value result = polyglot.eval("R", """
                                      func <- function(x, n, p) {
                                       return(dbinom(x, n, p))
                                      }
                                    """).execute(x, n, 0.5);

        double resultDouble = result.asDouble();
        polyglot.close();

        return resultDouble;
    }
    private static int[] read() {
        Context polyglot = Context.newBuilder().allowAllAccess(true).build();
        Value result = polyglot.eval("python", "\n" +
                "x = [0] * 2\n" +
                "print('Introduceti n')\n" +
                "x[0] = input()\n" +
                "print('Introduceti x')\n" +
                "x[1] = input()\n" +
                "while(x[1] > x[0]):\n" +
                "   print('Reintroduceti x')\n" +
                "   x[1] = input()\n" +
                "x");

        int []resultInt = new int [2];
        resultInt[0] = Integer.parseInt(result.getArrayElement(0).asString());
        resultInt[1] = Integer.parseInt(result.getArrayElement(1).asString());

        polyglot.close();

        return resultInt;
    }
    public static void main(String[] args) {
        int []n_x = new int [2];
        n_x = read();

        System.out.println("Probabilitatea de a obtine pajura de x-ori: " + probability(n_x[0], n_x[1]));
    }
}