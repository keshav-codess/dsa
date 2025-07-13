class TextEditor {
    StringBuilder text;
    int cursor;

    public TextEditor() {
        text = new StringBuilder();
        cursor = 0;
    }

    public void addText(String newText) {
        text.insert(cursor, newText);
        cursor += newText.length();
    }

    public int deleteText(int k) {
        int deleteCount = Math.min(k, cursor);
        text.delete(cursor - deleteCount, cursor);
        cursor -= deleteCount;
        return deleteCount;
    }

    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor - k);
        return getLast10LeftOfCursor();
    }

    public String cursorRight(int k) {
        cursor = Math.min(text.length(), cursor + k);
        return getLast10LeftOfCursor();
    }

    private String getLast10LeftOfCursor() {
        int start = Math.max(0, cursor - 10);
        return text.substring(start, cursor);
    }
}
