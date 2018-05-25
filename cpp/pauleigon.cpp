#include <iostream>

using namespace std;

int main() {
    int N, P, Q;
    cin >> N >> P >> Q;
    int turn = (P + Q) / N;
    if (turn % 2 == 0) {
        cout << "paul";
    } else {
        cout << "opponent";
    }
    return 0;
}
