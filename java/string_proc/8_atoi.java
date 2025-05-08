class Solution {
    public int myAtoi(String s) {
        int l = s.length();
        if (l == 0) return 0;

        int total = 0;
        int base = 10;
        int sign = 1;
        int i = 0;

        // process initial whitespace
        while (i < l && s.charAt(i) == ' ') i++;
        if (i == l) return 0;

        // process sign or non-digit character after initial whitespace
        char c = s.charAt(i);
        if (c == '-') { sign *= -1; base *= -1; }   // handle leading minus
        else if (c == '+') {}                       // ignore leading plus
        else if (c < '0' || c > '9') { return 0; }  // handle other leading non-digit
        else { total = c-'0'; }                     // handle leading digit
        i++;

        // process main body
        while (i < l) {
            c = s.charAt(i);
            if (c < '0' || c > '9') return total;

            // we leverage add-, subtract-, and multiplyExact to handle overflow logic for us
            // (we sacrifice a tiny bit of efficiency for very readable code)
            try {
                // https://www.geeksforgeeks.org/java-multiplyexact-math/ (the other ones are similar in concept)
                total = Math.multiplyExact(total, base);
                base = 10;
                if (sign > 0) {
                    total = Math.addExact(total, c-'0');
                }
                else {
                    total = Math.subtractExact(total, c-'0');
                }
            }
            catch (Exception e) {
                return (sign<0 ? Integer.MIN_VALUE : Integer.MAX_VALUE);
            } 
            i++;
        }
        return total;
    }
}