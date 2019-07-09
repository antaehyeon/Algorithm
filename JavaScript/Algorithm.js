function solution(phone_book) {
  let answer = false;

  phone_book.sort();

  for (let i = 0; i < phone_book.length - 1; i++) {
    for (let j = i + 1; j < phone_book.length; j++) {
      if (phone_book[i].startsWith(phone_book[j])) return answer;
      if (phone_book[j].startsWith(phone_book[i])) return answer;
    }
  }

  answer = true;

  return answer;
}

const t1 = ["119", "97674223", "1195524421"];
const t2 = ["12", "123", "1235", "567", "88"];
const t3 = ["123", "456", "789"];

console.log(solution(t1));
console.log(solution(t2));
console.log(solution(t3));
