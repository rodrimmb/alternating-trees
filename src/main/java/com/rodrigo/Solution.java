package com.rodrigo;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int solution(int[] A) {
        List<Integer> treesHeights = convertArrayOfIntsInList(A);
        System.out.println("Trees heights: " + treesHeights);
        if(hasValidValues(treesHeights)) {
            if(hasValidPattern(treesHeights)) {
                return 0;
            } else {
                return searchValidPatternsCutingTree(treesHeights);
            }
        } else {
            return -1;
        }
    }

    private int searchValidPatternsCutingTree(List<Integer> treesHeights) {
        List<List<Integer>> solutions = new ArrayList<>();
        for (int i = 0; i < treesHeights.size(); i++) {
            List<Integer> originalListOfTrees = new ArrayList<>(treesHeights);
            originalListOfTrees.remove(i);
            if(hasValidPattern(originalListOfTrees)){
                System.out.println("You can remove A[" + i + "] so secuence becomes " + originalListOfTrees);
                solutions.add(originalListOfTrees);
            }
        }
        if(solutions.size() == 0) {
            return -1;
        } else {
            return solutions.size();
        }
    }

    private boolean hasValidPattern(List<Integer> trees) {
        boolean flag = true;
        for(int i = 0; i < trees.size(); i++) {
            if(isFirstTree(i) || isLastTree(i, trees.size()-1)) {
                continue;
            } else {
                if(isTreeHeightEqualsToNextTree(trees.get(i),trees.get(i + 1))) {
                    return false;
                } else {
                    if(isFirstTree(i) || isLastTree(i, trees.size()-1)) {
                        continue;
                    } else {
                        Integer treeHeight = trees.get(i);
                        Integer previusTreeHeight = trees.get(i - 1);
                        Integer nextTree = trees.get(i + 1);

                        flag = (isHeightGreater(treeHeight, previusTreeHeight) && isHeightGreater(treeHeight, nextTree)) ||
                                (isHeightSmaller(treeHeight, previusTreeHeight) && isHeightSmaller(treeHeight, nextTree));
                    }
                }
                if(!flag) {
                    return flag;
                }
            }
        }
        return flag;
    }

    private boolean isLastTree(int position, int length) {
        return position == length;
    }

    private boolean isFirstTree(int position) {
        return position == 0;
    }

    private boolean isTreeHeightEqualsToNextTree(Integer tree, Integer nextTree) {
        return tree.equals(nextTree);
    }

    private boolean isHeightGreater(Integer originalTree, Integer comparedTree) {
        return originalTree > comparedTree;
    }

    private boolean isHeightSmaller(Integer originalTree, Integer comparedTree) {
        return originalTree < comparedTree;
    }

    private boolean hasValidValues(List<Integer> heights) {
        return hasValidNumberOfTrees(heights) && hasValidHeight(heights);
    }

    private boolean hasValidNumberOfTrees(List<Integer> heights) {
        return heights.size() >= 4 && heights.size() <= 200;
    }

    private boolean hasValidHeight(List<Integer> heights) {
        return heights.stream().noneMatch(h -> h < 1 || h > 1000);
    }

    private List<Integer> convertArrayOfIntsInList(int[] array) {
        return Arrays.stream(array).boxed().collect(Collectors.toList());
    }
}
