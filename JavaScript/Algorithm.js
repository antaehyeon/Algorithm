/*
프로그래머스 - 해시 - 위장
*/
// 33.3 / 100
const GENRE = 0;
const PLAY_NUM = 1;
const INDEX = 0;
const VALUE = 1;

function solution(genres, plays) {
  const answer = [];

  const a = new Map();
  const b = [];
  let chkCount = 0;

  genres.map((genre, i) => {
    if (!a.get(genre)) a.set(genre, plays[i]);
    else a.set(genre, plays[i]);

    b.push({
      genre,
      value: { index: i, playNum: plays[i] }
    });
  });

  const sortedA = [...a.entries()];
  sortedA.sort((a, b) => b[PLAY_NUM] - a[PLAY_NUM]);
  b.sort((a, b) => a.value.index - b.value.index && b.value.playNum - a.value.playNum);

  // console.log(1, sortedA);
  // console.log(2, b);

  sortedA.some(p => {
    const genre = p[GENRE];

    chkCount = 0;

    b.some(data => {
      if (genre === data.genre) {
        chkCount++;
        answer.push(data.value.index);
      }

      return chkCount === 2;
    });
  });

  return answer;
}

const genres = ["classic", "pop", "classic", "classic", "pop"];
const plays = [800, 2500, 150, 800, 2500];

console.log(solution(genres, plays));
