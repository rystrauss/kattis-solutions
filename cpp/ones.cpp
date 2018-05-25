#include <iostream>
#include <fstream>

using namespace std;

int main() {
    int n;
    while (cin >> n) {
        int i = 0;
        int j = 1;
        while (j % n) {
            j = (10 * j + 1) % n;
            i++;
        }
        cout << i + 1 << endl;
    }
    return 0;
}