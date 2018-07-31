/* Lesson 01 Iterations
https://app.codility.com/programmers/lessons/1-iterations/ */

function solution(N) {
    let max = 0;
    let s = N.toString(2);
    let a = s.match(/1+0+1/);
    let c = s;

    while(true) {

        if (a === null) return 0;

        let b = c.match(/1+0+1/);

        if (b === null) break;
        else {
            let temp = b[0].replace(/1/gi, '').length;
            max = (temp > max) ? temp : max;
        }

        c = c.replace(/1+0+/, '');
    }

    return max;
}

// console.log(solution(9));
// console.log(solution(15));
// console.log(solution(529));
// console.log(solution(20));
// console.log(solution(32));
// console.log(solution(1041));
// console.log(solution(1162));
console.log(solution(51712));