def first_primes(n):
    a = []
    k = 2
    while n > 0:
        st = 0
        for i in range(2, round(k**0.5)+1):
            if k % i == 0:
                st = 1
                break
        if st == 0:
            a.append(k)
            n -= 1
        k += 1
    return a

def not_bigger_primes(n):
    a = []
    k = 2
    while n >= k:
        st = 0
        for i in range(2, round(k**0.5)+1):
            if k % i == 0:
                st = 1
                break
        if st == 0:
            a.append(k)
        k += 1
    return a

def divisors(n):
    a = []
    for i in range(1, round(n**0.5)+1):
        if n % i == 0:
            a.append([i, n//i])
    return a

def is_prime(n):
    for i in range(2, round(n**0.5)+1):
        if n % i == 0:
            return False
    return True

def near_least_prime(n):
    k = n - 1
    while not is_prime(k):
        k -= 1
    return k

def near_bigger_prime(n):
    k = n + 1
    while not is_prime(k):
        k += 1
    return k
    

n = int(input("Number of prime numbers: "))
print(first_primes(n))
print(not_bigger_primes(n))
print(divisors(n))
print(is_prime(n))
print(near_least_prime(n))
print(near_bigger_prime(n))
