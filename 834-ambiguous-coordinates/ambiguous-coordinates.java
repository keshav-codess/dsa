class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();
        String digits = s.substring(1, s.length() - 1);
        
        for (int i = 1; i < digits.length(); i++) {
            String left = digits.substring(0, i);
            String right = digits.substring(i);
            
            List<String> leftParts = getValidNumbers(left);
            List<String> rightParts = getValidNumbers(right);
            
            for (String l : leftParts) {
                for (String r : rightParts) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }
        
        return result;
    }

    private List<String> getValidNumbers(String num) {
        List<String> res = new ArrayList<>();
        int n = num.length();

        if (isValidInteger(num)) {
            res.add(num);
        }

        for (int i = 1; i < n; i++) {
            String intPart = num.substring(0, i);
            String fracPart = num.substring(i);

            if (isValidInteger(intPart) && isValidFraction(fracPart)) {
                res.add(intPart + "." + fracPart);
            }
        }
        return res;
    }

    private boolean isValidInteger(String s) {
        return !(s.length() > 1 && s.startsWith("0"));
    }

    private boolean isValidFraction(String s) {
        return !s.endsWith("0");
    }
}
