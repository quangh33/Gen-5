/**
 * @param {number[][]} rooms
 * @return {boolean}
 */
var canVisitAllRooms = function (rooms) {
  const visited = [];
  let count = 0;

  function visit(key) {
    visited[key] = true;
    count++;

    for (let k of rooms[key]) {
      if (!visited[k]) {
        visit(k);
      }
    }
  }

  visit(0);

  return count === rooms.length;
};
