# Eliminate consecutive duplicates in a list

def remove_consecutive_duplicates(lst):
    if len(lst) <= 1:
        return lst

    pre = lst[0]

    result = [pre]

    for i in range(1, len(lst)):
        if lst[i] != pre:
            pre = lst[i]
            result.append(pre)

    return result


if __name__ == "__main__":
    print(remove_consecutive_duplicates([1, 1, 2, 3, 4, 6, 5, 2, 5, 2, 4, 2, 2]))
