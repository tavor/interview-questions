public class MyHashMap {
	private static int ARRAY_SIZE = 100;

	private Object[] objects;

	public MyHashMap() {
		this.objects= new Object[ARRAY_SIZE];
	}

	public int hash(String str) {
		int hash = str.hashCode();

		return hash > 0 ? hash : hash * -1;
	}

	public Object get(String key) {
		if (key != null) {
			return objects[hash(key) % ARRAY_SIZE];
		} else {
			return null;
		}
	}
	
	public void set(String key, Object obj) {
		objects[hash(key) % ARRAY_SIZE] = obj;
	}

	public static void main(String[] args) {
		MyHashMap map = new MyHashMap();

		map.set("John Smith", "foo");
		map.set("Ally Jane", "bar");
		map.set("Robert Williams", "hello");
		map.set("Tom Smith", "welcome");
		map.set("Danny Erlang", "roger");
		map.set("Tolsi Grammar", "abc");
		map.set("7", "1");
		map.set("8", "2");
		map.set("9", "3");
		map.set("10", "4");

		System.out.println((String)map.get("John Smith"));
		System.out.println((String)map.get("Ally Jane"));
		System.out.println((String)map.get("Robert Williams"));
		System.out.println((String)map.get("Tom Smith"));
		System.out.println((String)map.get("Danny Erlang"));
		System.out.println((String)map.get("Tolsi Grammar"));
		System.out.println((String)map.get("7"));
		System.out.println((String)map.get("8"));
		System.out.println((String)map.get("9"));
		System.out.println((String)map.get("10"));
	}
}
