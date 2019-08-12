#include <iostream>
#include <algorithm>
#include <utility>
#include <vector>
#include <string>

using namespace std;

int l, c;
vector<char> alphabet;

bool check(string pw) {
    int mo=0, ja=0;
    for (auto w : pw) {
        if (w=='a' || w=='e' || w=='i' || w=='o' || w=='u') mo++;
        else ja++;
    }

    return ja>=2 && mo>=1;
}


void makePW(string pw, int cnt) {
    // cout << "[pw.length:" << pw.length() << "][pw:" << pw << "]\n";
    if (pw.length() == l) {
        if (check(pw)) cout << pw << "\n";
        return;
    }
    if (cnt >= c) return;
    makePW(pw+alphabet[cnt], cnt+1);
    makePW(pw, cnt+1);
}

int main() {

    cin >> l >> c;

    for (int i=0; i<c; i++) {
        char tmp;
        cin >> tmp;
        alphabet.push_back(tmp);
    }

    sort(alphabet.begin(), alphabet.end());

    makePW("", 0);

    return 0;
}

