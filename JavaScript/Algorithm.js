(() => {
  let jin = 0;
  let ans = 0;
  const test = 10;

  for (let i = 2; i <= 9; i++) {
    let tmp = 1;
    const a = test.toString(i);
    console.log(a);

    for (const n of a) {
      if (n != 0) tmp *= n;
    }

    if (ans <= tmp) {
      jin = i;
      ans = tmp;
    }
  }

  console.log(`jin : ${jin} ans : ${ans}`);
})();
