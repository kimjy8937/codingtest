# [level 3] 숫자 야구 - 451808 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/451808) 

### 성능 요약

메모리: 86.8 MB, 시간: 16.24 ms

### 구분

코딩테스트 연습 > 연습문제

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 12월 02일 03:48:58

### 문제 설명

<p>당신은 숫자 야구를 플레이하는 프로그램을 작성해야 합니다. </p>

<p>숫자 야구란 1 ~ 9 사이의 서로 다른 숫자 4개로 이루어진 <code>비밀번호</code>를 맞히는 게임입니다.</p>

<p>당신은 1000 이상 9999 이하의 정수를 제출할 수 있는 기회가 총 <code>n</code>번 있으며, 수를 제출할 때마다 비밀번호에 관한 단서가 주어집니다. 이때 제출한 수의 각 자릿수에 대해 아래와 같이 판정합니다.</p>

<ul>
<li>숫자가 비밀번호에 포함되어 있지 않다면 : OUT</li>
<li>숫자가 비밀번호에 포함되어 있지만, 위치가 틀렸다면 : BALL</li>
<li>숫자가 비밀번호에 포함되어 있고, 위치까지 정확하다면 : STRIKE</li>
</ul>

<p>위와 같이 STRIKE, BALL으로 판정한 숫자의 개수를 세어, STRIKE가 <code>x</code>개 / BALL이 <code>y</code>개라면 <code>"xS yB"</code> 형식으로 단서가 주어집니다. </p>

<p>아래 표는 비밀번호가 1357일 때 제출한 수에 따른 단서의 예시입니다.</p>
<table class="table">
        <thead><tr>
<th>제출</th>
<th>단서</th>
<th>설명</th>
</tr>
</thead>
        <tbody><tr>
<td>7000</td>
<td>"0S 1B"</td>
<td>7이 비밀번호에 포함되어 있지만 위치가 틀렸으므로 1 BALL입니다.</td>
</tr>
<tr>
<td>2244</td>
<td>"0S 0B"</td>
<td>-</td>
</tr>
<tr>
<td>3333</td>
<td>"1S 3B"</td>
<td>3이 비밀번호에 포함되어 있습니다. 위치가 정확한 3이 1개, 위치가 틀린 3이 3개 있으므로 1 STRIKE, 3 BALL 입니다.</td>
</tr>
<tr>
<td>3457</td>
<td>"2S 1B"</td>
<td>3, 5, 7이 비밀번호에 포함되어 있습니다. 5, 7은 위치가 정확합니다. 따라서 2 STRIKE, 1 BALL 입니다.</td>
</tr>
<tr>
<td>7531</td>
<td>"0S 4B"</td>
<td>7, 5, 3, 1이 비밀번호에 포함되어 있지만 네 숫자 모두 위치가 틀렸으므로 4 BALL 입니다.</td>
</tr>
<tr>
<td>1357</td>
<td>"4S 0B"</td>
<td>1, 3, 5, 7이 비밀번호에 포함되어 있고, 네 숫자 모두 위치가 정확하므로 4 STRIKE 입니다.</td>
</tr>
</tbody>
      </table>
<p>숫자 야구의 최대 제출 횟수를 나타내는 정수 <code>n</code>과, 수를 제출하기 위한 <code>submit</code> 함수가 주어집니다. <code>submit</code> 함수를 호출해 비밀번호를 알아내, 숫자 야구의 비밀번호를 return 하도록 solution 함수를 완성해 주세요. </p>

<p>정답 판정을 받으려면 <code>submit</code> 함수를 호출한 횟수가 <code>n</code>을 초과하지 않아야 하며, 올바른 비밀번호를 return 해야 합니다. </p>

<hr>

<h5>제한사항</h5>

<ul>
<li>6 ≤ <code>n</code> ≤ 3,024</li>
<li><code>submit</code> 함수는 1000 이상 9999 이하의 정수를 전달받아, 단서를 <code>"xS yB"</code> 형식의 문자열로 return 합니다. 

<ul>
<li>1000 ~ 9999 사이의 정수가 아닌 값을 전달하는 경우 오답으로 판정합니다.</li>
<li><code>submit</code> 함수 사용 예시가 초기 코드로 주어집니다. 해당 코드는 1000 ~ 9999를 순서대로 제출해, 단서가 "4S 0B"인 경우 해당 정수를 return 하는 코드입니다.</li>
</ul></li>
</ul>

<hr>

<h5>테스트 케이스 구성 안내</h5>

<p>아래는 테스트 케이스 구성을 나타냅니다. 각 그룹 내의 테스트 케이스를 모두 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.</p>
<table class="table">
        <thead><tr>
<th>그룹</th>
<th>총점</th>
<th>추가 제한 사항</th>
</tr>
</thead>
        <tbody><tr>
<td>#1</td>
<td>10%</td>
<td><code>n</code> = 3024</td>
</tr>
<tr>
<td>#2</td>
<td>40%</td>
<td><code>n</code> = 33</td>
</tr>
<tr>
<td>#3</td>
<td>25%</td>
<td><code>n</code> = 14</td>
</tr>
<tr>
<td>#4</td>
<td>15%</td>
<td><code>n</code> = 9</td>
</tr>
<tr>
<td>#5</td>
<td>10%</td>
<td><code>n</code> = 6</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>3024</td>
<td>1357</td>
</tr>
<tr>
<td>3024</td>
<td>3986</td>
</tr>
<tr>
<td>33</td>
<td>7685</td>
</tr>
</tbody>
      </table>
<ul>
<li>예시로 주어지는 테스트 케이스는 비밀번호가 고정되어 있습니다.</li>
</ul>

<hr>

<h5>채점 테스트 케이스</h5>

<ul>
<li>정답 판정을 받은 채점 테스트 케이스에 따라, 정해진 점수를 획득할 수 있습니다.

<ul>
<li>채점 테스트케이스 일부는 비밀번호가 고정되어 있습니다. </li>
<li>채점 테스트케이스 일부는 solution 함수가 <code>submit</code>을 호출할 때마다 비밀번호가 바뀝니다. (단, 바뀐 비밀번호가 이전에 주어진 단서와 모순되는 경우는 없습니다.)</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>비밀번호는 1357입니다. <code>submit</code> 함수를 3024번 이하로 호출하고 1357을 return 해야 합니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>비밀번호는 3986입니다. <code>submit</code> 함수를 3024번 이하로 호출하고 3986을 return 해야 합니다.</p>

<p><strong>입출력 예 #3</strong></p>

<p>비밀번호는 7685입니다. <code>submit</code> 함수를 33번 이하로 호출하고 7685를 return 해야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges