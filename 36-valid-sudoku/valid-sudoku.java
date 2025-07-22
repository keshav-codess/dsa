import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> visited = new HashSet<>();

         for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    String rowKey = "row" + i + num;
                    String colKey = "col" + j + num;
                    String boxKey = "box" + (i / 3) + (j / 3) + num;

                    if (!visited.add(rowKey) || !visited.add(colKey) || !visited.add(boxKey)) {
                        return false; // duplicate
                    }
                }
            }
        }

        return true; 
    }
}
