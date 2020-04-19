def get_sequence_sum(lst, total):
    start = 0
    end = 0
    current_sum = 0
    while end < len(lst):

        if current_sum < total:
            current_sum += lst[end]
            end += 1

        elif current_sum > total:
            current_sum -= lst[start]
            start += 1

        else:
            return True


if __name__ == "__main__":
    print(get_sequence_sum([1, 3, 4, 2, 5], 6))
