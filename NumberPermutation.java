import java.util.Arrays;

public class NumberPermutation {
    public static void main(String[] args) {
        int number = 23;
        int result = findNextPermutation(number);
        System.out.println(result);
    }

    public static int findNextPermutation(int number) {
        char[] digits = String.valueOf(number).toCharArray();

// Находим индекс самой правой цифры, которую можно поменять
        int i = digits.length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        if (i < 0) {
// Перестановка невозможна
            return -1;
        }

// Находим индекс самой правой цифры, которую можно заменить
        int j = digits.length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

// Меняем найденные цифры местами
        swap(digits, i, j);

// Переворачиваем правую часть числа
        reverse(digits, i + 1);

        int result = Integer.parseInt(new String(digits));
        return result;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(char[] arr, int start) {
        int i = start;
        int j = arr.length - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}