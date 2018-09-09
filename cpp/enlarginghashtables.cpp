#include <iostream>

using namespace std;

bool isPrime(unsigned long n) {
    if (n <= 1) return false;
    if (n <= 3) return true;
    if (n % 2 == 0 || n % 3 == 0) return false;

    for (int i = 5; i * i <= n; i = i + 6)
        if (n % i == 0 || n % (i + 2) == 0)
            return false;

    return true;
}

int main() {
    unsigned long n;
    cin >> n;
    while (n) {
        unsigned long i = (2 * n + 1) % 2 == 0 ? 2 * n + 2 : 2 * n + 1;
        while (true) {
            if (isPrime(i)) {
                cout << i;
                if (!isPrime(n)) {
                    printf(" (%lu is not prime)", n);
                }
                cout << endl;
                break;
            }
            i += 2;
        }
        cin >> n;
    }
    return 0;
}