package ru.starkov.first_week.floodfill;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 * <p>
 * Return the modified image after performing the flood fill.
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int colorToReplace = image[sr][sc];
        if (color == colorToReplace) {
            return image;
        }
        fill(image, sr, sc, colorToReplace, color);
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int colorToReplace, int newColor) {
        if (sr >= image.length || sc >= image[0].length ||
                sc < 0 || sr < 0 || image[sr][sc] != colorToReplace) {
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, colorToReplace, newColor);
        fill(image, sr - 1, sc, colorToReplace, newColor);
        fill(image, sr, sc - 1, colorToReplace, newColor);
        fill(image, sr, sc + 1, colorToReplace, newColor);
    }
}

