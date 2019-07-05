/*
프로그래머스 - 정렬 - K번째 수
*/

const TRIM_START_IDX = 0;
const TRIM_END_IDX = 1;
const FIND_IDX = 2;
const ADJUST_IDX = 1;

function solution(array, commands) {
  const answer = [];

  commands.map((command, idx) => {
    const i = command[TRIM_START_IDX];
    const j = command[TRIM_END_IDX];
    const k = command[FIND_IDX];

    // console.log(0, array);
    const trimedArr = array.slice(i - ADJUST_IDX, j);
    // console.log(1, trimedArr);
    trimedArr.sort((a, b) => a - b);
    // console.log(2, trimedArr);
    answer.push(trimedArr[k - ADJUST_IDX]);
    // console.log(3, trimedArr[k - ADJUST_IDX]);
  });

  return answer;
}

const array = [1, 5, 2, 6, 3, 7, 4];
const commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];
console.log(solution(array, commands));
