/* Lesson 01 Iterations
https://app.codility.com/programmers/lessons/1-iterations/ */

function solution(N) {
    let a = N.toString(2).match(/1+0+1/);
    if (a === null) return 0;
    return a[0].length-2;
}

console.log(solution(9));
console.log(solution(15));
console.log(solution(529));
console.log(solution(20));
console.log(solution(32));
console.log(solution(1041));