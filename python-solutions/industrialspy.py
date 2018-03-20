import itertools
import sys


def get_test_cases():
    cases = list()
    sys.stdin.readline()
    for line in sys.stdin.readlines():
        digits = list(line.strip())
        cases.append(digits)
    return cases


def get_reconstructions(digits: list):
    reconstructions = set()
    for i in range(1, len(digits) + 1):
        for permutation in itertools.permutations(digits, i):
            reconstructions.add(int(''.join(permutation)))
    return reconstructions


def is_prime(n: int):
    if n <= 1:
        return False
    elif n <= 3:
        return True
    elif n % 2 == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True


def num_primes(digits):
    count = 0
    recons = get_reconstructions(digits)
    for n in recons:
        if is_prime(n):
            count += 1
    return count


def main():
    cases = get_test_cases()
    for digits in cases:
        print(num_primes(digits))


if __name__ == '__main__':
    main()
