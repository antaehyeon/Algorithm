let card = 20000;

const solution = param => {
  let price = 720;

  console.log(param);
  if (param > 40) {
    const a = Math.floor((param - 40) / 8);
    const b = param % 8;
    console.log(`a: ${a}, b: ${b}`);
    price += a * 80;
    if (b > 0) price += 80;
    console.log(price);
  }

  return price;
};

const main = () => {
  const data = "11 128 15 111 59 31 70 102 50 172 88 56 40 41 12";
  const splited = data.split(" ");
  let sum = 0;

  for (const n of splited) {
    sum += solution(n);
  }

  console.log(20000 - sum);
};

main();
