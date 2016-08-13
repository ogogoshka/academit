function discriminant(a, b, c) {
    return b * b - 4 * a * c;
}

function x1(a, b, c) {
    return (-b + Math.sqrt(discriminant(a, b, c))) / (2 * a);
}

function x2(a, b, c) {
    return (-b - Math.sqrt(discriminant(a, b, c))) / (2 * a);
}

function solution(a, b, c) {
    var d = discriminant(a, b, c);
    if (d >= 0) {
        if (d == 0) {
            console.log("x = " + -b / (2 * a));
        } else {
            console.log("x1 = " + x1(a, b, c) + "\n" + "x2 = " + x2(a, b, c));
        }
    } else {
        console.log("no solutions");
    }
}

solution(1, 3, -4);
solution(1, 1, 1);
solution(1, 2, 1);