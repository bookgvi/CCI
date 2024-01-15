package graph.task;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CourseScheduleIVTest implements ListTests {

    private CourseScheduleIV c;

    @Before
    public void setUp() throws Exception {
        c = new CourseScheduleIV();
    }

    @Test
    public void checkIfPrerequisite1() {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        int[][] queries = {{0,1},{1,0}};
        List<Boolean> expected = Arrays.asList(false, true);

        List<Boolean> res = c.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertListEquals(expected, res);
    }

    @Test
    public void checkIfPrerequisite2() {
        int numCourses = 2;
        int[][] prerequisites = {};
        int[][] queries = {{1,0},{0,1}};
        List<Boolean> expected = Arrays.asList(false, false);

        List<Boolean> res = c.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertListEquals(expected, res);
    }

    @Test
    public void checkIfPrerequisite3() {
        int numCourses = 3;
        int[][] prerequisites = {{1,2},{1,0},{2,0}};
        int[][] queries = {{1,0},{1,2}};
        List<Boolean> expected = Arrays.asList(true, true);

        List<Boolean> res = c.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertListEquals(expected, res);
    }

    @Test
    public void checkIfPrerequisite4() {
        int numCourses = 5;
        int[][] prerequisites = {{1,2},{1,0},{2,0},{0,3},{3,4}};
        int[][] queries = {{1,0},{1,2},{1,4},{2,3},{3,0}};
        List<Boolean> expected = Arrays.asList(true, true,true,true,false);

        List<Boolean> res = c.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertListEquals(expected, res);
    }

    @Test
    public void checkIfPrerequisite5() {
        int numCourses = 5;
        int[][] prerequisites = {{0,1},{1,2},{2,3},{3,4}};
        int[][] queries = {{0,4},{4,0},{1,3},{3,0}};
        List<Boolean> expected = Arrays.asList(true,false,true,false);

        List<Boolean> res = c.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertListEquals(expected, res);
    }

    @Test
    public void checkIfPrerequisite6() {
        int numCourses = 4;
        int[][] prerequisites = {{2,3},{2,1},{0,3},{0,1}};
        int[][] queries = {{0,1},{0,3},{2,3},{3,0},{2,0},{0,2}};
        List<Boolean> expected = Arrays.asList(true,true,true,false,false,false);

        List<Boolean> res = c.checkIfPrerequisite(numCourses, prerequisites, queries);

        assertListEquals(expected, res);
    }

}