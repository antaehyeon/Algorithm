/*
프로그래머스 - 부스트캠프 2019 데모테스트 1
*/

<<<<<<< Updated upstream
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
=======
const X = 0;
const Y = 1;

const ONE = 1;

function solution(v) {
  const answer = [];

  const x = [];
  const y = [];

  v.some(lo => {
    console.log(x.includes(lo[X]));
    console.log(y.includes(lo[Y]));

    if (x.includes(lo[X])) x.splice(x.indexOf(lo[X]), ONE);
    else x.push(lo[X]);

    if (y.includes(lo[Y])) y.splice(y.indexOf(lo[Y]), ONE);
    else y.push(lo[Y]);
  });

  console.log(x);
  console.log(y);
  // console.log(x.concat(y));

  return x.concat(y);
}
const v = [[1, 4], [3, 4], [3, 10]];

console.log(solution(v));
>>>>>>> Stashed changes
