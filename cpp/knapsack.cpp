#include <iostream>
#include <list>

using namespace std;

list<int> knapsack(int capacity, int n, const int weight[], const int value[]) {
    int table[n + 1][capacity + 1];
    for (int k = 0; k <= n; ++k) {
        table[k][0] = 0;
    }
    for (int k = 0; k <= capacity; ++k) {
        table[0][k] = 0;
    }
    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= capacity; ++j) {
            if (weight[i - 1] <= j) {
                table[i][j] = max(value[i - 1] + table[i - 1][j - weight[i - 1]], table[i - 1][j]);
            } else {
                table[i][j] = table[i - 1][j];
            }
        }
    }

    list<int> indices;
    int i = n, j = capacity;
    while (i > 0 && j > 0) {
        if (table[i][j] != table[i - 1][j]) {
            indices.push_back(i - 1);
            j -= weight[i - 1];
        }
        i--;
    }
    return indices;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    double c;
    int n;
    while (cin >> c && cin >> n) {
        int value[n];
        int weight[n];
        for (int i = 0; i < n; ++i) {
            int v, w;
            cin >> v >> w;
            value[i] = v;
            weight[i] = w;
        }
        list<int> indices = knapsack((int) c, n, weight, value);
        cout << indices.size() << endl;
        for (int i : indices) {
            cout << i << ' ';
        }
        cout << endl;
    }
    return EXIT_SUCCESS;
}