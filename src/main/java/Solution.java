import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

class Solution {
    private double maxArea;
    private Queue<Integer> coordinates = new ConcurrentLinkedQueue<>();
    private List<Integer> coordinatesBiggestTriangle = new ArrayList<>();

    void main(String inputFileString, String outputFileString) {
        if (new File(inputFileString).length() != 0) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFileString))) {
                while (reader.ready()) {
                    String line = reader.readLine();
                    if (checkLine(line)) {
                        try {
                            coordinates.clear();
                            coordinates.addAll(parseStringToList(line));
                            Triangle currentTriangle = new Triangle(coordinates);
                            if (currentTriangle.isIsosceles()) {
                                checkMaxTriangleArea(currentTriangle);
                            }
                        } catch (NumberFormatException ignored) {
                        }
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла. Возможно файл повреждён.");
            }
        } else {
            System.out.println("Читаемый файл файл пуст.");
        }
        writeToFile(outputFileString, coordinatesToString(coordinatesBiggestTriangle));
    }

    private boolean checkLine(String line) {
        if (line == null || line.trim().isEmpty())
            return false;
        String[] strings = line.trim().split(" ");
        if (strings.length == 6) {
            for (String elem : strings) {
                return isElementInteger(elem);
            }
        }
        return false;
    }

    private boolean isElementInteger(String element) {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<Integer> parseStringToList(String line) throws NumberFormatException {
        String[] stringCoordinates = line.trim().split(" ");
        List<Integer> integerCoordinates = new ArrayList<>();
        for (String elem : stringCoordinates) {
            integerCoordinates.add(Integer.parseInt(elem));
        }
        return integerCoordinates;
    }

    private void checkMaxTriangleArea(Triangle triangle) {
        double currentArea = triangle.calculateTriangleArea();
        if (currentArea > maxArea) {
            maxArea = currentArea;
            coordinatesBiggestTriangle.clear();
            coordinatesBiggestTriangle.add(triangle.getPointA().getX());
            coordinatesBiggestTriangle.add(triangle.getPointA().getY());
            coordinatesBiggestTriangle.add(triangle.getPointB().getX());
            coordinatesBiggestTriangle.add(triangle.getPointB().getY());
            coordinatesBiggestTriangle.add(triangle.getPointC().getX());
            coordinatesBiggestTriangle.add(triangle.getPointC().getY());
        }
    }

    private void writeToFile(String path, String data) {
        if (data == null || data.trim().isEmpty()) {
            System.out.println("Треугольников удовлетворяющих условию в данном файле не существует.");
        }
        File outputFile = new File(path);
        try (FileWriter writer = new FileWriter(path, false)) {
            if (!outputFile.exists()) {
                outputFile.getParentFile().mkdirs();
                outputFile.createNewFile();
            }
            writer.write(data);
            writer.flush();
            System.out.println("Выполнено.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка при записи в файл. Продолжить выполнение невозможно.");
        }
    }

    private String coordinatesToString(List<Integer> coordinates) {
        StringBuilder sb = new StringBuilder();
        for (Integer elem : coordinates) {
            sb.append(elem).append(" ");
        }
        return new String(sb).trim();
    }
}
