/**
 * @param {number[][]} rooms
 * @return {boolean}
 */

 let dfs = (room, visited, rooms) => {
    if (visited[room]) return
    visited[room] = true
    for (let i = 0; i < rooms[room].length; i++) {
        dfs(rooms[room][i], visited, rooms)
    }
}

var canVisitAllRooms = function(rooms) {
    let visited = new Array(rooms.length).fill(false)
    dfs(0, visited, rooms)
    return visited.every(room => !!room)
};
