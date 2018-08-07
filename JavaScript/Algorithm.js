function solution(A) {

    const AL = A.length;
    let COUNT = 0;
    let PLUS = 0;

    for (I = 0; I < AL; I++) {
        if (A[I] === 0) PLUS++;
        else COUNT += PLUS;
    }
    
    return COUNT;
}

console.log(solution([0,1,0,1,1]));