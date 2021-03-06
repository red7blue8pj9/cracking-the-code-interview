public class OneAway {

    // There are three types of edits that can be performed on strings: Insert a character, remove a
    // character, or replace a character. Given two strings, write a function to check if they are one edit
    // away

    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() - second.length() == 1) {
            return oneEditInsert(second, first);
        } else if (first.length() - second.length() == -1) {
            return oneEditInsert(first, second);
        }
        return false;
    }

    private boolean oneEditReplace(String s1, String s2) {
        boolean found = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (found) {
                    return false;
                }
                found = true;
            }
        }
        return true;
    }

    private boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < s1.length() && index2 < s2.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    // method 2: combine edit replace and edit insert functions together
    public boolean oneEditAwayII(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;
        int i = 0;
        int j = 0;
        boolean found = false;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (found) {
                    return false;
                }
                found = true;
                if (s1.length() == s2.length()) {
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }
        return true;
    }
}
