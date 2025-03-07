package org.example;

import java.util.Scanner;

public class BullishDrawingProgram {

    public char[][] canvas;
    public int length;
    public int width;

    public static void main(String[] args) {
        var canvas = new BullishDrawingProgram();
        canvas.readInput();
    }

    public void readInput() {
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter command: ");
            var line = scanner.nextLine();
            var result = line.split(" ");
            if (result.length == 0) {
                continue;
            }
            switch (result[0]) {
                case "C":
                    initialize(Integer.parseInt(result[1]), Integer.parseInt(result[2]));
                    break;
                case "L":
                    drawLine(Integer.parseInt(result[1]), Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));
                    break;
                case "R":
                    drawRectangle(Integer.parseInt(result[1]), Integer.parseInt(result[2]), Integer.parseInt(result[3]), Integer.parseInt(result[4]));
                    break;
                case "B":
                    bucketFill(Integer.parseInt(result[1]), Integer.parseInt(result[2]), result[3].charAt(0));
                    break;
                case "Q":
                    System.out.println("Quiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Not a recognized command, please enter again");
                    continue;
            }
            printCanvas();
        }

    }


    public void initialize(int length, int width) {
        this.length = length;
        this.width = width;
        canvas = new char[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                canvas[i][j] = ' ';
            }
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        if (canvas == null) {
            return;
        }
        if (x1 == x2) {
            for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
                canvas[x1][i] = 'x';
            }
        } else if (y1 == y2) {
            for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
                canvas[i][y1] = 'x';
            }
        } else {
            System.out.println("Cannot draw a straight line, please enter again");
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2) {
        if (canvas == null) {
            return;
        }
        for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
            canvas[i][y1] = 'x';
            canvas[i][y2] = 'x';
        }
        for (int i = Math.min(y1, y2); i <= Math.max(y1, y2); i++) {
            canvas[x1][i] = 'x';
            canvas[x2][i] = 'x';
        }

    }

    public void bucketFill(int x1, int y1, char z) {
        if (canvas == null) {
            return;
        }
        var originalColor = canvas[x1][y1];
        fillColor(x1, y1, z, originalColor);
    }

    private void fillColor(int x1, int y1, char z, char originalColor) {
        if (x1 >= length || y1 >= width || x1 < 0 || y1 < 0) {
            return;
        }

        if (canvas[x1][y1] == originalColor) {
            canvas[x1][y1] = z;
            fillColor(x1 + 1, y1, z, originalColor);
            fillColor(x1 - 1, y1, z, originalColor);
            fillColor(x1, y1 + 1, z, originalColor);
            fillColor(x1, y1 - 1, z, originalColor);
        }
    }

    public void printCanvas() {
        if (canvas == null) {
            System.out.println("Canvas is not initialized yet");
            return;
        }
        for (int i = 0; i < length + 2; i++) {
            System.out.print('x');
        }
        System.out.println();
        for (int i = 0; i < width; i++) {
            System.out.print('x');

            for (int j = 0; j < length; j++) {
                System.out.print(canvas[j][i]);
            }

            System.out.print('x');
            System.out.println();
        }

        for (int i = 0; i < length + 2; i++) {
            System.out.print('x');
        }
        System.out.println();
    }

}