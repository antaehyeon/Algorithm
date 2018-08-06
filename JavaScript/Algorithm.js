function solution(A) {

    const set = new Set();
    const arrLen = A.length;
    let i=1;

    A.forEach(element => {
        set.add(element);
    });

    for (i=1; i<=arrLen+1; i++) {
        if (!set.has(i)) return i;
    }
}


console.log(solution([1,3,6,4,1,2]));
console.log(solution([1,2,3]));
console.log(solution([-1,-3]));