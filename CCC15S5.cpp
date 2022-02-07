#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
/**
 * CCC '15 S5 - Greedy For Pies
 * Question URL: Dynamic Programming
 * 15/15 on DMOJ
 * Question URL: https://dmoj.ca/problem/ccc15s5
 * @author Tommy Pang
 */
int n, m;
ll dp[3005][105][105][2];
int A[3005], B[3005];
ll fun(int i, int L, int R, int can) {
    if (dp[i][L][R][can]!=-1) return dp[i][L][R][can];
    ll ret = 0;
    if (i<=n) {
        // take current one
        if (can==1) ret = max(ret, fun(i+1, L, R, 0) + A[i]);
        // skip current one
        ret = max(ret, fun(i+1, L, R, 1));
    }
    if (L<=R) {
        // insert and waste current one
        ret = max(ret, fun(i, L+1, R, 1));
        // insert and take current one
        if (can==1) ret = max(ret, fun(i, L, R-1, 0) + B[R]);
    }
    dp[i][L][R][can] = ret;
    return ret;
}
int main(){
    ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
    cin>>n;
    memset(dp, -1, sizeof (dp));
    for (int i = 1; i <= n; ++i) {
        cin>>A[i];
    }
    cin>>m;
    for (int i = 1; i <= m; ++i) {
        cin>>B[i];
    }
    sort(B, B+m+1);
    cout<<fun(1, 1, m, 1);

}
