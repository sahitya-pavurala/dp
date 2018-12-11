# Reverse a list

def reverse_list(lst, a, b):
    if a > b:
        return lst

    lst[a], lst[b] = lst[b], lst[a]
    return reverse_list(lst, a + 1, b - 1)


if __name__ == "__main__":
    print(reverse_list([1, 3, 5, 6, 9, 23, 45], 0, 6))
    print(reverse_list([1, 3, 5, 6, 4, 11], 0, 5))
