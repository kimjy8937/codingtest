# [level 3] 홀짝트리 - 388354 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/388354) 

### 성능 요약

메모리: 279 MB, 시간: 544.70 ms

### 구분

코딩테스트 연습 > 2025 프로그래머스 코드챌린지 1차 예선

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 11월 16일 23:52:39

### 문제 설명

<p>루트 노드가 설정되지 않은 1개 이상의 트리가 있습니다. 즉, 포레스트가 있습니다. <br>
모든 노드들은 서로 다른 번호를 가지고 있습니다. </p>

<p>각 노드는 <code>홀수 노드</code>, <code>짝수 노드</code>, <code>역홀수 노드</code>, <code>역짝수 노드</code> 중 하나입니다. 각 노드의 정의는 다음과 같으며, <strong>0은 짝수입니다.</strong></p>

<ul>
<li><code>홀수 노드</code>

<ul>
<li>노드의 번호가 홀수이며 자식 노드의 개수가 홀수인 노드입니다.</li>
</ul></li>
<li><code>짝수 노드</code>

<ul>
<li>노드의 번호가 짝수이며 자식 노드의 개수가 짝수인 노드입니다.</li>
</ul></li>
<li><code>역홀수 노드</code>

<ul>
<li>노드의 번호가 홀수이며 자식 노드의 개수가 짝수인 노드입니다.</li>
</ul></li>
<li><code>역짝수 노드</code>

<ul>
<li>노드의 번호가 짝수이며 자식 노드의 개수가 홀수인 노드입니다.</li>
</ul></li>
</ul>

<p>당신은 각 트리에 대해 루트 노드를 설정했을 때, <code>홀짝 트리</code>가 될 수 있는 트리의 개수와 <code>역홀짝 트리</code>가 될 수 있는 트리의 개수를 구하려고 합니다. 각 트리의 정의는 다음과 같습니다.</p>

<ul>
<li><code>홀짝 트리</code>

<ul>
<li><code>홀수 노드</code>와 <code>짝수 노드</code>로만 이루어진 트리입니다.</li>
</ul></li>
<li><code>역홀짝 트리</code>

<ul>
<li><code>역홀수 노드</code>와 <code>역짝수 노드</code>로만 이루어진 트리입니다.</li>
</ul></li>
</ul>

<p>다음은 트리의 루트 노드를 설정하는 예시입니다.</p>

<p>다음과 같은 트리가 있습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/a8603503-fa7f-46b2-aae1-486fabbb7314/%E1%84%86%E1%85%AE%E1%84%8C%E1%85%A6.drawio%20%281%29.png" title="" alt="무제.drawio (1).png"></p>

<p>위 트리의 루트 노드를 3번 노드로 설정하게 되면 다음과 같은 형태가 됩니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/f97d7758-a479-40ae-8f88-d989a3d331be/%E1%84%86%E1%85%AE%E1%84%8C%E1%85%A6.drawio%20%287%29.png" title="" alt="무제.drawio \(7\).png"></p>

<p>노란색 노드는 <code>홀수 노드</code> 혹은 <code>짝수 노드</code>를 나타내고, 빨간색 노드는 <code>역홀수 노드</code> 혹은 <code>역짝수 노드</code>를 나타냅니다. 이 경우, 모든 노드가 노란색이므로 <code>홀짝 트리</code>가 됩니다.</p>

<p>이 트리의 루트 노드를 6번 노드로 설정하게 되면 다음과 같은 형태가 되어 <code>홀짝 트리</code> 혹은 <code>역홀짝 트리</code>가 될 수 없습니다. </p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/a0df1cb8-8afd-4ae2-aa9e-29185be38460/%E1%84%86%E1%85%AE%E1%84%8C%E1%85%A6.drawio%20%286%29.png" title="" alt="무제.drawio \(6\).png"></p>

<p>이와 마찬가지로 다른 노드를 루트 노드로 설정하는 경우에는 <code>홀짝 트리</code> 혹은 <code>역홀짝 트리</code>가 될 수 없습니다.<br>
3번 노드를 루트 노드로 설정하는 경우에만 <code>홀짝 트리</code>가 될 수 있습니다. 따라서 위 트리는 <code>홀짝 트리</code>가 될 수 있는 트리입니다.</p>

