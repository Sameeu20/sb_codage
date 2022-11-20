#include <bits/stdc++.h>
using namespace std;

#define iloop(n)    for(int i=0;i<n;i++)
#define jloop(n)    for(int i=0;i<n;i++)
#define all(x)      x.begin(),x.end()
 
typedef long long ll;
typedef std::vector<int> vi;
typedef std::pair<int, int> pii;
typedef std::pair<long, long> pll;
typedef std::vector<std::vector<int>> vvi;
typedef std::vector<pii> vpii;
typedef std::vector<vector<ll>> vvll;
typedef std::vector<ll> vll;
template<class T>
void get(vector<T>& a, int n){iloop(n) {T x; cin>>x;a.push_back(x);}}
 
template<class T>void out(vector<T>& a){for(T e:a) cout<<e<<' ';cout<<'\n';}
 
 void solve()
 {
     int n; cin>>n;
     vi a(n+1);
     for(int i=1;i<=n;i++) cin>>a[i];
     if(n==1)
     {
         cout<<0<<'\n';
         return;
     }
     ll ans=0;
     vector<bool> pre(n+1, false);
     int pre_ext=-1;
     int suf_ext=-1;
     pre[0]=1;
     a[0]=INT_MIN;
     for(int i=1;i<=n;i++)
     {
         pre[i]=pre[i-1]&&(a[i]>a[i-1]);
         if(pre_ext==-1)
         {
             if(pre[i]==0) pre_ext=i-1;
         }
     }
     if(pre_ext==-1) pre_ext=n;
     vector<bool> suf(n+1, false);
     suf[n]=1;
     for(int i=n-1;i>=1;i--)
     {
         suf[i]=suf[i+1]&&(a[i]<a[i+1]);
         if(suf_ext==-1)
         {
             if(suf[i]==0) suf_ext=i+1;
         }
     }
     if(suf_ext!=-1)
      ans+=n-suf_ext+1;
     else
     {
         suf_ext=1;
     }
    
     
     for(int i=1;i<=n-1;i++)
     {
         if(i>pre_ext) break;
         int low=suf_ext;
         int high=n;
         int j=n+1;
         while(low<=high)
         {
             int mid=low+(high-low)/2;
             if(a[mid]>a[i])
             {
                 j=min(j, mid);
                 high=mid-1;
             }
             else
             {
                 low=mid+1;
             }
         }
         ans+=n-j+2;
     }
     cout<<ans<<'\n';
     
     
     
     
 }
 
int main() 
{
    ios_base::sync_with_stdio(false); cin.tie(NULL);
  int T; cin>>T;
  while(T--)
  {
      solve();
  }
 
  return 0;
}
