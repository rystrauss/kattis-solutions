#include <iostream>
#include <algorithm>

using namespace std;

int minDA(int nums[], int N) {
    int sorted[N];
    copy(nums, nums + N, sorted);
    sort(sorted, sorted + N);
    int j = 0;
    for (int i = 0; i < N; ++i) {
        if (nums[i] == sorted[j]) {
            j++;
        }
    }
    return N - j;
}

int main() {
    int P;
    cin >> P;
    for (int p = 0; p < P; ++p) {
        int K, N;
        cin >> K >> N;
        int nums[N];
        for (int i = 0; i < N; ++i) {
            cin >> nums[i];
        }
        int DA = minDA(nums, N);
        cout << K << " " << DA << endl;
    }
    return 0;
}
