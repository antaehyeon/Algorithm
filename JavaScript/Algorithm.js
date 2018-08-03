function solution(A) {

    let count = 1;

    A.sort();
    
    for (let element of A) {
        if (element !== count) return 0;
        count++;
    }

    return 1;
}

console.log(solution([4,1,3,2]));
console.log(solution([4,1,3]));