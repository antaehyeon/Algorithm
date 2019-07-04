/*
프로그래머스 - 프린터
*/

const FIRST = 0;

function solution(priorities, location) {
  let answer = 0;
  let tasks = priorities.map((v, i) => ({
    lo: i === location,
    value: v
  }));

  while (true) {
    let current = tasks.splice(0, 1)[FIRST];
    if (tasks.some(t => t.value > current.value)) {
      tasks.push(current);
    } else {
      answer++;
      if (current.lo) return answer;
    }
  }

  return answer;
}

const priorities = [2, 1, 3, 2];
const location = 2;

console.log(solution(priorities, location));
