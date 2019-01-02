#include <iostream>

using namespace std;

#define LOWER "lower"
#define HIGHER "higher"

int main() {
    int low = 1;
    int high = 1000;
    while (true) {
        string response;
        int mid = (low + high) / 2;
        cout << mid << endl;
        cin >> response;
        if (response == LOWER) {
            high = mid - 1;
        } else if (response == HIGHER) {
            low = mid + 1;
        } else {
            return EXIT_SUCCESS;
        }
    }
}