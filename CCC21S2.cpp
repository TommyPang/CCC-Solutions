#include <bits/stdc++.h>
using namespace std;
int m, n, k, num, sumr = 0,sumc=0;
char act;

int col[5000000];
int row[5000000];


int main()
{
    cin.tie(0);
    ios::sync_with_stdio(0);
    cin >> m >> n >> k;

    for(int i=0;i<m;i++){
        row[i]=0;
    }
    for(int i=0;i<n;i++){
        col[i]=0;
    }

    for(int i=0;i<k;i++){
        cin >> act >> num;
        if(act=='R'){
            row[num-1]  = (row[num-1]+1)%2;
        }
        else{
            col[num-1] = (col[num-1] +1 )%2;

        }
    }
    for(int i=0;i<m;i++){
        sumr+= row[i];
    }
    for(int i=0;i<n;i++){
        sumc+=col[i];
    }

    cout <<( sumc * (m-sumr)  + (sumr)*(n-sumc) );
}
