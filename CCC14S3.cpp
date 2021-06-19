// Problem: CCC '14 S3 - The Geneva Confection
// Contest: DMOJ
// URL: https://dmoj.ca/problem/ccc14s3
// Memory Limit: 64 MB
// Time Limit: 3000 ms
// Ryan Liu

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
#define pb push_back

deque<ll> m, b;
ll n, temp, cur;
bool pos = true;

void solve() {
  // Initialize each variable for a new test case
  m.clear();
  b.clear();
  pos = true;
  cur = 1;

  cin >> n;

  for (ll j = 0; j < n; j++) {
    cin >> temp;
    m.pb(temp);
  }

  while (cur != n) {
    if (m.empty() && (cur != b.back())) {
      pos = false;
      break;
    }
    if (!(m.empty()) && m.back() == cur) {
      m.pop_back();
      cur++;
    } else if (!(b.empty()) && (b.back() == cur)) {
      b.pop_back();
      cur++;
    }

    else if (!m.empty()) {
      b.pb(m.back());
      m.pop_back();
    }
  }

  cout << ((pos) ? "Y" : "N") << "\n";
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int tc;
  cin >> tc;
  for (int t = 1; t <= tc; t++) {
    solve();
  }
}