<p>다음은 어떤 노드를 루트 노드로 설정하더라도 <code>홀짝 트리</code> 혹은 <code>역홀짝 트리</code>가 될 수 없는 트리입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/b83fd6da-e869-4c4f-bfb8-214d4820f771/%E1%84%86%E1%85%AE%E1%84%8C%E1%85%A6.drawio%20%284%29.drawio%20%281%29.png" title="" alt="무제.drawio \(4\).drawio \(1\).png"></p>

<p>즉, 트리는 어떤 노드를 루트 노드로 설정하냐에 따라 <code>홀짝 트리</code> 혹은 <code>역홀짝 트리</code>가 될 수 있습니다. 경우에 따라 하나의 트리가 <code>홀짝 트리</code>와 <code>역홀짝 트리</code> 두 가지 모두 될 수 있거나 두 가지 모두 될 수 없을 수도 있습니다.</p>

<p>포레스트에 존재하는 노드들의 번호를 담은 1차원 정수 배열 <code>nodes</code>, 포레스트에 존재하는 간선들의 정보를 담은 2차원 정수 배열 <code>edges</code>가 매개변수로 주어집니다. 이때, <code>홀짝 트리</code>가 될 수 있는 트리의 개수와 <code>역홀짝 트리</code>가 될 수 있는 트리의 개수를 1차원 정수 배열에 순서대로 담아 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>nodes</code>의 길이 ≤ 400,000

<ul>
<li>1 ≤ <code>nodes</code>의 원소 ≤ 1,000,000</li>
<li><code>nodes</code>의 원소는 중복되지 않습니다.</li>
</ul></li>
<li>1 ≤ <code>edges</code>의 길이 ≤ 1,000,000

<ul>
<li><code>edges</code>의 원소는 [<code>a</code>, <code>b</code>] 형태의 1차원 정수 배열이며, <code>a</code>번 노드와 <code>b</code>번 노드 사이에 무방향 간선이 존재한다는 것을 의미합니다.</li>
<li><code>a</code>, <code>b</code>는 <code>nodes</code>에 존재하는 원소이며 서로 다릅니다.</li>
</ul></li>
<li>포레스트인 경우만 입력으로 주어집니다.</li>
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
<td>하나의 트리만 주어집니다. <code>nodes</code>의 길이 ≤ 1,000, <code>edges</code>의 길이 ≤ 1,000</td>
</tr>
<tr>
<td>#2</td>
<td>10%</td>
<td><code>nodes</code>의 길이 ≤ 1,000, <code>edges</code>의 길이 ≤ 1,000</td>
</tr>
<tr>
<td>#3</td>
<td>30%</td>
<td>하나의 트리만 주어집니다.</td>
</tr>
<tr>
<td>#4</td>
<td>50%</td>
<td>추가 제한 사항 없음</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>nodes</th>
<th>edges</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>[11, 9, 3, 2, 4, 6]</td>
<td>[[9, 11], [2, 3], [6, 3], [3, 4]]</td>
<td>[1, 0]</td>
</tr>
<tr>
<td>[9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10]</td>
<td>[[5, 14], [1, 4], [9, 11], [2, 15], [2, 5], [9, 7], [8, 1], [6, 4]]</td>
<td>[2, 1]</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제의 예시와 같습니다.</p>

<p><code>홀짝 트리</code>가 될 수 있는 트리가 하나 존재하고, <code>역홀짝 트리</code>가 될 수 있는 트리는 존재하지 않습니다.<br>
따라서 [1, 0]을 return 해야 합니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>주어진 포레스트를 그림으로 나타내면 다음과 같습니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/files/production/39d0dcfa-3794-437b-9c43-8f50f0947175/%E1%84%86%E1%85%AE%E1%84%8C%E1%85%A6.drawio%20%285%29.png" title="" alt="무제.drawio (5).png"></p>

<p>1, 3번째 트리는 각각 10번 노드, 4번 노드를 루트 노드로 설정하면 <code>홀짝 트리</code>가 될 수 있고, 2번째 트리는 9번 노드를 루트 노드로 설정하면 <code>역홀짝 트리</code>가 될 수 있습니다.<br>
4번째 트리는 어떤 노드를 루트 노드로 설정해도 <code>홀짝 트리</code> 혹은 <code>역홀짝 트리</code>가 될 수 없습니다.<br>
따라서 [2, 1]을 return 해야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges