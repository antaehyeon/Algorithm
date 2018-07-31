/* Lesson 02 Arrays
https://app.codility.com/programmers/lessons/2-arrays/ */

function solution(A, K) {

    let arrayLen = A.length;
    let repeatNum = K % arrayLen;
    let popNumData;

    for (let i=0; i<repeatNum; i++) {
        popNumData = A.pop();
        A.unshift(popNumData);
    }
    
    return A;
}

console.log(solution([1,2,3,4,5], 3));