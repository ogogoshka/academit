var list = [23, 1, 11, 90, 33, 4, 59, 15, 66, 33, 5, 76, 22, 1];

list.sort(function (a, b) {
    return b - a;
});

console.log("sortedList = " + list.join(", "));

var list2 = list.slice(0, 5);
console.log("list2 = " + list2.join(", "));

var list5 = list.reverse().slice(0, 5).reverse();
console.log("list5 = " + list5.join(", "));

var totalList = list2.concat(list5);
console.log("totalList = " + totalList.join(", "));

var sumEvenNumbers = 0;
for (var i = 0; i < totalList.length; ++i) {
    if (totalList[i] % 2 == 0) {
        sumEvenNumbers += totalList[i];
    }
}

console.log("sumEvenNumbers = " + sumEvenNumbers);