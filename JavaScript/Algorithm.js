function solution(N, A) {

    const flagArr = Array.apply(null, new Array(N)).map(Number.prototype.valueOf, 0);
    let max = 0;
    let arrLen = A.length;
    let count = 0;

    while (arrLen !== count) {
        if (A[count] === N+1) {
            for (let i=0; i<N; i++) {
                flagArr[i] = max;
            }
        } else {
            flagArr[A[count]-1]++;
            max = (max < flagArr[A[count]-1]) ? flagArr[A[count]-1] : max;
        }
        count++;
    }

    return flagArr;
}

console.log(solution(5, [3,4,4,6,1,4,4]));