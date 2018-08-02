function solution(A) {
    let arrayLen = A.length;
    let newArr = Array.apply(null, new Array(arrayLen+1)).map(Number.prototype.valueOf, 0);

    A.forEach(element => {
        newArr[element-1] = 1;
    });

    return newArr.indexOf(0) + 1;

}

console.log(solution([2,3,1,5]));