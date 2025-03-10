function solution(lottos, win_nums) {
  var answer = [];
  let count = 0;
  let zero_count = 0;
  for (lotto_num of lottos) {
    if (lotto_num === 0) {
      zero_count++;
      continue;
    }
    if (win_nums.includes(lotto_num)) count++;
  }
  answer.push([6, 6, 5, 4, 3, 2, 1][zero_count + count]);
  answer.push([6, 6, 5, 4, 3, 2, 1][count]);

  return answer;
}
