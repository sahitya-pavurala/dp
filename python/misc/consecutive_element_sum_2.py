from collections import defaultdict


def get_sequence_sum(lst, total):
    check = defaultdict(lambda: 0)
    current_sum = 0
    res = 0
    for i in range(len(lst)):
        current_sum += lst[i]

        if current_sum == total:
            res += 1

        if current_sum - total in check:
            res += check[current_sum - total]

        check[current_sum] += 1

    return res


def get_sequence_sum_2(lst, total):
    check = defaultdict(lambda: 0)
    current_sum = 0
    res = []
    for i in range(len(lst)):
        current_sum += lst[i]

        if current_sum == total:
            res.append((0, i))

        if current_sum - total in check:
            res.append((check[current_sum-total]+1, i))

        check[current_sum] = i

    return res


if __name__ == "__main__":
    print(get_sequence_sum([1, -2, 3, 4, 2, 5], 6))
    print(get_sequence_sum_2([1, -2, 3, 4, 2, 5], 6))