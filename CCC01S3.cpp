// Problem: CCC '01 S3 - Strategic Bombing
// Contest: DMOJ
// URL: https://dmoj.ca/problem/ccc01s3
// Memory Limit: 16 MB
// Time Limit: 1000 ms
// Ryan Liu

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef vector<ll> vi;
#define pb push_back

vector<int> adj[27];
queue<int> q;
bool used[27];
vector<string> edges;
string t;
ll sum = 0;

void bfs(int a, int b) {
  q.push(1);
  used[1] = true;
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    for (int u : adj[v]) {
      if (!used[u] && (!(v == a && u == b) && !(v == b && u == a))) {
        used[u] = true;
        q.push(u);
      }
    }
  }
}

void addEdge(int frm, int to) {
  adj[frm].pb(to);
  adj[to].pb(frm);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  while (cin >> t && t != "**") {
    edges.pb(t);
    addEdge((int)t[0] - 64, (int)t[1] - 64);
  }

  for (int i = 0; i < edges.size(); i++) {
    memset(used, false, sizeof(used));
    t = edges[i];
    bfs((int)t[0] - 64, (int)t[1] - 64);

    if (!(used[2])) {
      sum++;
      cout << t << "\n";
    }
  }
  cout << "There are " << sum << " disconnecting roads.\n";
}
