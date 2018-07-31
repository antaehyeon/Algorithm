/* Lesson 02 Arrays
https://app.codility.com/programmers/lessons/2-arrays/ */

function solution(A) {
    let arr = [];
    let a;

    A.forEach(element => {
        a = arr.indexOf(element);
        if (a !== -1) {
            arr.splice(a, 1);
        } else {
            arr.push(element);
        }
    });
    
    return arr[0];
}

console.log(solution([3, 3, 5, 5, 7]));