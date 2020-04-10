package com.rodrigo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SolutionTest {

    Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void testSolution_invalidNumberOfTrees() {
        int[] array = new int[]{1};

        int solution = this.solution.solution(array);

        assertThat(solution, is(-1));
    }

    @Test
    public void testSolution_invalidHeigtOfTree() {
        int[] array = new int[]{2,1,3,1001};

        int solution = this.solution.solution(array);

        assertThat(solution, is(-1));
    }

    @Test
    public void testSolution_noShouldRemoveAnyTree() {
        int[] array = new int[]{1,2,3,4};

        int solution = this.solution.solution(array);

        assertThat(solution, is(-1));
    }

    @Test
    public void testSolution_canRemove2Tree() {
        int[] array = new int[]{2,2,3,1};

        int solution = this.solution.solution(array);

        assertThat(solution, is(2));
    }

    @Test
    public void testSolution_canRemove3Tree() {
        int[] array = new int[]{3,4,5,3,7};

        int solution = this.solution.solution(array);

        assertThat(solution, is(3));
    }

    @Test
    public void testSolution_canRemoveTree() {
        int[] array = new int[]{3,4,5,3,7};

        int solution = this.solution.solution(array);

        assertThat(solution, is(3));
    }

    @Test
    public void testSolution_notValidHeigtInLastPosition() {
        int[] array = new int[]{6,20,5,7,14};

        int solution = this.solution.solution(array);

        assertThat(solution, is(3));
    }

    @Test
    public void testSolution_someAreEquals() {
        int[] array = new int[]{6,20,5,5,14};

        int solution = this.solution.solution(array);

        assertThat(solution, is(2));
    }

    @Test
    public void testSolution_imposibleRemoval() {
        int[] array = new int[]{6,20,25,35,44};

        int solution = this.solution.solution(array);

        assertThat(solution, is(-1));
    }
}