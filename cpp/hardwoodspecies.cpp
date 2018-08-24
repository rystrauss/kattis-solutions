#include <iostream>
#include <string>
#include <map>

using namespace std;

int main() {
    map<string, unsigned int> trees;
    int count = 0;
    string line;
    while (getline(cin, line)) {
        trees[line]++;
        count++;
    }
    auto it = trees.begin();
    while (it != trees.end()) {
        string tree = it->first;
        int num = it->second;
        double percent = (double) num / count * 100;
        cout << tree << ' ' << percent << endl;
        it++;
    }
    return 0;
}

