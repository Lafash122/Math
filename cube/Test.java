public class Test {
	public static void main(String[] args) {
		double leftBorder = Double.parseDouble(args[0]);
		double eps = 0.001;
		int delta = 1;

		double fL = func(leftBorder);
		double fR = fL;
		double rightBorder = leftBorder;

		if (fL > 0) {
			while (fR >= 0) {
				rightBorder += delta;
				fR = func(rightBorder);
			}
		}
		else {
			while (fR <= 0) {
				rightBorder += delta;
				fR = func(rightBorder);
			}
		}

		System.out.println(leftBorder + " " + fL + " " + rightBorder + " " + fR);
	}

	private static double func(double x) {
		return (x * x * x + 5 * x * x + 20 * x - 200);
	}
}