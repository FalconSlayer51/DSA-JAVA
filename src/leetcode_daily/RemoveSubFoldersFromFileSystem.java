package leetcode_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RemoveSubFoldersFromFileSystem {
    public static List<String> removeSubFolders(String[] folder) {
        HashSet<String> set = new HashSet<>(Arrays.asList(folder));
        ArrayList<String> result = new ArrayList<>();

        for (String f: folder) {
            boolean isSubFolder = false;
            String prefix = f;

            while (!prefix.isEmpty()) {
                int pos = prefix.lastIndexOf('/');
                if (pos == -1) break;

                prefix = prefix.substring(0,pos);
                if (set.contains(prefix)) {
                    isSubFolder = true;
                }
            }

            if (!isSubFolder) {
                result.add(f);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] folder1 = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
        List<String> result1 = removeSubFolders(folder1);
        System.out.println(result1); // Expected: ["/a", "/c/d", "/c/f"]

        String[] folder2 = {"/a", "/a/b/c", "/a/b/d"};
        List<String> result2 = removeSubFolders(folder2);
        System.out.println(result2); // Expected: ["/a"]

        String[] folder3 = {"/a/b/c", "/a/b/ca", "/a/b/d"};
        List<String> result3 = removeSubFolders(folder3);
        System.out.println(result3); // Expected: ["/a/b/c", "/a/b/ca", "/a/b/d"]
    }
}
