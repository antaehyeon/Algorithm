let ans = [];

const recursion = (arr, n) => {
  if (n * 2 >= arr.length) {
    ans = [...arr, ...ans];
    return;
  }

  let tmp = arr.slice(n, arr.length - n);
  console.log(`[arr:${arr}] [n:${n}] [tmp:${tmp}]`);
  arr.splice(n, arr.length - 2 * n);
  ans = [...arr, ...ans];
  recursion(tmp, n);
};

const solution = (arr, n) => {
  recursion(arr, n);
};

const main = () => {
  let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
  solution(arr, 2);
  arr = ans;
  ans = [];
  solution(arr, 3);
  console.log(ans);

  ans.slice(0, 5).map(v => console.log(v));
};

main();
