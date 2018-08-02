function solution(A) {
    let arrayLen = A.length;
    const arrayDataSum = A.reduceRight((a, b) => {return a+b;});
    let arrayDataSumByIndex = 0;
    const calculatedDataArr = [];

    let leftSum = 0;
    let rightSum = arrayDataSum;

    for (let i=1; i<arrayLen; i++) {
        leftSum += A[i-1];
        rightSum -= A[i-1];
        const temp = Math.abs(leftSum - rightSum);
        calculatedDataArr.push(temp);
    }

    let minData = calculatedDataArr.reduce((previous, current) => {
        return previous > current ? current : previous;
    });

    return minData;
}

console.log(solution([3,1,2,4,3]));
console.log(solution([0,1,2,-5,2]));
console.log(solution([-1, 1]));