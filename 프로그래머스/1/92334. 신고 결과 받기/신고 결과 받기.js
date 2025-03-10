function solution(id_list, report, k) {
  let user = {};
  var answer = [0];
  const ban_list = [];
  report = [...new Set(report)];

  console.log(report);
  id_list.forEach((id, idx) => {
    user[id] = 0;
    answer[idx] = 0;
  });
  for (rep of report) {
    rep = rep.split(" ");
    user[rep[1]]++;
  }

  for (user_id of Object.keys(user)) {
    if (user[user_id] >= k) {
      ban_list.push(user_id);
    }
  }

  for (rep of report) {
    rep = rep.split(" ");
    if (ban_list.includes(rep[1])) {
      answer[id_list.indexOf(rep[0])] += 1;
    }
  }

  console.log(user);
  console.log(ban_list);
  return answer;
}