/* Lesson 02 Arrays
https://app.codility.com/programmers/lessons/2-arrays/ */

function solution(A) {
    let toggle = true;
    let sum = 0;

    A.sort((a, b) => {
        return b - a;
    });

    A.forEach(element => {
        if (toggle) {
            sum += element;
            toggle = false;
        } else {
            sum -= element;
            toggle = true;
        }
    });
    
    return sum;
}

console.log(solution([3, 3, 5, 5, 7]));