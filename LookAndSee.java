import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    Solution program = new Solution();
    
    assert program.lookAndSee(null, 0) == null;
    assert "".equals(program.lookAndSee("", 0));
    assert "1".equals(program.lookAndSee("1", 0));
    assert "11".equals(program.lookAndSee("1", 1));
    assert "21".equals(program.lookAndSee("1", 2));
    assert "1211".equals(program.lookAndSee("1", 3));
    assert "111221".equals(program.lookAndSee("1", 4));
    assert "1113213211".equals(program.lookAndSee("1", 7));
  }
  
  private String lookAndSee(String str, int depth) {
    if (depth == 0 || "".equals(str) || str == null) {
      return str;
    }
    
    Character currentCharacter = str.charAt(0);
    Integer count = 1;
    StringBuilder result = new StringBuilder();
    for (int i = 1; i < str.length(); i++) {
      if (currentCharacter != str.charAt(i)) {
        result.append(count + "" + currentCharacter);
        currentCharacter = str.charAt(i);
        count = 1;
      } else {
        count += 1;
      }
    }
    result.append(count + "" + currentCharacter);
    
    return lookAndSee(result.toString(), depth - 1);
  }
}

