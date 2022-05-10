public class GraphConnectivityThreshold {
    public IList<bool> AreConnected(int n, int threshold, int[][] queries) {
        var unionFind = new UnionFind(n);
        
        for (var i = 1; i < n; i++)
        {
            for (var j = 2; j <= n; j++)
            {
                var product = i * j;
                if(product > n) break;
                
                if (i > threshold)
                {
                    unionFind.Union(i, product);
                }
            }
        }
        
        return queries.Select(query => unionFind.IsConnected(query[0], query[1])).ToList();
    }
}

public class UnionFind
{
    private readonly int[] _nodes;
    private readonly int[] _sizes;
    
    public UnionFind(int n) {
        _nodes = Enumerable.Range(0, n + 1).ToArray();
        _sizes = Enumerable.Repeat(1, n + 1).ToArray();
    }
    
    public bool IsConnected(int p, int q) => Find(p) == Find(q);
    
    public bool Union(int p, int q) {
        var pNode = Find(p);
        var qNode = Find(q);
        
        if(pNode == qNode) {
            return false;
        }
        
        if(_sizes[pNode] > _sizes[qNode]) {
            _sizes[pNode] += _sizes[qNode];
            _nodes[qNode] = pNode;
        }
        else {
            _sizes[qNode] += _sizes[pNode];
            _nodes[pNode] = qNode;
        }
        
        return true;
    }
    
    public int Find(int p) {
        if(p == _nodes[p]) return p;
        
        _nodes[p] = Find(_nodes[p]);
            
        return _nodes[p];
    }
}