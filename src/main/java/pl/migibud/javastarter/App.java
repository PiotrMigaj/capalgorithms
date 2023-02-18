package pl.migibud.javastarter;

import java.util.*;

class App {
    public static void main(String[] args) {

        List<Group> groups = new ArrayList<>();

        String[][] array = {{"A", "A", "A", "B", "C"}, {"B", "A", "D", "E", "M"}, {"G", "A", "F", "L", "M"}, {"G", "G", "G", "L", "M"}, {"G", "F", "V", "X", "M"}};

        Arrays.stream(array).forEach(arr -> System.out.println(Arrays.toString(arr)));

//find vertically
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 2; j++) {
                String element = array[i][j];
                if (array[i][j + 1].equals(element) && array[i][j + 2].equals(element)) {
                    Group group = new Group(element);
                    group.addCoordinates(new Coordinates(i, j));
                    group.addCoordinates(new Coordinates(i, j + 1));
                    group.addCoordinates(new Coordinates(i, j + 2));
                    groups.add(group);
                }
            }
        }

        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - 2; i++) {
                String element = array[i][j];
                if (array[i + 1][j].equals(element) && array[i + 2][j].equals(element)) {
                    Group group = new Group(element);
                    group.addCoordinates(new Coordinates(i, j));
                    group.addCoordinates(new Coordinates(i + 1, j));
                    group.addCoordinates(new Coordinates(i + 2, j));
                    groups.add(group);
                }
            }
        }

        System.out.println(groups);

        boolean b = canGroupsBeMerged(groups.get(2), groups.get(3));
        System.out.println(b);


        Set<String> a = Set.of("A", "B");
        Set<String> b1 = Set.of("B", "A");

        System.out.println("Check equality of hashSet " + a.equals(b1));


        List<Group> anotherGroups = mergeGroups(groups);
        System.out.println("Merged groups");
        anotherGroups.forEach(System.out::println);

    }

    public static List<Group> mergeGroups(List<Group> input) {

        input.forEach(System.out::println);
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        if (input.size() == 1) {
            return input;
        }
        for (int i = 0; i < input.size(); i++) {
            Group groupA = input.get(i);
            for (int j = i + 1; j < input.size(); j++) {
                Group groupB = input.get(j);
                if (!canGroupsBeMerged(groupA, groupB)) {
                    continue;
                }
                groupA.getCoordinates().addAll(groupB.getCoordinates());
                groupB.getCoordinates().addAll(groupA.getCoordinates());
            }
        }
        input.forEach(System.out::println);
        Set<Group> set = new HashSet<>(input);
        return new ArrayList<>(set);
    }

    public static boolean canGroupsBeMerged(Group group1, Group group2) {
        if (!group1.getType().equals(group2.getType())) {
            return false;
        }
        Set<Coordinates> set = new HashSet<>(group1.getCoordinates());
        set.addAll(group2.getCoordinates());
        return set.size() != (group1.getCoordinates().size() + group2.getCoordinates().size());
    }

    public static List<Group> mergeGroups2(List<Group> input) {
        System.out.println("Input list");
        input.forEach(System.out::println);
        Stack<Group> stack = new Stack<>();
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        if (input.size() == 1) {
            return new ArrayList<>(input);
        }
        for (int i = 0; i < input.size(); i++) {
            Group baseGroup = input.get(i);

            int counter = 0;
            for (int j = i + 1; j < input.size(); j++) {
                Group mergeGroup = input.get(j);
                if (!canGroupsBeMerged(baseGroup, mergeGroup)) {
                    counter++;
                }
            }
            if (counter == (input.size() - i - 1)) {
                if (stack.isEmpty()) {
                    stack.add(baseGroup);
                } else {
                    int counter2 = 0;
                    for (Group g : stack) {
                        if (g.getCoordinates().containsAll(baseGroup.getCoordinates())) {
                            counter2++;
                        }
                    }
                    if (counter2 == 0) {
                        stack.add(baseGroup);
                    }
                }
            }
            for (int j = i + 1; j < input.size(); j++) {
                Group mergeGroup = input.get(j);
                if (!canGroupsBeMerged(baseGroup, mergeGroup)) {
                    continue;
                }
                Group combineGroup = new Group(baseGroup.getType());
                if (stack.isEmpty()) {
                    combineGroup.getCoordinates().addAll(baseGroup.getCoordinates());
                    combineGroup.getCoordinates().addAll(mergeGroup.getCoordinates());
                    stack.add(combineGroup);
                    System.out.println("Combined group");
                    System.out.println(combineGroup);
                } else {
                    Group poppedGroup = stack.pop();
                    if (poppedGroup.getCoordinates().containsAll(baseGroup.getCoordinates())) {
                        poppedGroup.getCoordinates().addAll(mergeGroup.getCoordinates());
                        stack.add(poppedGroup);
                    } else {
                        stack.add(poppedGroup);
                        combineGroup.getCoordinates().addAll(baseGroup.getCoordinates());
                        combineGroup.getCoordinates().addAll(mergeGroup.getCoordinates());
                        stack.add(combineGroup);
                    }
                }

            }
        }
        System.out.println("Stacked list");
        stack.forEach(System.out::println);
        return new ArrayList<>(stack);
    }

}

class Group {
    String type;
    Set<Coordinates> coordinates = new HashSet<>();

    public Group(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Set<Coordinates> getCoordinates() {
        return coordinates;
    }

    void addCoordinates(Coordinates coordinates) {
        this.coordinates.add(coordinates);
    }

    @Override
    public String toString() {
        return "Group{" +
                "type='" + type + '\'' +
                ", coordinates=" + coordinates +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(type, group.type) && Objects.equals(coordinates, group.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, coordinates);
    }
}

class Coordinates {
    final int x;
    final int y;

    public Coordinates(int x, int y) {
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
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}