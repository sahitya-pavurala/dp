def get_pair_sums(lst, num):
    check = set()
    result = []
    for i in lst:
        if num - i in check:
            result.append((num - i, i))

        check.add(i)

    return result


if __name__ == "__main__":
    print(get_pair_sums([1, 4, 6, -2, 3, 0], 4))
