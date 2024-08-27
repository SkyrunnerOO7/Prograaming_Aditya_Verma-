Here's a more polished and detailed Markdown file with enhanced content, code explanations, and formatting for your bitwise operations in C++:

---

# Bitwise Operations in C++

Bitwise operations allow you to manipulate data at the bit level, making them extremely efficient for low-level programming tasks. Here, we'll cover some essential bitwise operations and their applications in C++.

## Table of Contents
1. [Swap Two Numbers Without Using a Temporary Variable](#swap-two-numbers-without-using-a-temporary-variable)
2. [Check if the nth Bit is Set](#check-if-the-nth-bit-is-set)
3. [Set the ith Bit](#set-the-ith-bit)
4. [Clear the ith Bit](#clear-the-ith-bit)
5. [Toggle the ith Bit](#toggle-the-ith-bit)
6. [Remove the Last Set Bit](#remove-the-last-set-bit)
7. [Check if the Number is a Power of 2](#check-if-the-number-is-a-power-of-2)

---

## 1. Swap Two Numbers Without Using a Temporary Variable

One common use of bitwise XOR (`^`) is swapping two numbers without the need for a temporary variable.

```cpp
void swapNumbers(int& a, int& b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
}
```

### How It Works:
- The XOR operation (`^`) outputs `1` when the input bits are different, and `0` when they are the same.
- By applying a series of XOR operations, we can swap the values of `a` and `b` without requiring an additional storage variable.

### Example:
```cpp
int main() {
    int x = 5, y = 10;
    std::cout << "Before swap: x = " << x << ", y = " << y << std::endl;
    swapNumbers(x, y);
    std::cout << "After swap: x = " << x << ", y = " << y << std::endl;
    return 0;
}
```

**Output:**
```
Before swap: x = 5, y = 10
After swap: x = 10, y = 5
```

---

## 2. Check if the nth Bit is Set

This function checks whether the nth bit in a number is set (i.e., whether it is `1`).

```cpp
bool isNthBitSet(int num, int n) {
    return (num & (1 << n)) != 0;
}
```

### How It Works:
- The expression `1 << n` shifts the number `1` to the left by `n` positions, creating a mask with only the nth bit set.
- The bitwise AND operation (`&`) is then used to check if the nth bit in `num` is `1`.
- If the result is non-zero, the nth bit is set.

### Example:
```cpp
int main() {
    int num = 5; // Binary: 0101
    int n = 2;

    if (isNthBitSet(num, n)) {
        std::cout << "The " << n << "th bit is set." << std::endl;
    } else {
        std::cout << "The " << n << "th bit is not set." << std::endl;
    }

    return 0;
}
```

**Output:**
```
The 2th bit is set.
```

---

## 3. Set the ith Bit

To set the ith bit of a number to `1`, you can use the following code snippet:

```cpp
int setIthBit(int num, int i) {
    return num | (1 << i);
}
```

### How It Works:
- The expression `1 << i` shifts `1` to the left by `i` positions, creating a mask with the ith bit set.
- The bitwise OR operation (`|`) is used to set the ith bit in `num`.

### Example:
```cpp
int main() {
    int num = 5; // Binary: 0101
    int i = 1;

    int result = setIthBit(num, i);
    std::cout << "After setting the " << i << "th bit, num = " << result << std::endl;

    return 0;
}
```

**Output:**
```
After setting the 1th bit, num = 7
```

---

## 4. Clear the ith Bit

To clear the ith bit (set it to `0`), you can use this code:

```cpp
int clearIthBit(int num, int i) {
    return num & ~(1 << i);
}
```

### How It Works:
- The expression `1 << i` creates a mask with the ith bit set.
- The bitwise NOT (`~`) inverts the mask, setting all bits to `1` except the ith bit.
- The bitwise AND operation (`&`) is then used to clear the ith bit in `num`.

### Example:
```cpp
int main() {
    int num = 7; // Binary: 0111
    int i = 1;

    int result = clearIthBit(num, i);
    std::cout << "After clearing the " << i << "th bit, num = " << result << std::endl;

    return 0;
}
```

**Output:**
```
After clearing the 1th bit, num = 5
```

---

## 5. Toggle the ith Bit

Toggling the ith bit means changing it from `0` to `1` or from `1` to `0`. This can be done with the XOR operation:

```cpp
int toggleIthBit(int num, int i) {
    return num ^ (1 << i);
}
```

### How It Works:
- The expression `1 << i` creates a mask with the ith bit set.
- The XOR operation (`^`) toggles the ith bit in `num`.

### Example:
```cpp
int main() {
    int num = 5;
    int i = 2;

    int result = toggleIthBit(num, i);
    std::cout << "After toggling the " << i << "th bit, num = " << result << std::endl;

    return 0;
}
```

**Output:**
```
After toggling the 2th bit, num = 1
```

---

## 6. Remove the Last Set Bit

To remove the last set bit from a number, you can use the following code snippet:

```cpp
int removeLastSetBit(int num) {
    return num & (num - 1);
}
```

### How It Works:
- Subtracting `1` from `num` sets all the bits to the right of the last set bit to `1`, and the last set bit itself to `0`.
- The bitwise AND operation (`&`) is then used to remove the last set bit from `num`.

### Example:
```cpp
int main() {
    int num = 40; 

    int result = removeLastSetBit(num);
    std::cout << "After removing the last set bit, num = " << result << std::endl;

    return 0;
}
```

**Output:**
```
After removing the last set bit, num = 32
```

---

## 7. Check if the Number is a Power of 2

To check if a number is a power of 2, you can use the following code snippet:

```cpp
bool isPowerOfTwo(int num) {
    return (num & (num - 1)) == 0;
}
```

### How It Works:
- Subtracting `1` from `num` sets all the bits to the right of the last set bit to `1`, and the last set bit itself to `0`.
- If `num` is a power of 2, it has only one set bit.
- The bitwise AND operation (`&`) is then used to check if the result is `0`.
- If the result is `0`, `num` is a power of 2.

### Example:
```cpp
int main() {
    int num = 16; // Binary: 10000

    if (isPowerOfTwo(num)) {
        std::cout << num << " is a power of 2." << std::endl;
    } else {
        std::cout << num << " is not a power of 2." << std::endl;
    }

    return 0;
}
```

**Output:**
```
16 is a power of 2.
```

## 8. Count the Number of Set Bits

To count the number of ones in a binary representation, you can use the following code snippet:

```cpp
int countOnes(int num) {
    int count = 0;
    while (num > 0) {
        if (num % 2 == 0) {
            count++;
        }
        num = num / 2;
    }
    return count;
}
```

### How It Works:
- The bitwise AND operation (`&`) is used to check if the last bit in `num` is `1`.
- If the last bit is `1`, the count is incremented.
- The right shift operator (`>>`) is then used to shift `num` one bit to the right, effectively removing the last bit.
- This process is repeated until `num` becomes `0`.

### Example:
```cpp
int main() {
    int num = 15; // Binary: 1111

    int ones = countOnes(num);
    std::cout << "Number of ones in the binary representation of " << num << " = " << ones << std::endl;

    return 0;
}
```

**Output:**
```
Number of ones in the binary representation of 15 = 4
```