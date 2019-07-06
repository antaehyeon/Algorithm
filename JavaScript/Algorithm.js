const ADJUST_IDX = 1;

function solution(param) {
  const answer = [];
  let checkedArr;
  let maxNum = 0;

  param.sort((a, b) => a - b);

  maxNum = param[param.length - 1];

  checkedArr = Array(maxNum).fill(0);

  param.map(v => checkedArr[v - ADJUST_IDX]++);

  checkedArr.map(n => {
    if (n > 1) answer.push(n);
  });

  return answer.length === 0 ? [-1] : answer;
}

const t1 = [1, 2, 3, 3, 3, 4, 4];
const t2 = [3, 2, 4, 4, 2, 5, 2, 5, 5];
const t3 = [3, 5, 7, 9, 1];

console.log(solution(t1));
