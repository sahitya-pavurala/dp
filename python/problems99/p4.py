# find number of elements in a list


def find_num_elements(lst, num = 0):
    if len(lst) == 0:
        return num

    return find_num_elements(lst[1:], num + 1)


if __name__ == "__main__":
    print(find_num_elements([1, 3, 5, 6, 9, 23, 45]))
    print(find_num_elements([1, 3, 5, 6, 4, 11]))
