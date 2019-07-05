const ADJUST_IDX = 1;

function solution(n, lost, reserve) {
  let answer = 0;

  const newLost = lost.filter(a => !reserve.includes(a));
  const newReserve = reserve.filter(a => !lost.includes(a));

  const arr = Array(n).fill(true);

  newLost.map(v => {
    arr[v - ADJUST_IDX] = false;
  });

  newReserve.map(v => {
    if (v - 2 >= 0) {
      if (!arr[v - 2]) {
        arr[v - 2] = true;
        return;
      }
    }

    if (v != n) {
      if (!arr[v]) arr[v] = true;
    }
  });

  answer = arr.filter((v, i) => arr[i]).length;

  return answer;
}

const n = 3;
const lost = [1, 2];
const reserve = [2, 3];

console.log(solution(n, lost, reserve));
