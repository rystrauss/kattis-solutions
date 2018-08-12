#include <iostream>
#include <queue>
#include <algorithm>
#include <cmath>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    queue<int> q;
    int m = 0;
    for (int i = 0; i < n; ++i) {
        int request;
        cin >> request;
        while(!q.empty() && request - q.front() >= 1000) {
            q.pop();
        }
        q.push(request);
        m = max(m, (int) q.size());
    }
    cout << ceil((float) m / k);
    return 0;
}