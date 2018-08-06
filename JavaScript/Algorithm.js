function solution(X, A) {

    const set = new Set();
    let repeatCount = 0;
    let endNum = (X * (X+1)) / 2;

    A.forEach(element => {
        set.add(element);
        if (Array.from(set).reduceRight((a,b) => {return a+b;}) === endNum) return;
        repeatCount++;
    });

    return repeatCount;
}


console.log(solution(5, [1,3,1,4,2,3,5,4]));