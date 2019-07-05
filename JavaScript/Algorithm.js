/*
프로그래머스 - 완전탐색 - 모의고사 (LV1)
*/

const F1 = [1, 2, 3, 4, 5];
const F2 = [2, 1, 2, 3, 2, 4, 2, 5];
const F3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];

const A = 0;
const B = 1;
const C = 2;

function solution(answers) {
  const answer = [];
  const players = [{ player: 1, score: 0 }, { player: 2, score: 0 }, { player: 3, score: 0 }];

  answers.map((ans, idx) => {
    const A_IDX = idx % 5;
    const B_IDX = idx % 8;
    const C_IDX = idx % 10;

    if (F1[A_IDX] === ans) players[A].score++;
    if (F2[B_IDX] === ans) players[B].score++;
    if (F3[C_IDX] === ans) players[C].score++;
  });

  players.sort((a, b) => b.score - a.score);

  answer.push(players[A].player);

  if (players[A].score === players[B].score) answer.push(players[B].player);
  if (players[A].score === players[C].score) answer.push(players[C].player);

  answer.sort();

  return answer;
}

const answers1 = [1, 2, 3, 4, 5];
const answers2 = [1, 3, 2, 4, 2];
const a3 = [2, 3, 2, 1, 5];

console.log(solution(a3));
