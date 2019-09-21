const checkName = name => {};

const solution = param => {
  let ans = 0;
  const regex = /[\w+\.?\w+]+\@\w+\.[com|net|org]+/g;

  for (email of param) {
    const res = email.replace(regex, "");
    console.log(res);

    if (res === "") ans++;
  }

  console.log(ans);
};

solution(["d@co@m.com", "a@abc.com", "b@def.com", "c@ghi.net"]);
solution(["abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"]);
