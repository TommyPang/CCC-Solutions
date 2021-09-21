/**
 * CCC '21 S4 - Daily Commute
 * Question type: Graph Theory
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc21s4
 * @author Tommy Pang
 */
#include <bits/stdc++.h>
using namespace std;
const int MM = 2e5+5;
typedef pair<int, int> pi;
int N, W, D, s[MM], idx[MM], dis[MM]; vector<int> adj[MM]; bool vis[MM]; set<pi> st;
void bfs(int st){
    fill(dis, dis+N+1, 1e9);
    queue<int> q; q.push(st); dis[st]=0; vis[st]=true;
    while(!q.empty()){
        int u = q.front(); q.pop();
        for(int v: adj[u]){
            if(!vis[v]) { q.push(v); dis[v] = dis[u] + 1; vis[v] = true;}
        }
    }
}
int main(){
    ios::sync_with_stdio(0); cin.tie(0);
    cin >> N >> W >> D;
    for(int i=1, u, v; i<=W; i++){
        cin >> u >> v; adj[v].push_back(u);
    }
    bfs(N);
    for(int i=1; i<=N; i++){
        cin >> s[i];  idx[s[i]] = i - 1;
    }
    for(int i=1; i<=N; i++){
        st.insert({idx[i] + dis[i], i});
    }
    for(int i=1, x, y; i<=D; i++){
        cin >> x >> y;  int sx = s[x], sy = s[y];
        st.erase({idx[sx]+dis[sx], sx}); st.erase({idx[sy]+dis[sy], sy});
        swap(idx[sx], idx[sy]); swap(s[x], s[y]);
        st.insert({idx[sx]+dis[sx], sx}); st.insert({idx[sy]+dis[sy], sy});
        cout << st.begin()->first << "\n";
    }
}
