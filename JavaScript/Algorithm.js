const ADJUST_IDX = 1;
const EMPTY = 0;
const ONE = 1;

const A = 1;
const B = 2;
const SAME = 0;

const FIRST = 0;

const sortArrAscending = arr => {
  const _arr = arr.slice();
  return _arr.sort((a, b) => a - b);
};

const createPairInfo = (v, i) => {
  return {
    num: i,
    pairGrade: v > 4 ? 4 : v
  };
};

const findPair = arr => {
  const pairedArr = [];
  const checkedArr = Array(14).fill(0);
  const _arr = sortArrAscending(arr);

  _arr.map(v => checkedArr[v]++);

  checkedArr.map((v, i) => {
    if (v > 1) {
      pairedArr.push(createPairInfo(v, i));
    }
  });

  return pairedArr;
};

const compareNumber = (a, b) => {
  if (a > b) return A;
  else if (a < b) return B;
  else return SAME;
};

const comparePairNum = (n1, n2) => {
  if (compareNumber(n1, n2) === A) return A;
  if (compareNumber(n1, n2) === B) return B;
  if (compareNumber(n1, n2) === SAME) return SAME;
};

const comparePairGrade = (g1, g2) => {
  if (compareNumber(g1, g2) === A) return A;
  if (compareNumber(g1, g2) === B) return B;
  if (compareNumber(g1, g2) === SAME) return SAME;
};

const comparePair = (arr1, arr2) => {
  const firstArrLength = arr1.length;
  const secondArrLength = arr2.length;

  const checkArrEmpty = (a, b) => a === EMPTY && b === EMPTY;
  const checkArrNumCondition = (a, b) => a >= ONE && b === EMPTY;
  const checkArrNumSame = (a, b) => a === b;

  if (checkArrEmpty(firstArrLength, secondArrLength)) return 0;
  if (checkArrNumCondition(firstArrLength, secondArrLength)) return A;
  if (checkArrNumCondition(secondArrLength, firstArrLength)) return B;

  arr1.sort((a, b) => b.num - a.num);
  arr1.sort((a, b) => b.pairGrade - a.pairGrade);
  arr2.sort((a, b) => b.num - a.num);
  arr2.sort((a, b) => b.pairGrade - a.pairGrade);

  console.log(1, arr1);
  console.log(2, arr2);

  if (checkArrNumSame(firstArrLength, secondArrLength)) {
    if (comparePairGrade(arr1[FIRST].pairGrade, arr2[FIRST].pairGrade) === SAME) {
      return comparePairNum(arr1[FIRST].num, arr2[FIRST].num);
    } else return comparePairGrade(arr1[FIRST].pairGrade, arr2[FIRST].pairGrade);
  } else {
    if (comparePairGrade(arr1[FIRST].pairGrade, arr2[FIRST].pairGrade) === SAME) {
      return comparePairNum(arr1[FIRST].num, arr2[FIRST].num);
    } else return comparePairGrade(arr1[FIRST].pairGrade, arr2[FIRST].pairGrade);
  }
};

function solution(arr1, arr2) {
  const pairArr1 = findPair(arr1);
  const pairArr2 = findPair(arr2);

  // console.log(1, pairArr1);
  // console.log(2, pairArr2);

  return comparePair(pairArr1, pairArr2);
}

const a1 = [1, 5, 7, 2, 9, 13, 10];
const b1 = [2, 3, 9, 10, 4, 8, 11];

const a2 = [1, 4, 1, 3, 5, 6, 10];
const b2 = [9, 2, 3, 1, 3, 4, 10];

const a3 = [1, 1, 9, 4, 1, 3, 11];
const b3 = [2, 3, 3, 13, 12, 9, 9];

const a4 = [1, 4, 4, 4, 1, 10, 4];
const b4 = [11, 13, 11, 3, 11, 9, 1];

const a5 = [1, 2, 2, 3, 2, 2, 2];
const b5 = [4, 5, 4, 5, 4, 5, 4];

const a6 = [1, 4, 9, 4, 1, 10, 13];
const b6 = [11, 13, 9, 3, 1, 9, 1];

// console.log(solution(a1, b1));
// console.log(solution(a2, b2));
// console.log(solution(a3, b3));
// console.log(solution(a4, b4));
// console.log(solution(a5, b5));
console.log(solution(a6, b6));
