#include <iostream>
#include <algorithm>

using namespace std;
string a[20000];
int n;
bool compare(string a, string b) {
    if (a.length() == b.length()){
        return a < b;
    } else {
        return a.length() < b.length();
    }
}

int main() {
    cin >> n;
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    }
    sort(a, a + n, compare);
    for(int i = 0; i<n; i++) {
        if(a[i] == a[i-1]){
            continue;
        }
        cout << a[i]<< endl;
    };
    return 0;
}
