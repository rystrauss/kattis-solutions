#include <iostream>
#include <vector>
#include <bitset>

using namespace std;

typedef long long ll;
typedef vector<ll> vll;

struct fenwick_tree {
    int n;
    vll data;

    explicit fenwick_tree(int n) {
        this->n = n + 1;
        this->data = vll(n + 1);
    }

    void update(int x, ll val) {
        while (x < n) {
            data[x] += val;
            x |= x + 1;
        }
    }

    ll query(int x) {
        ll sum = 0;
        while (x >= 0) {
            sum += data[x];
            x = (x & (x + 1)) - 1;
        }
        return sum;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n, k;
    cin >> n >> k;
    bitset<1000001> bits;
    fenwick_tree tree(n);

    char operation;
    for (int i = 0; i < k; ++i) {
        cin >> operation;
        if (operation == 'F') {
            int index;
            cin >> index;
            tree.update(index, (bits[index] ? -1 : 1));
            bits.flip(index);
        } else {
            int lower, upper;
            cin >> lower >> upper;
            cout << tree.query(upper) - tree.query(lower - 1) << '\n';
        }
    }
    return EXIT_SUCCESS;
}