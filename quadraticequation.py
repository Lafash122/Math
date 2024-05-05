a, b, c = map (float, input("Enter the coefficients value: ") .split())
D = b**2 - 4*a*c
if a == 1 or ((b % a == 0) and (c % a == 0)):
	print ("It's a reduced quadratic equation")
else:
	print ("It's not a reduced quadratic equation")

print (f"Discriminant = {D}")

if D > 0:
        import math
        x1 = (-b + math.sqrt(D))/(2*a)
        x2 = (-b - math.sqrt(D))/(2*a)
	
        print (f"The square root of the discriminant is {math.sqrt(D)}")
        print (f"x1 = {x1}")
        print (f"x2 = {x2}")
elif D == 0:
        x = (-b)/(2*a)
        print (f"x = {x}")
else:
        print("The equation haven't any roots")
