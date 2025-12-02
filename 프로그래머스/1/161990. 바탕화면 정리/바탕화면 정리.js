function solution(wallpaper) {
  const answer = [];
  const xPos = [];
  const yPos = [];
  for (let i = 0; i < wallpaper.length; i++) {
    for (let j = 0; j < wallpaper[i].length; j++) {
      if (wallpaper[i][j] === "#") {
        xPos.push(i);
        yPos.push(j);
      }
    }
  }
  answer.push( Math.min(...xPos));
  answer.push( Math.min(...yPos));
  answer.push(Math.max(...xPos) + 1);
  answer.push(Math.max(...yPos) + 1);

  console.log(xPos);
  console.log(yPos);

  return answer;
}