// function solution(A) {
//     let count = 1;
//     let arrayLen = A.length;

//     A.sort();

//     for (let i=0; i<arrayLen; i++) {
//         if (count !== A[i]) return 0;
//         count++;
//     }

//     return 1;
// }

function solution(A) {
    var arrayLen = A.length;
    var sum = (arrayLen * (arrayLen+1)) / 2;
    var tap = [];

    for (let i in A) {
        sum -= A[i];
        if(tap[A[i]]) {
            return 0;
        }
        tap[A[i]] = true;
    }
    return +(sum==0);
}


console.log(solution([4,1,3,2]));
console.log(solution([4,1,3]));
console.log(solution([2,3,4,5,6,7,8,9]));
console.log(solution([1,2,2,3,4,5]));