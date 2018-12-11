# check if list is a palindrome

def list_is_palindrome(lst, a, b):
    if a >= b:
        return True

    if lst[a] != lst[b]:
        return False

    return list_is_palindrome(lst, a + 1, b - 1)


if __name__ == "__main__":
    print(list_is_palindrome([1, 3, 5, 6, 5, 3, 1], 0, 6))
    print(list_is_palindrome([1, 3, 5, 5, 3, 1], 0, 5))
    print(list_is_palindrome([1, 3, 5, 5, 6, 1], 0, 5))