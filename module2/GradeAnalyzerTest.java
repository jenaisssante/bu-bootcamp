import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

public class GradeAnalyzerTest {

    @Test
    public void testCalculateAverageWithMultipleScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(70, 80, 90));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(80.0, result, 0.001);
    }

    @Test
    public void testCalculateAverageWithSingleScore() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(85));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(85.0, result, 0.001);
    }

    @Test
    public void testCalculateAverageWithEmptyList() {
        ArrayList<Integer> scores = new ArrayList<>();
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testCalculateAverageWithAllSameScores() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(75, 75, 75, 75));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(75.0, result, 0.001);
    }

    @Test
    public void testCalculateAverageWithRepeatingDecimal() {
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(70, 80, 81));
        double result = GradeAnalyzer.calculateAverage(scores);
        assertEquals(77.0, result, 0.01);
    }
}
