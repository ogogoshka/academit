var list = [];

for (var i = 1; i <= 100; i++) {
    list.push(i);
}
console.log(list.join(","));

var sumOfEvenNumbers = 0;
for (i = 0; i < list.length; i++) {
    if (list[i] % 2 == 0) {
        sumOfEvenNumbers += list[i];
    }
}
console.log("sumOfEvenNumbers = " + sumOfEvenNumbers);

var list5 = list.slice(0, 5);
console.log(list5.join(","))

var list2 = list.reverse();
console.log(list2.join(","));

var list4 = list.slice(0, 5);
console.log(list4.join(","))

var list6 = list5.concat(list4);
console.log("list6 = " + list6.join(","));

var list3 = list.splice(5, 90);
console.log(list3.join(","));
console.log(list.join(","));

sumOfEvenNumbers = 0;
for (i = 0; i < list.length; i++) {
    if (list[i] % 2 == 0) {
        sumOfEvenNumbers += list[i];
    }
}
console.log("sumOfEvenNumbers = " + sumOfEvenNumbers);