package com.techbow.homework.y2021.m10.jiale.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * skyline
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.
 *
 * The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:
 *
 * lefti is the x coordinate of the left edge of the ith building.
 * righti is the x coordinate of the right edge of the ith building.
 * heighti is the height of the ith building.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 *
 * The skyline should be represented as a list of "key points" sorted by their x-coordinate in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment in the skyline except the last point in the list, which always has a y-coordinate 0 and is used to mark the skyline's termination where the rightmost building ends. Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
 *
 * Note: There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...,[2 3],[4 5],[7 5],[11 5],[12 7],...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...,[2 3],[4 5],[12 7],...]
 */
class LC_218 {
    /**
     *  Divide-and-conquer algorithm to solve skyline problem,
     *  which is similar with the merge sort algorithm.
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        // The base cases
        if (n == 0) {
            return output;
        }
        if (n == 1) {
            int xStart = buildings[0][0];
            int xEnd = buildings[0][1];
            int y = buildings[0][2];

            output.add(new ArrayList<Integer>() {{add(xStart); add(y); }});
            output.add(new ArrayList<Integer>() {{add(xEnd); add(0); }});
            // output.add(new int[]{xStart, y});
            // output.add(new int[]{xEnd, 0});
            return output;
        }

        // If there is more than one building,
        // recursively divide the input into two subproblems.
        List<List<Integer>> leftSkyline, rightSkyline;
        leftSkyline = getSkyline(Arrays.copyOfRange(buildings, 0, n / 2));
        rightSkyline = getSkyline(Arrays.copyOfRange(buildings, n / 2, n));

        // Merge the results of subproblem together.
        return mergeSkylines(leftSkyline, rightSkyline);
    }

    /**
     *  Merge two skylines together.
     */
    public List<List<Integer>> mergeSkylines(List<List<Integer>> left, List<List<Integer>> right) {
        int nL = left.size(), nR = right.size();
        int pL = 0, pR = 0;
        int currY = 0, leftY = 0, rightY = 0;
        int x, maxY;
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        // while we're in the region where both skylines are present
        while ((pL < nL) && (pR < nR)) {
            List<Integer> pointL = left.get(pL);
            List<Integer> pointR = right.get(pR);
            // pick up the smallest x
            if (pointL.get(0) < pointR.get(0)) {
                x = pointL.get(0);
                leftY = pointL.get(1);
                pL++;
            }
            else {
                x = pointR.get(0);
                rightY = pointR.get(1);
                pR++;
            }
            // max height (i.e. y) between both skylines
            maxY = Math.max(leftY, rightY);
            // update output if there is a skyline change
            if (currY != maxY) {
                updateOutput(output, x, maxY);
                currY = maxY;
            }
        }

        // there is only left skyline
        appendSkyline(output, left, pL, nL, currY);

        // there is only right skyline
        appendSkyline(output, right, pR, nR, currY);

        return output;
    }

    /**
     * Update the final output with the new element.
     */
    public void updateOutput(List<List<Integer>> output, int x, int y) {
        // if skyline change is not vertical -
        // add the new point
        if (output.isEmpty() || output.get(output.size() - 1).get(0) != x) {
            output.add(new ArrayList<Integer>() {{add(x); add(y); }});
        }
            // if skyline change is vertical -
            // update the last point
        else {
            output.get(output.size() - 1).set(1, y);
        }
    }

    /**
     *  Append the rest of the skyline elements with indice (p, n)
     *  to the final output.
     */
    public void appendSkyline(List<List<Integer>> output, List<List<Integer>> skyline,
                              int p, int n, int currY) {
        while (p < n) {
            List<Integer> point = skyline.get(p);
            int x = point.get(0);
            int y = point.get(1);
            p++;
            // update output
            // if there is a skyline change
            if (currY != y) {
                updateOutput(output, x, y);
                currY = y;
            }
        }
    }
}