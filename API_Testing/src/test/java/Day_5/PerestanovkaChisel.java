package Day_5;

import java.util.Scanner;

public class PerestanovkaChisel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите перестановку (числа через пробел):");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");

        int n = tokens.length;
        boolean[] visited = new boolean[n];
        int cycles = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int current = i;
                while (!visited[current]) {
                    visited[current] = true;
                    current = Integer.parseInt(tokens[current]) - 1; // переход к следующей позиции
                }
                cycles++;
            }
        }

        System.out.println("Количество циклов: " + cycles);
    }

}
