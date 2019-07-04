/*
프로그래머스 - 프린터
*/

// 정확성 50 효율성 0
// function solution(participant, completion) {
//   var answer = "";

//   participant.some(t => {
//     completion.map((v, i) => {
//       if (t === v) {
//         completion.splice(i, 1);
//         return;
//       }
//     });

//   });

//   return answer;
// }

function solution(participant, completion) {
  let answer;
  let idx = 0;
  participant.sort();
  completion.sort();

  // console.log({ participant, completion });

  participant.some(value => {
    if (completion[idx] != value) {
      answer = value;
      return true;
    }
    idx++;
  });

  return answer;
}

const participant = ["mislav", "stanko", "mislav", "ana"];
const completion = ["stanko", "ana", "mislav"];

console.log(solution(participant, completion));
