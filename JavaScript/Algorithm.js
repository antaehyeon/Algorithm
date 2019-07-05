/*
프로그래머스 - 해시 - 위장
*/

const CLOTHE = 0;
const CLOTHE_TYPE = 1;

// 21.4 / 100
// function solution(clothes) {
//   let answer = 0;

//   let isExisting = false;
//   const t = [];

//   clothes.some(v => {
//     t.some(value => {
//       if (value.clotheType === v[CLOTHE_TYPE]) {
//         isExisting = true;
//         value.clotheNum++;
//         return true;
//       }
//     });

//     if (!isExisting) {
//       isExisting = false;
//       t.push({
//         clotheType: v[CLOTHE_TYPE],
//         clotheNum: 1
//       });
//     }
//   });

//   t.map((value, idx) => {
//     for (let i = idx + 1; i < t.length; i++) {
//       answer += value.clotheNum * t[i].clotheNum;
//     }
//   });

//   return answer + clothes.length;
// }

function solution(clothes) {
  let answer = 1;
  const map = new Map();

  clothes.map((clothe, idx) => {
    const clotheType = clothe[CLOTHE_TYPE];
    if (!map.get(clotheType)) map.set(clotheType, 1);
    else map.set(clotheType, map.get(clotheType) + 1);
  });

  Array.from(map.values()).some(clotheN => {
    answer *= clotheN + 1;
  });

  return answer - 1;
}

const t1 = [["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]];
const t2 = [["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]];
console.log(solution(t1));
