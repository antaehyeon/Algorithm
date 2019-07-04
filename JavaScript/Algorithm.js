/*
프로그래머스 - 다리를 지나는 트럭
*/

class Queue {
  constructor() {
    this._arr = [];
  }
  enqueue(item) {
    this._arr.push(item);
  }
  dequeue() {
    return this._arr.shift();
  }
  sum() {
    let sum = 0;
    for (const data of this._arr) sum += data;

    return sum;
  }
  count() {
    return this._arr.length;
  }
}

function solution(bridge_length, weight, truck_weights) {
  var time = 0;
  console.log(time);

  const isFlag = truck_weights.length % 2 != 0;

  const bridge = new Queue();

  while (true) {
    if (time === 98) {
      // console.log("98");
    }

    if (time % bridge_length === 0) {
      bridge.dequeue();
    }
    if (truck_weights.length === 0 && bridge.count() === 0) break;
    time++;

    if (truck_weights.length === 0) continue;

    const truckWeight = truck_weights.shift();

    if (bridge.sum() + truckWeight > weight) {
      truck_weights.unshift(truckWeight);
      continue;
    }

    bridge.enqueue(truckWeight);
  }

  return time + isFlag;
}

console.log(solution(2, 10, [7, 4, 5, 6]));
console.log(solution(100, 100, [10]));
console.log(solution(100, 100, [10, 10, 10, 10, 10, 10, 10, 10, 10, 10]));
