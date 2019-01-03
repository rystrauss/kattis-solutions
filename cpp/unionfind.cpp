#include <iostream>
#include <list>

using namespace std;

int find(int node, int *parents) {
    list<int> path;
    int cur = node;

    while (parents[cur] != -1) {
        path.push_back(cur);
        cur = parents[cur];
    }

    for (int i : path) {
        parents[i] = cur;
    }

    return cur;
}

void join(int n1, int n2, int *parents, int *ranks) {
    if (ranks[n1] >= ranks[n2]) {
        parents[n2] = n1;
        if (ranks[n1] == ranks[n2])
            ++ranks[n2];
    } else {
        parents[n1] = n2;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);
    int n, q;
    cin >> n >> q;
    int *parents = new int[n];
    int *ranks = new int[n];
    for (int j = 0; j < n; ++j) {
        parents[j] = -1;
        ranks[j] = 0;
    }
    for (int i = 0; i < q; ++i) {
        char operation;
        int a, b;
        cin >> operation >> a >> b;
        int p1 = find(a, parents);
        int p2 = find(b, parents);
        if (operation == '?') {
            if (p1 == p2)
                cout << "yes";
            else
                cout << "no";
            cout << endl;
        } else if (p1 != p2) {
            join(p1, p2, parents, ranks);
        }
    }
    delete[] parents;
    delete[] ranks;
    return EXIT_SUCCESS;
}