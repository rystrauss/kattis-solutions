#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> cell;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    vector<cell> queens;

    for (int i = 0; i < 8; ++i) {
        string row;
        cin >> row;
        for (int j = 0; j < 8; ++j) {
            if (row[j] == '*') {
                queens.emplace_back(i, j);
            }
        }
    }

    for (int i = 0; i < 8; ++i) {
        for (int j = i + 1; j < 8; ++j) {
            cell q1 = queens[i];
            cell q2 = queens[j];
            int delta_row = abs(q1.first - q2.first);
            int delta_col = abs(q1.second - q2.second);
            if (!delta_row || !delta_col || delta_row == delta_col) {
                cout << "invalid" << endl;
                return EXIT_SUCCESS;
            }
        }
    }

    cout << "valid" << endl;

    return EXIT_SUCCESS;
}