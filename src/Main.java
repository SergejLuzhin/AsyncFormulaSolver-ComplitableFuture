import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        double a, b, c, d;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nThis program solves (a ^ 2 + b ^ 2) * log(c) / sqrt(d) asynchronously");
        System.out.println("Enter A: ");
        a = scanner.nextDouble();
        System.out.println("Enter B: ");
        b = scanner.nextDouble();
        System.out.println("Enter C: ");
        c = scanner.nextDouble();
        System.out.println("Enter D: ");
        d = scanner.nextDouble();

        CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> (Math.pow(a, 2) + Math.pow(b, 2)))
                .thenApply(result -> result * Math.log(c))
                .thenApply(result -> result / Math.sqrt(d))
                .thenApply(result -> Math.round(result * 1000.0) / 1000.0);

        System.out.println("Result: " + future.join());
    }
}