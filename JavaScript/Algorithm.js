function solution(n) {
    let answer = [[]];
    hanoi(n, 1, 2, 3);

    function hanoi(n, from, by, to) {
        if (n==1) {
            registerMovePath(from, to);        
        } else {
            hanoi(n-1, from, to ,by);
            registerMovePath(from, to);
            hanoi(n-1, by, from, to);
        }
    }

    function registerMovePath(from, to) {
        const tmpArray = [from, to];
        answer[0].push(from, to);
    }

    return answer;
}

console.log(solution(2));
