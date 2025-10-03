public class Cube {
	private static double a = 1.0;
	private static double b = 1.0;
	private static double c = 1.0;
	private static double eps = 0.000001;
	private static double delta = 100;

	public static void main(String[] args) {
		a = Double.parseDouble(args[0]);
		b = Double.parseDouble(args[1]);;
		c = Double.parseDouble(args[2]);;
		eps = Double.parseDouble(args[3]);;
		delta = Double.parseDouble(args[4]);;

		//System.out.println("x^3 + " + a + "x^2 + " + b + "x + " + c);

		double d = disc();
		if (d <= 0) {
			double root;

			if (Math.abs(c) <= eps) {
				root = 0;
			}
			else if (c > eps) {
				double leftBorder = findLeftBorder(0);
				root = bisIncrFuncInter(leftBorder, 0);
			}
			else {
				double rightBorder = findRightBorder(0);
				root = bisIncrFuncInter(0, rightBorder);
			}

			System.out.println("This eqation has 1 root: " + root);
			System.out.println("The modulus of the value of the function: " + Math.abs(func(root)));

			return;
		}

		double sqRoot1 = ((-2) * a - Math.sqrt(d)) / 6;
		double sqRoot2 = ((-2) * a + Math.sqrt(d)) / 6;
		double fSqRoot1 = func(sqRoot1);
		double fSqRoot2 = func(sqRoot2);

		//System.out.println(sqRoot1 + " " + fSqRoot1 + "\t" + sqRoot2 + " " + fSqRoot2);

		if ((Math.abs(fSqRoot1) < eps) && (Math.abs(fSqRoot2) < eps)) {
			double root = (sqRoot1 + sqRoot2) / 2;

			System.out.println("This eqation has 1 root: " + root);
			System.out.println("The modulus of the value of the function: " + Math.abs(func(root)));
		}
		else if ((fSqRoot1 > eps) && (fSqRoot2 > eps)) {
			double leftBorder = findLeftBorder(sqRoot1);
			double root = bisIncrFuncInter(leftBorder, sqRoot1);

			System.out.println("This eqation has 1 root: " + root);
			System.out.println("The modulus of the value of the function: " + Math.abs(func(root)));
		}
		else if ((fSqRoot1 > eps) && (Math.abs(fSqRoot2) < eps)) {
			double leftBorder = findLeftBorder(sqRoot1);
			double root1 = bisIncrFuncInter(leftBorder, sqRoot1);
			double root2 = sqRoot2;

			System.out.println("This eqation has 2 roots: " + root1 + " and " + root2);
			System.out.println("The modulus of the value of the function: " + Math.abs(func(root1)) + " and " + Math.abs(func(root2)));
		}
		else if ((fSqRoot1 > eps) && (fSqRoot2 < ((-1) * eps))) {
			double leftBorder = findLeftBorder(sqRoot1);
			double rightBorder = findRightBorder(sqRoot2);
			double root1 = bisIncrFuncInter(leftBorder, sqRoot1);
			double root2 = bisDecrFuncInter(sqRoot1, sqRoot2);
			double root3 = bisIncrFuncInter(sqRoot2, rightBorder);

			System.out.println("This eqation has 3 roots: " + root1 + " and " + root2 + " and " + root3);
			System.out.println("The modulus of the value of the function: " + Math.abs(func(root1)) + " and " + Math.abs(func(root2)) + " and " + Math.abs(func(root3)));
		}

		else if ((Math.abs(fSqRoot1) < eps) && (fSqRoot2 < ((-1) * eps))) {
			double rightBorder = findRightBorder(sqRoot2);
			double root1 = sqRoot1;
			double root2 = bisIncrFuncInter(sqRoot2, rightBorder);

			System.out.println("This eqation has 2 roots: " + root1 + " and " + root2);
			System.out.println("The modulus of the value of the function: " + Math.abs(func(root1)) + " and " + Math.abs(func(root2)));
		}

		else if ((fSqRoot1 < ((-1) * eps)) && (fSqRoot2 < ((-1) * eps))) {
			double rightBorder = findRightBorder(sqRoot2);
			double root = bisIncrFuncInter(sqRoot2, rightBorder);

			System.out.println("This eqation has 1 root: " + root);
			System.out.println("The modulus of the value of the function: " + Math.abs(func(root)));
		}

		//System.out.println("End");
	}

	private static double func(double x) {
		return (x * x * x + a * x * x + b * x + c);
	}

	private static double disc() {
		return (4 * a * a - 12 * b);
	}

	private static double findLeftBorder(double rightBorder) {
		double fR = func(rightBorder);
		double fL = fR;
		double leftBorder = rightBorder;

		if (fR > 0) {
			while (fL >= 0) {
				leftBorder -= delta;
				fL = func(leftBorder);
			}
		}
		else {
			while (fL <= 0) {
				leftBorder -= delta;
				fL = func(leftBorder);
			}
		}

		return leftBorder;
	}

	private static double findRightBorder(double leftBorder) {
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

		return rightBorder;
	}

	private static double bisIncrFuncInter(double left, double right) {
		double center = (left + right) / 2;
		double f = func(center);

		int iter = 0;
		int maxIter = 1000;

		while ((Math.abs(f) > eps) && (iter < maxIter)) {
			if (f > eps)
				right = center;
			else if (f < ((-1) * eps))
				left = center;

			center = (left + right) / 2;
			f = func(center);

			iter++;
		}

		return center;
	}

	private static double bisDecrFuncInter(double left, double right) {
		double center = (left + right) / 2;
		double f = func(center);

		int iter = 0;
		int maxIter = 1000;

		while ((Math.abs(f) > eps) && (iter < maxIter)) {
			if (f > eps)
				left = center;
			else if (f < ((-1) * eps))
				right = center;

			center = (left + right) / 2;
			f = func(center);

			iter++;
		}

		return center;
	}
}