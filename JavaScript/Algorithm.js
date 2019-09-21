const MAX = 1000;
const map = [];
let size = 0;

const dx = [];

const explorer = start => {
  let isStar = false;
  let x = start;
  let y = 0;

  while (true) {
    const type = map[y][x];
    console.log(type);
    if (type === "#") {
      y++;
      if (y >= size) return true;
    } else if (type === ">") {
      x++;
    } else if (type === "<") {
      x--;
    } else if (type === "*") {
      y++;
      if (isStar) return false;
      isStar = true;
    }
  }
};

const solution = drum => {
  let ans = 0;
  size = drum.length;
  //   console.log(drum);

  for (const s of drum) {
    // console.log("[s]", s);
    const splited = s.split("");
    // console.log(splited);
    map.push(splited);
  }

  //   console.log(drum.length);

  for (let i = 0; i < size; i++) {
    if (explorer(i)) ans++;
  }

  console.log(ans);
};

solution(["######", ">#*###", "####*#", "#<#>>#", ">#*#*<", "######"]);
