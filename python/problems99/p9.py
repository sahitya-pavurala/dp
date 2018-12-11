# pack consecutive duplicates into lists

def pack_duplicates(lst):
    if len(lst) <= 1:
        return lst

    pre = lst[0]
    result = []
    count = 1
    for item in lst[1:]:
        if pre == item:
            count += 1
            continue

        result.append([pre for i in range(count)])
        pre = item
        count = 1

    result.append([pre for i in range(count)])

    return result


if __name__ == "__main__":
    print(pack_duplicates([1, 1, 2, 3, 4, 6, 5, 2, 5, 2, 4, 2, 2]))
