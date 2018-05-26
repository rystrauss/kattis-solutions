/*
 * Naive solution to "Binary Search Tree".
 *
 * Builds an actual tree and add all nodes. This approach is too slow for the 2 second time limit.
 */

#include <iostream>
#include <sstream>

using namespace std;

struct node {
    int value;
    node *left, *right;
};

class BST {
public:
    BST() {
        root = nullptr;
    };

    ~BST() {
        destroyTree(root);
    }

    int add(int i);

private:
    node *root;

    void destroyTree(node *root);

};

int BST::add(int i) {
    int depth = 0;
    node **pos = &root;
    while (*pos != nullptr) {
        if (i < (*pos)->value) {
            pos = &((*pos)->left);
        } else {
            pos = &((*pos)->right);
        }
        depth++;
    }
    *pos = new node;
    (*pos)->value = i;
    (*pos)->left = nullptr;
    (*pos)->right = nullptr;
    return depth;
}

void BST::destroyTree(node *root) {
    if (root != nullptr) {
        destroyTree(root->left);
        destroyTree(root->right);
        delete root;
    }
}

int main() {
    int N;
    ostringstream oss;
    cin >> N;
    BST tree;
    int counter = 0;
    for (int i = 0; i < N; ++i) {
        int num;
        cin >> num;
        counter += tree.add(num);
        oss << counter << endl;
    }
    cout << oss.str();
    return 0;
}