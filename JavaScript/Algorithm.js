function solution(A, B, K) {
    return Math.floor(B/K) + ((A%K === 0) ? 1 : 0) - Math.floor(A/K);
}

console.log(solution(6, 11, 2));