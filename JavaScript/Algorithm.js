function solution(A, B, K) {

    let COUNT = 0;

    while(true) {
        if (A % K === 0) break;
        A++;
    }

    while(true) {
        if (A > B) break;
        A += K;
        COUNT++;
    }

    return COUNT;
}

console.log(solution(6, 11, 2));