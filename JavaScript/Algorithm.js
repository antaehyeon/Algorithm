/* Codility Lesson 7 Stacks and Queues 'Fish'
https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/ */

function solution (A, B) {
    
    let aliveFishNum = A.length;
    const fishNum = A.length;
    const bottomFishes = [];

    const peek = function(stack) {
        return stack.slice(-1)[0];
    }

    for (let i=0; i<fishNum; i++) {

        // 하류로 이동하는 물고기들을 스택에 담기
        if (B[i] == 1) {
            bottomFishes.push(A[i]);
            continue;
        }

        while (bottomFishes.length) {
            aliveFishNum--;
            if (peek(bottomFishes) > A[i]) {
                break;
            } else {
                bottomFishes.pop();
            }
        }
    }

    return aliveFishNum;
}

const A = [4, 3, 2, 1, 5];
const B = [0, 1, 0, 0, 0];

console.log(solution(A, B));