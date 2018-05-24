import sys

if __name__ == '__main__':
    MAX = 10
    MIN = 1
    while True:
        guess = sys.stdin.readline().strip()
        if guess == '0':
            break
        response = sys.stdin.readline().strip()
        if response == 'too high':
            MAX = min(int(guess) - 1, MAX)
        elif response == 'too low':
            MIN = max(int(guess) + 1, MIN)
        else:
            if MIN > int(guess) or MAX < int(guess):
                print('Stan is dishonest')
            else:
                print('Stan may be honest')
            MAX = 10
            MIN = 1
