class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty parts and current directory "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go to parent directory
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } 
            // Valid directory/file name
            else {
                stack.addLast(part);
            }
        }

        // Construct canonical path
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // If stack is empty, we are at root
        return result.length() == 0 ? "/" : result.toString();
    }
}