public class StringRotation {
	public static void main(String[] args) {
		StringRotation solution = new StringRotation();

		assert !solution.isRotation(null, null);
		assert !solution.isRotation(null, "");
		assert !solution.isRotation("", "");
		assert !solution.isRotation("waterbottle", "waterbottle");
		assert solution.isRotation("waterbottle", "terbottlewa");
	}

	private boolean isRotation(String str1, String str2) {
		if ((str1 != null && str2 != null && 
		    (str1.length() + str2.length ()== 0 || str1.length() != str2.length())) ||
		    (str1 == null || str2 == null) ||
		    str1.equals(str2)) {
			return false;
		}
		
		for (int i = 0; i < str1.length() - 1; i++) {
			if (str2.charAt(i) == str1.charAt(str1.length() - 1) && 
			    str2.charAt(i + 1) == str1.charAt(0)) {
				if (i > str1.length() / 2) {
					return str2.substring(0, i + 1).equals(str1.substring(str1.length() - i - 1, str1.length()));
				} else {
					return str2.substring(i + 1, str2.length()).equals(
						str1.substring(0, str2.length() - i - 1));
				}
			}
		}
		return false;
	}
}
