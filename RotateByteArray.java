public class RotateByteArray {
	private enum Coordinate { X, Y }

	public static void main(String[] args) {
		RotateByteArray program = new RotateByteArray();

	}

	public void rotate(byte[][][] image, int depth, int size) {
		if (depth + 1 == size) {
			return;
		}

		int x = 0, y = 0, sign = 1;
		do {
			byte[] temp = new temp[4];
			
			Coordinate c = getCoordinate(x, y);

			if (c == Coordinate.X) {
				x += sign;
			} else {
				y += sign;
			}

			if (x == size - 1 && y == size - 1) {
				sign = -1;
			}	
		} while(x != depth || y != depth);

		return rotate(image, depth + 1, size - 1);
	}

	private Coordinate getCoordinate(int x, int y) {
		if (x == 3 && y == 0) {
			return Coordinate.Y;
		} else if (x == 3 && y == 3) {
			return Coordinate.X;
		} else if (x == 0 && y == 3) {
			return Coordinate.Y;
		}
	} 
}
