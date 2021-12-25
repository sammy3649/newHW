package pro.sky.java.course2.newhw.lesson2_6;

import java.util.*;

public class Collection {
    private static final List<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
    private static final List<String> text = Arrays.asList("Широчайший", "диапазон", "диапазон",
            "инструментов", "и", "звуков", "NI Reaktor",
            "NI Reaktor", "подойдет", "абсолютно",
            "абсолютно", "всем");

    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
        task4();

    }

    public static void task1() {
        for (Integer num : nums) {
            if (num % 2 != 0) {
                System.out.println(num);
            }
        }
    }

    public static void task2() {
        List<Integer> newNums = new ArrayList<>(Set.copyOf(nums));
        newNums.sort(Comparator.naturalOrder());
        newNums.removeIf(num -> num % 2 != 0);
        for (Integer num : newNums) {
            System.out.println(num);
        }

    }

    public static void task3() {
        Set<String> newText = new LinkedHashSet<>(text);
        System.out.println(newText);
    }

    public static void task4() {
        Set<String> newText = new HashSet<>(text);
        System.out.println(text.size() - newText.size());
    }
}