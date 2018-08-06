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

function solution(X, A) {

    return A.indexOf(X);

}


console.log(solution(5, [1,3,1,4,2,3,5,4]));