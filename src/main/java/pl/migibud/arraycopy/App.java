package pl.migibud.arraycopy;

import java.util.*;

enum Food {
    BURGER, SALAD, FRUIT, ONION, BEETROOT
}

class App {
    public static void main(String[] args) {

        Food[][] food = {
                {Food.FRUIT, Food.SALAD, Food.ONION, Food.BURGER},
                {Food.BEETROOT, Food.BURGER, Food.FRUIT, Food.BURGER},
                {Food.FRUIT, Food.SALAD, Food.FRUIT, Food.BURGER},
                {Food.BEETROOT, Food.SALAD, Food.BEETROOT, Food.BURGER},

        };

        Arrays.stream(food).forEach(arr -> System.out.println(Arrays.toString(arr)));
        System.out.println();
        Map<Point, Food> allElementsInRow = getAllElementsInRow(food, new Point(1, 1));

        System.out.println(allElementsInRow);

        System.out.println();

        Map<Point, Food> allElementsInColumn = getAllElementsInColumn(food, new Point(0, 2));
        System.out.println(allElementsInColumn);

        Map<Point, Food> diagonal = getAllElementsInDiagonalFromLeftDownToRightUp(food, new Point(2, 2));
        System.out.println("Diagonal");
        System.out.println(diagonal);

        System.out.println("Pointed element");
        Map<Point, Food> allNeighboursOfPointedElement = getAllNeighboursOfPointedElement(food, new Point(0, 0));
        System.out.println(allNeighboursOfPointedElement.size());
        clearBoard(food, new ArrayList<>(allNeighboursOfPointedElement.keySet()));

        System.out.println("After cleaning");
        Arrays.stream(food).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private static void clearBoard(Food[][] input, List<Point> points) {
        points.forEach(point -> input[point.getX()][point.getY()] = null);
    }

    public static Map<Point, Food> getAllElementsInRow(Food[][] input, Point point) {
        Map<Point, Food> elements = new HashMap<>();
        int x = point.getX();
        int y = point.getY();
        iterateRecursivelyBackward(input, x, y - 1, elements);
        iterateRecursivelyForward(input, x, y + 1, elements);
        return elements;
    }

    private static void iterateRecursivelyForward(Food[][] input, int rowIndex, int colIndex, Map<Point, Food> mapWithFood) {
        if (colIndex < input.length) {
            mapWithFood.putIfAbsent(new Point(rowIndex, colIndex), input[rowIndex][colIndex]);
            iterateRecursivelyForward(input, rowIndex, colIndex + 1, mapWithFood);
        }
    }

    private static void iterateRecursivelyBackward(Food[][] input, int rowIndex, int colIndex, Map<Point, Food> mapWithFood) {
        if (colIndex >= 0) {
            mapWithFood.putIfAbsent(new Point(rowIndex, colIndex), input[rowIndex][colIndex]);
            iterateRecursivelyBackward(input, rowIndex, colIndex - 1, mapWithFood);
        }
    }

    public static Map<Point, Food> getAllElementsInColumn(Food[][] input, Point point) {
        Map<Point, Food> elements = new HashMap<>();
        int x = point.getX();
        int y = point.getY();
        iterateRecursivelyUpward(input, x - 1, y, elements);
        iterateRecursivelyDownward(input, x + 1, y, elements);
        return elements;
    }

    private static void iterateRecursivelyUpward(Food[][] input, int rowIndex, int colIndex, Map<Point, Food> mapWithFood) {
        if (rowIndex >= 0) {
            mapWithFood.putIfAbsent(new Point(rowIndex, colIndex), input[rowIndex][colIndex]);
            iterateRecursivelyUpward(input, rowIndex - 1, colIndex, mapWithFood);
        }
    }

    private static void iterateRecursivelyDownward(Food[][] input, int rowIndex, int colIndex, Map<Point, Food> mapWithFood) {
        if (rowIndex < input.length) {
            mapWithFood.putIfAbsent(new Point(rowIndex, colIndex), input[rowIndex][colIndex]);
            iterateRecursivelyDownward(input, rowIndex + 1, colIndex, mapWithFood);
        }
    }

    public static Map<Point, Food> getAllElementsInDiagonalFromLeftDownToRightUp(Food[][] input, Point point) {
        Map<Point, Food> elements = new HashMap<>();
        int x = point.getX();
        int y = point.getY();
        iterateRecursivelyLeftDownward(input, x + 1, y - 1, elements);
        iterateRecursivelyRightUpward(input, x - 1, y + 1, elements);
        return elements;
    }

    private static void iterateRecursivelyRightUpward(Food[][] input, int rowIndex, int colIndex, Map<Point, Food> mapWithFood) {
        if (rowIndex >= 0 && colIndex < input.length) {
            mapWithFood.putIfAbsent(new Point(rowIndex, colIndex), input[rowIndex][colIndex]);
            iterateRecursivelyRightUpward(input, rowIndex - 1, colIndex + 1, mapWithFood);
        }
    }

    private static void iterateRecursivelyLeftDownward(Food[][] input, int rowIndex, int colIndex, Map<Point, Food> mapWithFood) {
        if (rowIndex < input.length && colIndex >= 0) {
            mapWithFood.putIfAbsent(new Point(rowIndex, colIndex), input[rowIndex][colIndex]);
            iterateRecursivelyLeftDownward(input, rowIndex + 1, colIndex - 1, mapWithFood);
        }
    }

    public static Map<Point, Food> getAllNeighboursOfPointedElement(Food[][] input, Point point) {
        Map<Point, Food> elements = new HashMap<>();
        int rowIndex = point.getX();
        int colIndex = point.getY();
        int[] rowShifts = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colShifts = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 0; i < rowShifts.length; i++) {
            if (isSafe(input, rowIndex + rowShifts[i], colIndex + colShifts[i])) {
                elements.put(new Point(rowIndex + rowShifts[i], colIndex + colShifts[i]), input[rowIndex + rowShifts[i]][colIndex + colShifts[i]]);
            }
        }
        return elements;
    }

    private static boolean isSafe(Food[][] input, int rowIndex, int colIndex) {
        int size = input.length;
        return rowIndex >= 0 &&
                rowIndex < size &&
                colIndex >= 0 &&
                colIndex < size;
    }


}

class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
