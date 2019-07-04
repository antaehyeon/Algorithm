/*
프로그래머스 - 탑
*/

function solution(heights) {
  var answer = [];
  const topNumbers = heights.length;

  heights.reverse();

  for (const topIdx in heights) {
    for (let i = parseInt(topIdx) + 1; i <= topNumbers; i++) {
      if (heights[topIdx] < heights[i]) {
        answer.push(topNumbers - i);
        break;
      }
      if (i === topNumbers) {
        answer.push(0);
      }
    }
  }

  answer.reverse();

  return answer;
}

console.log(solution([6, 9, 5, 7, 4]));
