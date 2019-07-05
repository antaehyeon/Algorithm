/*
프로그래머스 - 정렬 - K번째 수
*/

// function solution(numbers) {
//   var answer = "";

//   numbers.sort().reverse();
//   // console.log(numbers);

//   numbers.map((n, i) => {
//     if (numbers.length - 1 != i && (n + "").split("").includes("0")) {
//       numbers.push(numbers.splice(i, 1));
//       // console.log(1, numbers);
//       // console.log(2, numbers[i + 1]);
//       answer += numbers[i];
//       // console.log(3, answer);
//       // console.log(4, n);
//     } else answer += n;
//   });

//   return answer;
// }
function solution(numbers) {
  const answer = numbers
    .map(v => v + "")
    .sort((a, b) => (b + a) * 1 - (a + b) * 1)
    .join("");

  return answer[0] === "0" ? "0" : answer;
}

const t1 = [6, 10, 2];
const t2 = [3, 30, 34, 5, 9];
console.log(solution(t1));
