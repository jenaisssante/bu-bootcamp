import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");

        if (scores.isEmpty()) {
            System.out.println("No valid scores were found. Nothing to report.");
            return;
        }

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
            if (score < lowest) {
                lowest = score;
            }
        }

        // Step 3: write and print report
        writeReport(scores, avg, highest, lowest, "report.txt");
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmed = line.trim();

                if (trimmed.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(trimmed);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Warning: skipping invalid line: \"" + trimmed + "\"");
                }
            }
        } catch (IOException e) {
            System.out.println("Error: could not read file \"" + filename + "\": " + e.getMessage());
        }

        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                    double avg, int high, int low,
                                    String outputFile) {
        int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        ArrayList<String> lines = new ArrayList<>();
        lines.add("=== Grade Analysis Report ===");
        lines.add(String.format("Total scores processed: %d", scores.size()));
        lines.add("");
        lines.add(String.format("Average score: %.2f", avg));
        lines.add(String.format("Highest score: %d", high));
        lines.add(String.format("Lowest score:  %d", low));
        lines.add("");
        lines.add("Grade distribution:");
        lines.add(String.format("  A (90-100):   %d", countA));
        lines.add(String.format("  B (80-89):    %d", countB));
        lines.add(String.format("  C (70-79):    %d", countC));
        lines.add(String.format("  D (60-69):    %d", countD));
        lines.add(String.format("  F (below 60): %d", countF));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: could not write report to \"" + outputFile + "\": " + e.getMessage());
        }

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
