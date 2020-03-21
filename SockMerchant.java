import java.util.HashMap;

public class SockMerchant {
	public static void main(String[] args) {	
		SockMerchant solution = new SockMerchant();
		System.out.println(solution.sockMerchant(new int[] {
			10, 20, 20, 10, 10, 30, 50, 10, 20	
		}));
	}

	private int sockMerchant(int[] socks) {
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();

		for (int i = 0; i < socks.length; i++) {
			if (counts.containsKey(socks[i])) {
				counts.put(socks[i], counts.get(socks[i]) + 1);
			} else {
				counts.put(socks[i], 1);
			}
		}

		int pairs = 0;
		for (Integer i : counts.keySet()) {
			pairs += (int) counts.get(i) / 2;
		}
		return pairs;
	}
}
