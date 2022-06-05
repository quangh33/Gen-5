var canVisitAllRooms = function (g) {
    let V = g.length;

    let visitedAll = new Array(V).fill(false);
    let visitedCount = 0;

    const dfs = (u) => {
        if (!visitedAll[u]) {
            visitedAll[u] = true;

            visitedCount++;
            for (let v of g[u]) {
                dfs(v);
            }
        }
    };

    dfs(0);
    return visitedCount == V;
};

// https://leetcode.com/problems/keys-and-rooms/