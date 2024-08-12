package leetcode.interview.two_pointers;

public class T125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        for (int i = 0, j = s.length() - 1; i <= j;) {
            try {
                while (isBad(s.charAt(i))) i++;
                while (isBad(s.charAt(j))) j--;
                if (s.charAt(i++) != s.charAt(j--)) return false;
            } catch (StringIndexOutOfBoundsException ignored) {}
        }

        return true;
    }

    private boolean isBad(char sym) {
        return (sym < 48 || sym > 57) && (sym < 97 || sym > 122);
    }
}
