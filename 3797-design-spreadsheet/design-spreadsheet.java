class Spreadsheet {
    private int[][] grid;

    public Spreadsheet(int rows) {
        grid = new int[rows][26]; 
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        String expr = formula.substring(1); 
        String[] parts = expr.split("\\+");

        int val1 = parseOperand(parts[0]);
        int val2 = parseOperand(parts[1]);

        return val1 + val2;
    }

    private int parseOperand(String s) {

        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }
        int[] pos = parseCell(s);
        return grid[pos[0]][pos[1]];
    }

    private int[] parseCell(String cell) {
        char colChar = cell.charAt(0);
        int col = colChar - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}
