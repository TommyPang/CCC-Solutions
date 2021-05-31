// Problem: CCC '07 S3 - Friends
// Contest: CCC
// URL: https://dmoj.ca/problem/ccc07s3
// Memory Limit: 64 MB
// Time Limit: 1000 ms
// Ryan Liu

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef vector<ll> vi;
#define pb push_back

vector<int> adj[10000];
queue<int> q;

int n, t1, t2;

void bfs(int a, int b) {
  bool used[10000];
  int dist[10000];
  memset(used, false, sizeof(used));
  memset(dist, 0, sizeof(dist));
  q.push(a);
  used[a] = true;
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    for (int u : adj[v]) {
      if (!used[u]) {
        used[u] = true;
        q.push(u);
        dist[u] = dist[v] + 1;
      }
    }
  }

  cout << ((used[b]) ? ("Yes " + to_string(dist[b] - 1)) : "No") << "\n";
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;

  for (int i = 0; i < n; i++) {
    cin >> t1 >> t2;
    adj[t1].pb(t2);
  }

  while ((cin >> t1 >> t2) && ((t1 != 0) && (t2 != 0))) {
    bfs(t1, t2);
  }
}
