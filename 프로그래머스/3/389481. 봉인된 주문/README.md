# [level 3] 봉인된 주문 - 389481 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/389481) 

### 성능 요약

메모리: 161 MB, 시간: 257.27 ms

### 구분

코딩테스트 연습 > 2025 프로그래머스 코드챌린지 2차 예선

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2025년 10월 19일 12:59:33

### 문제 설명

<p>어느 날, 전설 속에 전해 내려오는 비밀 주문서가 세상에 다시 모습을 드러냈습니다. 이 주문서에는 마법 세계에서 사용되는 모든 주문이 적혀 있는데, 각 주문은 알파벳 소문자 11글자 이하로 구성되어 있습니다. 주문서에는 실제로 마법적 효과를 지니지 않는 의미 없는 주문들 즉, 알파벳 소문자 11글자 이하로 쓸 수 있는 모든 문자열이 고대의 규칙에 따라 아래와 같이 정렬되어 있습니다.</p>

<ol>
<li>글자 수가 적은 주문부터 먼저 기록된다.</li>
<li>글자 수가 같다면, 사전 순서대로 기록된다.</li>
</ol>

<p>예를 들어, 주문서의 시작 부분은 다음과 같이 구성됩니다.</p>

<ul>
<li>"a"→"b"→"c"→"d"→"e"→"f"→...→"z"</li>
<li>→"aa"→"ab"→...→"az"→"ba"→...→"by"→"bz"→"ca"→...→"zz"</li>
<li>→"aaa"→"aab"→...→"aaz"→"aba"→...→"azz"→"baa"→...→"zzz"</li>
<li>→"aaaa"→...→"aazz"→"abaa"→...→"czzz"→"daaa"→...→"zzzz"</li>
<li>→"aaaaa"→...</li>
</ul>

<p>하지만 이 주문서에는 오래전 봉인된 저주받은 주문들이 숨겨져 있었고, 이를 악용하려는 자들을 막기 위해 마법사들이 몇몇 주문을 주문서에서 삭제했습니다. 당신은 삭제가 완료된 주문서에서 <code>n</code>번째 주문을 찾아내야 합니다.</p>

<p>예를 들어, 주문서에서 "d", "e", "bb", "aa", "ae" 5개의 주문을 지웠을 때, 주문서에서 30번째 주문을 찾으려고 합니다.</p>

<ul>
<li>1~3번째 주문은 "a", "b", "c" 입니다.</li>
<li>"d"와 "e"는 삭제됐으므로 4~24번째 주문은 "f" ~ "z"입니다.</li>
<li>"aa"는 삭제됐으므로 25~27번째 주문은 "ab", "ac", "ad"입니다.</li>
<li>"ae"는 삭제됐으므로 28~30번째 주문은 "af", "ag", "ah"입니다.</li>
</ul>

<p>따라서 30번째 주문은 "ah"가 됩니다. 삭제된 주문 중 “bb”와 같이 <code>n</code>번째 주문보다 뒤에 위치해 있어서 <code>n</code>번째 주문을 찾는 데 영향을 주지 않는 주문도 존재할 수 있습니다.</p>

<p>정수 <code>n</code>과 삭제된 주문들을 담은 1차원 문자열 배열 <code>bans</code>가 매개변수로 주어질 때, 삭제가 완료된 주문서의 <code>n</code>번째 주문을 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>n</code> ≤ 10<sup>15</sup></li>
<li>1 ≤ <code>bans</code>의 길이 ≤ 300,000

<ul>
<li><code>bans</code>의 원소는 알파벳 소문자로만 이루어진 길이가 1 이상 11 이하인 문자열입니다.</li>
<li><code>bans</code>의 원소는 중복되지 않습니다.</li>
</ul></li>
</ul>

<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>n</th>
<th>bans</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>30</td>
<td>["d", "e", "bb", "aa", "ae"]</td>
<td>"ah"</td>
</tr>
<tr>
<td>7388</td>
<td>["gqk", "kdn", "jxj", "jxi", "fug", "jxg", "ewq", "len", "bhc"]</td>
<td>"jxk"</td>
</tr>
</tbody>
      </table>
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
<td>15%</td>
<td><code>n</code> ≤ 1,000, <code>bans</code>의 길이 ≤ 100</td>
</tr>
<tr>
<td>#2</td>
<td>15%</td>
<td><code>n</code> ≤ 1,000,000</td>
</tr>
<tr>
<td>#3</td>
<td>70%</td>
<td>추가 제한 사항 없음</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p>문제 예시와 같습니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p>주어진 주문을 지운 후 주문서의 7,388 번째 주문은 "jxk"입니다.<br>
따라서 "jxk"를 return 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges