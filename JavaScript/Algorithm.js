/* Codility Lesson 7 Stacks and Queues 'Fish'
https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/ */

function solution (A, B) {
    
    let aliveFishNum = A.length;
    const fishNum = A.length;
    const bottomFishes = [];

    for (let i=0; i<fishNum; i++) {

        // 하류로 이동하는 물고기들을 스택에 담기
        if (B[i] == 1) bottomFishes.push(A[i]);
        else if (bottomFishes.length == 0) continue;
        else if (bottomFishes.slice(-1)[0] > A[i]) aliveFishNum--;
        else { 
            bottomFishes.pop();
            aliveFishNum--;
        }
    }

    return aliveFishNum;
}

const A = [4, 3, 2, 1, 5];
const B = [0, 1, 0, 0, 0];

console.log(solution(A, B));

// const array = [1, 2, 3, 4, 5];

// console.log(array);

// const a = array.pop();

// console.log(array);

// array.push(5);

// console.log(array);

// // const b = array.peek();

// // console.log(b);

// console.log(array.length);

// console.log(array.slice(-1)[0]);

// console.log(array);