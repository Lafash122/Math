a, b, c = map (float, input("Enter the coefficients value: ") .split())
D = b**2 - 4*a*c
if a == 1:
	print ("It's a reduced quadratic equation")
else:
	print ("It's not a reduced quadratic equation")
print ("Discriminant", "=", D)
if D > 0:
	import math
	x1 = (-b + math.sqrt(D))/(2*a)
	x2 = (-b - math.sqrt(D))/(2*a)
	print ("It's the square root of the discriminant", math.sqrt(D))
	print ("x1 =", x1)
	print ("x2 =", x2)
elif D == 0:
	x = (-b)/(2*a)
	print ("x =", x)
else:
	print("The equation haven't any roots")
