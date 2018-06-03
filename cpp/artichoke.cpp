#include <iostream>
#include <cmath>

using namespace std;

int p, a, b, c, d, n;

double price(int k) {
    return p * (sin(a * k + b) + cos(c * k + d) + 2);
}

int main() {
    cin >> p >> a >> b >> c >> d >> n;
    double max = price(1);
    double decline = 0;
    for (int i = 2; i <= n; ++i) {
        double next = price(i);
        if (next > max) max = next;
        else if (max - next > decline) decline = max - next;
    }
    printf ("%.7f\n", decline);
    return 0;
}

