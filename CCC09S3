// Problem: CCC '09 S3 - Degrees Of Separation
// Contest: DMOJ
// URL: https://dmoj.ca/problem/ccc09s3
// Memory Limit: 64 MB
// Time Limit: 1000 ms
// Ryan Liu

#include <bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef vector<ll> vi;
typedef pair<ll, ll> pp;
#define mp make_pair
#define pb push_back

vector<int> adj[51];
queue<int> q;
bool used[51];
int dist[51];
string t;
int x, y, sum;

void bfs(int x) {
  q.push(x);
  used[x] = true;
  while (!q.empty()) {
    int v = q.front();
    q.pop();
    for (int u : adj[v]) {
      if (!used[u]) {
        dist[u] = dist[v] + 1;
        used[u] = true;
        q.push(u);
      }
    }
  }
}
void ae(int a, int b) {
  adj[a].pb(b);
  adj[b].pb(a);
}

void ifunc() {
  cin >> x >> y;

  if (!(find(adj[x].begin(), adj[x].end(), y) != adj[x].end())) {
    adj[x].pb(y);
    adj[y].pb(x);
  }
}
void dfunc() {
  cin >> x >> y;
  adj[x].erase(std::remove(adj[x].begin(), adj[x].end(), y), adj[x].end());
  adj[y].erase(std::remove(adj[y].begin(), adj[y].end(), x), adj[y].end());
}
void nfunc() {
  cin >> x;
  cout << adj[x].size() << "\n";
}
void ffunc() {
  memset(used, false, sizeof(used));
  memset(dist, 0, sizeof(dist));
  cin >> x;
  sum = 0;
  bfs(x);
  for (int i = 1; i <= 50; i++) {
    if (dist[i] == 2) {
      sum++;
    }
  }

  cout << sum << "\n";
}
void sfunc() {
  cin >> x >> y;
  memset(used, false, sizeof(used));
  memset(dist, 0, sizeof(dist));

  bfs(x);

  cout << ((used[y]) ? to_string(dist[y]) : "Not connected") << "\n";
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);

  ae(2, 6);
  ae(1, 6);

  ae(3, 6);
  ae(4, 6);
  ae(5, 6);
  ae(7, 6);

  ae(3, 4);
  ae(5, 4);
  ae(3, 5);

  ae(3, 15);
  ae(15, 13);
  ae(13, 14);

  ae(13, 12);
  ae(11, 12);
  ae(9, 12);
  ae(11, 10);
  ae(9, 10);
  ae(9, 8);
  ae(7, 8);

  ae(17, 16);
  ae(18, 16);
  ae(17, 18);
  while (cin >> t && (t != "q")) {
    if (t == "i") {
      ifunc();
    } else if (t == "d") {
      dfunc();
    } else if (t == "n") {
      nfunc();

    } else if (t == "f") {
      ffunc();
    } else if (t == "s") {
      sfunc();
    }
  }
}
