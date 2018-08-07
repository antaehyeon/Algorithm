function solution(A, B, K) {

    let COUNT = 0;

    for (I=A; I<=B; I++) {
        if (I % K === 0) COUNT++;
    }

    return COUNT;
}

console.log(solution(6, 11, 2));