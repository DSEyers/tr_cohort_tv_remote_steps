package tr_cohort_job_matching;

import java.util.Scanner;

public class KeyboardStepsApp {

    // Keyboard layout and values (2 dimensional)
    static final char[][] remoteKeyboardCharLayout = {
            {'a', 'b', 'c', 'd', 'e', '1', '2', '3'},
            {'f', 'g', 'h', 'i', 'j', '4', '5', '6'},
            {'k', 'l', 'm', 'n', 'o', '7', '8', '9'},
            {'p', 'q', 'r', 's', 't', '.', '@', '0'},
            {'u', 'v', 'w', 'x', 'y', 'z', '_', '/'}
    };

    public final static int RET_NOT_FOUND = -1;

    final int STEP_OK = 1;

    public static void main(String[] args) {
        final KeyboardStepsApp keyboardStepsApp = new KeyboardStepsApp();
        keyboardStepsApp.runApp();
    }

    /**
     * Wrapper instance function
     */
    protected void runApp() {
        // Get word to use from console
        final String wordToType = getWordToFindStepsFor();

        System.out.println("Calculating steps to type entered word '" + wordToType + '\'');

        final int stepsToGetWordMatch = getStepsToGetWordMatch(wordToType);
        System.out.println("Steps " + (stepsToGetWordMatch == -1 ? "Not found" : stepsToGetWordMatch));
    }

    /**
     * Find number of steps (click) to perform to type word on Remote Keyboard including pressing OK for each key selection
     *
     * @param textToType text to type
     * @return steps to enter word with char confirmation (clicking ok too)
     */
    public int getStepsToGetWordMatch(final String textToType) {

        int posOnRow = 1;
        int posOnCol = 1;
        int stepsCntTotal = -1;

        // Process each character of the text to enter one at a time
        boolean charFnd = false;
        for (char letterToFind : textToType.toCharArray()) {

            // Reset char found as on new char letter potentially
            charFnd = false;

            // Cells
            System.out.println("Letter " + letterToFind);
            for (int rowCurCheck = 0; rowCurCheck < KeyboardStepsApp.remoteKeyboardCharLayout.length; rowCurCheck++) {

                // Check if row has character to type
                final int cellPosFnd = getElementInRowMatchPos(letterToFind, KeyboardStepsApp.remoteKeyboardCharLayout[rowCurCheck]);
                if (cellPosFnd > -1) {  // Found element

                    if (stepsCntTotal == -1) stepsCntTotal++;

                    // Calculate stepsCntTotal for Row
                    final int stepsRow = getStepsForMatch(posOnRow, rowCurCheck);

                    // Calculate stepsCntTotal for Cell
                    final int stepsColl = getStepsForMatch(posOnCol, cellPosFnd);

                    // Add one step for pressing OK
                    final int stepMoveCnt = stepsRow + stepsColl + STEP_OK;
                    stepsCntTotal += stepMoveCnt;

                    System.out.println("\tFound on Row " + rowCurCheck + ", Col " + cellPosFnd + ", stepsCntTotal cur " + stepMoveCnt + ", stepsCntTotal total " + stepsCntTotal);

                    // Record new position
                    posOnRow = rowCurCheck;
                    posOnCol = cellPosFnd;

                    // Reset search from first row and cell
                    charFnd = true;
                    break;
                }
            }
        }
        return charFnd ? stepsCntTotal : RET_NOT_FOUND;
    }

    /**
     * Calculate steps between last and next character position
     *
     * @param posOnRow current row position
     * @param rowCurCheck row where match found
     * @return steps between current and next row, if any
     */
    private int getStepsForMatch(final int posOnRow, final int rowCurCheck) {
        int steps = 0;
        if (rowCurCheck != posOnRow) {
            // steps to move to row
            final int rowDiff = Math.abs(posOnRow - rowCurCheck);
            steps += rowDiff;
        }
        return steps;
    }

    /**
     * Finds position of character in row, if present
     * @param charToFind text to find
     * @param row to look at
     * @return -1 if not found, otherwise position
     */
    private int getElementInRowMatchPos(final char charToFind, final char[] row) {
        for (int cellCur = 0; cellCur < row.length; cellCur++) {
            final char rowValue = row[cellCur];

            if (rowValue == charToFind) {
                return cellCur;
            }
        }
        return -1;
    }

    /**
     * Prompts for word to search for on Console
     * @return word input on device specific keyboard
     */
    private String getWordToFindStepsFor() {
        System.out.println("Enter word to find steps for");
        try (final Scanner scanner = new Scanner(System.in)) {
            return scanner.nextLine();
        }
    }
}