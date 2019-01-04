#include <iostream>
#include <bitset>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    unsigned int n, q;
    cin >> n >> q;

    bitset<100000001> prime;
    prime.set();

    for (unsigned int p = 2; p * p <= n; p++) {
        if (prime[p]) {
            for (unsigned int i = p * p; i <= n; i += p)
                prime.reset(i);
        }
    }

    unsigned int total_primes = 0;

    for (unsigned int p = 2; p <= n; p++) {
        if (prime[p])
            total_primes++;
    }

    cout << total_primes << endl;

    prime.reset(1);

    for (int j = 0; j < q; ++j) {
        int num;
        cin >> num;
        if (prime[num]) {
            cout << 1 << endl;
        } else {
            cout << 0 << endl;
        }
    }

    return EXIT_SUCCESS;
}