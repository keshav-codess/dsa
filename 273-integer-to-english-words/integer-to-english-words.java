class Solution {
    private static final String[] below20 = {
        "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
        "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    
    private static final String[] tens = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    private static final String[] thousands = {
        "", "Thousand", "Million", "Billion"
    };
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder result = new StringBuilder();
        int index = 0;

        while (num > 0) {
            int chunk = num % 1000;

            if (chunk != 0) {
                StringBuilder current = new StringBuilder();
                convertChunk(chunk, current);
                
                if (!thousands[index].isEmpty()) {
                    current.append(" ").append(thousands[index]);
                }
                
                result.insert(0, current.toString().trim() + " ");
            }

            num /= 1000;
            index++;
        }

        return result.toString().trim();
    }

    private void convertChunk(int num, StringBuilder sb) {
        if (num >= 100) {
            sb.append(below20[num / 100]).append(" Hundred");
            num %= 100;
            if (num != 0) sb.append(" ");
        }

        if (num >= 20) {
            sb.append(tens[num / 10]);
            num %= 10;
            if (num != 0) sb.append(" ").append(below20[num]);
        } else if (num > 0) {
            sb.append(below20[num]);
        }
    }
}
