package easy;

import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.print(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        String[] input = s.split(" ");
        if (input.length == 1) {
            return s;
        }
        String inputStr = "";
        for (int i = 0; i < input.length; i++) {
            inputStr = input[i].trim();
            if (inputStr.equals("") || inputStr.equals(" ")) {
                continue;
            }
            stack.push(inputStr);
        }
        String output = "";
        while (!stack.isEmpty()) {
            output = output + " " + stack.pop();
        }
        output = output.trim();
        return output;
    }
    public static  int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}