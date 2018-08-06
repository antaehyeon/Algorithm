function solution(X, A) {

    const set = new Set();
    let repeatCount = 0;
    let endNum = (X * (X+1)) / 2;

    A.forEach(element => {
        set.add(element);
        if (set.size === X) return;
        repeatCount++;
    });

    if (repeatCount === A.length) return -1;

    return repeatCount;
}


console.log(solution(5, [1,3,1,4,2,3,5,4]));