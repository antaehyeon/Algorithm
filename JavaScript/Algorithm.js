/*
프로그래머스 - 쇠막대기
*/
function solution(arrangement) {
  var answer = 0;

  let isBrackCloseMode = false;
  const stack = [];

  for (const letter of arrangement) {
    console.log("스택 변경 전", stack);
    if (letter === "(") {
      stack.push("(");
      isBrackCloseMode = false;
    } else {
      stack.pop();
      if (isBrackCloseMode) {
        answer++;
        continue;
      }
      isBrackCloseMode = true;
      answer += stack.length;
    }
    console.log("스택 변경 후", stack);
    console.log("answer", answer);
  }

  return answer;
}

console.log(solution("()(((()())(())()))(())"));
