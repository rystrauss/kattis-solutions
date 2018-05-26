#include <iostream>
#include <sstream>
#include <map>

using namespace std;

int main() {
    int N;
    ostringstream oss;
    cin >> N;
    map<int, int> depths;
    int first;
    cin >> first;
    depths[first] = 0;
    oss << 0 << endl;
    unsigned long counter = 0;
    for (int i = 1; i < N; ++i) {
        int depth = 0;
        int num;
        cin >> num;
        auto it = depths.lower_bound(num);
        if (it != depths.end()) {
            depth = it->second + 1;
        }
        if (it != depths.begin()) {
            it--;
            depth = max(depth, it->second + 1);
        }
        depths[num] = depth;
        counter += depth;
        oss << counter << endl;
    }
    cout << oss.str();
    return 0;
}