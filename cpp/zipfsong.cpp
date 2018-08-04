#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

typedef struct {
    string title;
    unsigned long quality;
} song;

bool sorter(song const &a, song const &b) {
    return a.quality > b.quality;
}

int main() {
    unsigned long n, m;
    cin >> n >> m;
    song songs[n];
    for (unsigned long i = 0; i < n; ++i) {
        cin >> songs[i].quality;
        songs[i].quality *= i + 1;
        cin >> songs[i].title;
    }
    stable_sort(songs, songs + n, &sorter);
    for (unsigned long i = 0; i < m; ++i) {
        cout << songs[i].title << endl;
    }
    return 0;
}