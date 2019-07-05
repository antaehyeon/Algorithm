/*
프로그래머스 - 완전탐색 - 카펫 (LV2)
*/

function solution(brown, red) {
  var answer = [];

  const sumXY = brown / 2 + 2;
  let x = sumXY;
  let y = 1;

  while (y <= x) {
    x = sumXY - y;
    if (x * y === brown + red) break;
    else y++;
  }

  return [x, y];
}

const brown = 24;
const red = 24;

console.log(solution(brown, red));
