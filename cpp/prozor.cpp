#include <iostream>

using namespace std;

void findBestLocation(char **window, int R, int S, int K, int &X, int &Y, int &max) {
    for (int r = 0; r <= R - K; ++r) {
        for (int s = 0; s <= S - K; ++s) {
            int numKilled = 0;
            for (int i = r + 1; i < r + K - 1; ++i) {
                for (int j = s + 1; j < s + K - 1; ++j) {
                    if (window[i][j] == '*') {
                        numKilled++;
                    }
                }
            }
            if (numKilled > max) {
                max = numKilled;
                Y = r;
                X = s;
            }
        }
    }
}

void drawFrame(char **window, int X, int Y, int K) {
    for (int i = 0; i < K; ++i) {
        window[Y][X + i] = '-';
        window[Y + K - 1][X + i] = '-';
        window[Y + i][X] = '|';
        window[Y + i][X + K - 1] = '|';
    }
    window[Y][X] = '+';
    window[Y][X + K - 1] = '+';
    window[Y + K - 1][X] = '+';
    window[Y + K - 1][X + K - 1] = '+';
}

int main() {
    int R, S, K;
    char **window;
    cin >> R >> S >> K;
    window = new char *[R];

    for (int r = 0; r < R; ++r) {
        window[r] = new char[S];
        for (int s = 0; s < S; ++s) {
            cin >> window[r][s];
        }
    }

    int X, Y;
    int max = 0;

    findBestLocation(window, R, S, K, X, Y, max);
    drawFrame(window, X, Y, K);

    cout << max << endl;
    for (int r = 0; r < R; ++r) {
        for (int s = 0; s < S; ++s) {
            cout << window[r][s];
        }
        cout << endl;
    }

    for (int r = 0; r < R; ++r) {
        delete[] window[r];
    }
    delete[] window;
    return 0;
}

