# Run length encoding of a list

def run_length_encoding(lst):
    if len(lst) < 1:
        return lst
    pre = lst[0]
    count = 1
    result = []
    for item in lst[1:]:
        if item == pre:
            count += 1
            continue

        result.append([count, pre])
        pre = item
        count = 1

    result.append([count, pre])

    return result


if __name__ == "__main__":
    print(run_length_encoding([1, 1, 2, 3, 4, 6, 5, 2, 5, 2, 4, 2, 2]))
