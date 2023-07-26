package ru.starkov.second_week.climbing_stairs;


/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    /*

    Алгоритм решения задач динамического программирования.
    1. Определение целевой функции (или функции значения или просто Значения).
    Целевая функция определяет меру качества или производительности для конкертного состояния.
    Значение обычно выражается через целевую функцию и используется для принятия решений и переходов между состояниями.
    Для данной задачи целевая функция выглядит следующим образом
    F(n) количество возможных способов подняться на вершину лестницы.
    2. Идентификация базовых случаев.
    Для данной задачи есть два базовых случая:
    а) Когда у лестницы только одна стпуень, количество возможных путей на верх равно одному. F(1) = 1.
    б) Когда у лестницы нет ступеней, мы уже находимся на верху и количество возможных путей равно одному. F(0) = 1.
    3. Запись функции преобразования. Для перехода от одного состояния к другому.
    Для данной задачи решением будет являться
    F(n) = F(n-1) + F(n-2)/
    4. Определение порядка выполнения функции.
    Для данной задачи снизу - вверх.
    Мы используем значения базовых случаев для нахождения решения следующих подзадач.
    5. Нахождение ответа.
    Для данной задачи ответ будет находиться в значении функции F(n).
     */
    public int climbStairs(int n) {
        int[] numberOfDifferentWays = new int[n + 1];
        numberOfDifferentWays[0] = 1;
        numberOfDifferentWays[1] = 1;
        for (int i = 2; i <= n; i++) {
            numberOfDifferentWays[i] = numberOfDifferentWays[i - 2] + numberOfDifferentWays[i - 1];
        }
        return numberOfDifferentWays[n];
    }
    public int optimizedClimbStairs(int n) {
        if (n <= 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = a + b;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = c - a;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(150));
        System.out.println(climbingStairs.optimizedClimbStairs(150));
    }

    //[1, 1, 2, 3, 5, 8, 13]
    // a, b, c
    //    a, b, c


}

