#include <iostream>
#include <vector>

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

    int n, q, a, b;
    char op;
    cin >> n >> q;
    fenwick_tree tree(n);
    for (int i = 0; i < q; i++) {
        cin >> op;
        if (op == '+') {
            cin >> a >> b;
            tree.update(a, b);
        } else {
            cin >> a;
            cout << tree.query(--a) << '\n';
        }
    }
    return 0;
}
