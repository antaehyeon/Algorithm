function solution(X, Y, D) {

    let a = Y-X;

    if (a === 0) {
        return 0;
    }

    let b = Math.floor(a/D);

    if (a % D !== 0) {
        b++;
    }
    
    return b;
}

console.log(solution(10, 85, 30));