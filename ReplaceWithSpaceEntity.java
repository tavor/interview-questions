import java.util.Arrays;

public class ReplaceWithSpaceEntity {
	public static void main(String[] args) {
		ReplaceWithSpaceEntity program = new ReplaceWithSpaceEntity();
		
		char[] test = "Mr John Smith    ".toCharArray();
		program.replaceWithSpaceEntity(test, 13);

		char[] abtest = "A BC  ".toCharArray();
		program.replaceWithSpaceEntity(abtest, 4);

		char[] foobartest = "foo b a r      ".toCharArray();
		program.replaceWithSpaceEntity(foobartest, 9);
		
		assert Arrays.equals("Mr%20John%20Smith".toCharArray(), test): "Failed: Mr John Smith";
		assert Arrays.equals("A%20BC".toCharArray(), abtest): "Failed: A BC";
		assert Arrays.equals("foo%20b%20a%20r".toCharArray(), foobartest): "Failed: foo b a r";
	}

	public void replaceWithSpaceEntity(char[] str, int trueLength) {
		for (int c = 0; c < trueLength; c++) {
			if (str[c] == ' ') {
				int cursor = c, moveIndex = trueLength - 1;
				while (moveIndex > cursor) {
					str[moveIndex + 2] = str[moveIndex];
					str[moveIndex] = ' ';
					moveIndex--;
				}
				str[c] = '%'; str[c + 1] = '2'; str[c + 2] = '0';
				trueLength += 2;
			}
		}
	}
}
