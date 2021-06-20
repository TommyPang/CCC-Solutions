// Problem: CCC '03 S3 - Floor Plan
// Contest: DMOJ
// URL: https://dmoj.ca/problem/ccc03s3
// Memory Limit: 64 MB
// Time Limit: 1000 ms
// Ryan Liu

#include <bits/stdc++.h>
using namespace std;

#define pb push_back

int m, w, l, x, y, tmr, numr = 0;

vector<int> roomarea;
queue<int> q;
bool used[25][25];
char mc[25][25];
string t;

void bfs(int b, int a) {
  tmr = 1;
  q.push(a);
  q.push(b);
  used[b][a] = true;
  while (!q.empty()) {
    int v1 = q.front();
    q.pop();
    int v2 = q.front();
    q.pop();

    /*for (int u : adj[v]) {
      if (!used[u]) {
        used[u] = true;
        q.push(u);
        dist[u] = dist[v] + 1;
      }

    }*/
    if ((v2 - 1 >= 0) && (!used[v2 - 1][v1]) && mc[v2 - 1][v1] == '.') {
      used[v2 - 1][v1] = true;
      q.push(v1);
      q.push(v2 - 1);
      ++tmr;
    }
    if ((v2 + 1 < l) && (!used[v2 + 1][v1]) && mc[v2 + 1][v1] == '.') {
      used[v2 + 1][v1] = true;
      q.push(v1);
      q.push(v2 + 1);
      ++tmr;
    }
    if ((v1 - 1 >= 0) && (!used[v2][v1 - 1]) && mc[v2][v1 - 1] == '.') {
      used[v2][v1 - 1] = true;
      q.push(v1 - 1);
      q.push(v2);
      ++tmr;
    }
    if ((v1 + 1 < w) && (!used[v2][v1 + 1]) && mc[v2][v1 + 1] == '.') {
      used[v2][v1 + 1] = true;
      q.push(v1 + 1);
      q.push(v2);
      ++tmr;
    }
  }
  roomarea.pb(tmr);
}

int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  memset(used, false, sizeof(used));

  cin >> m >> l >> w;

  // get input
  for (int i = 0; i < l; i++) {
    for (int j = 0; j < w; j++) {
      cin >> mc[i][j];
    }
  }

  for (int i = 0; i < l; i++) {
    for (int j = 0; j < w; j++) {
      if (mc[i][j] == '.' && !used[i][j]) {
        bfs(i, j);
      }
    }
  }

  sort(roomarea.rbegin(), roomarea.rend());

  for (int i = 0; i < roomarea.size(); i++) {
    if ((m - roomarea[i]) >= 0) {
      m -= roomarea[i];
      numr++;

    } else {
      break;
    }
  }

  if (numr == 1) {
    cout << 1 << " room, " << m << " square metre(s) left over"
         << "\n";
    return 0;
  }

  cout << numr << " rooms, " << m << " square metre(s) left over"
       << "\n";
}
