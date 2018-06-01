#include <iostream>
#include <string>

using namespace std;

void correct(string input, string &output) {
    for (int i = 0; i < input.length(); ++i) {
        char c = input[i];
        if (c == '<') {
            output.pop_back();
        } else {
            output.push_back(c);
        }
    }
}

int main() {
    string input, output;
    cin >> input;
    correct(input, output);
    cout << output;
    return 0;
}