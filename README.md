# ADS Assignment 2
### 
You are given a number “n” and an array of “n” elements, write the function that returns minimum of them. 
### Recursion for task 1
```
private static int fmin(int[] arr, int i){//function for task1
    if(i == arr.length - 1){//checking if we are on the last element of array
        return arr[i];// returning last value
    }
    else{
        int min = fmin(arr, i + 1);//recursion
        return Math.min(min, arr[i+1]);//checking min between 2 elems
    }
}
```
### Task 2
You are given a number “n” and an array of “n” elements, write the function that returns average of them. 
### Recursion for task 2
```
private static int favg(int[] arr, int i){//function for task2
    if(i == arr.length - 1){//checking if we are on the last element of array
        return arr[i];// returning last value
    }
    else{
        int sum = favg(arr, i + 1);//recursion
        return sum + arr[i];// returning sum of elements
    }
}
```
### Task 3
You are given a number “n”, write the function for checking whether“n” is prime.
### Recursion for task 3
```
private static boolean fprime(int a, int i){//function for task3
    if(i <= a/2) {//to minimize amount of numbers
        if (a % i == 0) {//checking if it is divisible by the counter
            return false;
        } else {
            return fprime(a, i + 1);//recursion
        }
    }
    return true;//returning true otherwise
}
```
### Task 4
You are given a number “n”, write the program using recursion for finding “n!”
### Recursion for task 4
```
private static int ffact(int a, int i, int f){//function for task4
    if(a < i){// checker
        return f;//end pf recursion
    }
    else{
        return ffact(a, i + 1, f * i);//recursion
    }
}
```
### Task 5
You are given a number “n”, write the function for finding n-th elements in Fibonacci sequence using recursion. (Fn = Fn-1+ Fn-2). F0= 0, F1 = 1.
### Recursion for task 5
```
private static int ffibo(int a, int b, int i, int f){//function for task5
    if(i == f){//end of recursion
        return b;
    }
    else{
        return ffibo(b, a + b, i + 1, f);//recursion
    }
}
```
### Task 6
You are given numbers “a” and “n”, write the function that returns “an”. 
### Recursion for task 6
```
private static int fpower(int a, int b, int i){//function for task5
    if(i == b){//end of recursion
        return a;
    }
    else{
        return a * fpower(a, b, i + 1);//recursion
    }
}
```
### Task 7
You are given a number “n” and an array of “n” elements, write the program that returns given array in reverse order without using array data structure.
### Recursion for task 7
```
private static void freverse(Scanner sc, int n, int i){//function for task7
    if (i == n){// end of recursion
        System.out.print(sc.nextInt() + " ");// print the last elem from those which where inputted
    }
    else {
        int a = sc.nextInt();// next digit
        freverse(sc, n, i + 1);// recursion
        System.out.print(a + " ");// output
    }
}
```
### Task 8
You are given a string “s”, write the function for checking whether “s” is all consists of digits.
### Recursion for task 8
```
private static boolean fisdigit(String s, int i) {//function for task8
    if (Character.isDigit(s.charAt(i))) {
        if (i == s.length() - 1) {
            return true;
        } else {
            return fisdigit(s, i + 1);
        }
    }
    return false;
}
```
### Task 9
You are given numbers“n” and “k”,write the program that finds Cnk (binomial coefficient)
### Recursion for task 9
```
private static int ffact(int a, int i, int f){//function for task9(from task4)
    if(a < i){// checker
        return f;//end pf recursion
    }
    else{
        return ffact(a, i + 1, f * i);//recursion
    }
}
private static int fbincoef(int n, int k) {//function for task9
    //C(n,k) = n! / ( k! * (n-k)!)
    return ffact(n, 1, 1) / (ffact(k, 1, 1) * ffact(n - k, 1, 1));
}
```
### Task 10
You are given “a” and “b”, write the function for finding GCD(a, b) using recursion.
### Recursion for task 10
```
private static int fgcd(int n, int k, int i) {//function for task10
    if (n % i == 0 && k % i == 0){//gcd
        return i;
    }
    else return fgcd(n, k, i - 1);//recursion
}
```
