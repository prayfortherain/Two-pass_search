import java.io.*;
import java.util.*;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        int min37 = 1000;
        int max73 = 0;
        int pairCount = 0;
        int minSum = 100000;

        try (BufferedReader reader = new BufferedReader(new FileReader("17-342.txt"))) {
            String line;
            Integer number = null;
            while ((line = reader.readLine()) != null) {
                number = Integer.parseInt(line);
                numbers.add(number);
                if (number % 37 == 0 && number < min37) {
                    min37 = number;
                }
                if (number % 73 == 0 && number > max73) {
                    max73 = number;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if ((numbers.get(i) == min37 && numbers.get(i+1) != max73) || (numbers.get(i) != min37 && numbers.get(i+1) == max73)) {
                pairCount++;
                int sum = numbers.get(i) + numbers.get(i+1);
                if (sum < minSum) {
                    minSum = sum;
                }
            }
        }

        System.out.println("Количество найденных пар: " + pairCount);
        System.out.println("Минимальная сумма: " + minSum);
    }
}