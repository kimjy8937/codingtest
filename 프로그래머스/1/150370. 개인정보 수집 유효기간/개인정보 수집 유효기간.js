function solution(today, terms, privacies) {
    var answer = [];

    // terms 매핑하기
    let termsMap = new Map()
    for (let t of terms) {
        termsMap.set(...t.split(" "))
    }

    // 오늘 날짜 숫자화
    const todays = today.split(".").map(Number)

    // 각 개인정보 다루기
    privacies.forEach((p, i) => {
        const diffdays = []
        const [date, term] = p.split(" ");
        const dates = date.split(".").map(Number)

        // 년,월,일 뺄셈
        for (let i = 0; i < dates.length; i++) {
            diffdays.push(todays[i] - dates[i])
        }

        // 경과 일수 계산
        const diff = diffdays.reduce((acc, d, i) => {
            switch (i) {
                case 0: return acc += d * 28 * 12;
                case 1: return acc += d * 28;
                case 2: return acc += d;
            }
        }, 0)

        // 경과했다면 파기 대상
        if (diff / 28 >= termsMap.get(term)) answer.push(i + 1)
    })

    return answer
}