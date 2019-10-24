function solution(A, B) {
  let ans = 0;
  const binary = (A * B).toString(2);

  for (const str of binary) {
    if (str === "1") ans++;
  }

  return ans;
}

function solution2(S) {
  let ans = 0;
  let convertedNumber = parseInt(S, 2);

  while (convertedNumber != 0) {
    if (convertedNumber % 2 === 0) convertedNumber /= 2;
    else convertedNumber -= 1;
    ans++;
  }

  return ans;
}

function solution22(S) {
  let ans = 0;
  let _str = S.replace(/(^0+)/, "");

  if (_str === "") return 0;

  while (_str != "0") {
    ans++;
    const length = _str.length;
    const lastLetter = _str[length - 1];

    if (lastLetter === "1") {
      _str = _str.substr(0, length - 1);
      _str += "0";
    } else {
      _str = _str.substr(0, length - 1);
    }
  }

  return ans;
}

function Num(param) {
  this.data = param;
  // this.value = () => {
  //   return this.data;
  // };
}

// 동일한 프로토타입을 공유하는 N개의 객체 배열을 반환하는 것
//
function solution3(A) {
  const ans = [];

  for (n of A) {
    // console.log(n);
    ans.push(new Num(n));
  }

  // console.log("test", ans[0].value());

  return ans;
}

// console.log(solution(3, 7));
// console.log(solution(100000000, 100000000));
// console.log(solution2("011100"));
// console.log(solution2("1111111"));

// console.log(solution22("011100"));
// console.log(solution22("1"));
// console.log(solution22("000000001"));

const T = solution3([4, 2]);
Num.prototype.value = function() {
  return this.data;
};
console.log(T);
console.log(T[0].value());
console.log(T[1].value());
console.log(T[0].value === T[1].value);
console.log(!T[0].hasOwnProperty("value"));
console.log(!T[1].hasOwnProperty("value"));
