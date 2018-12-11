# find last but one element in a list
import sys


def find_last_but_one_element(lst):
    if len(lst) <= 1:
        print("Invalid input, Cannot find last but one element")
        sys.exit(1)

    if len(lst) == 2:
        return lst[0]

    return find_last_but_one_element(lst[1:])


if __name__ == "__main__":
    print(find_last_but_one_element([1, 2, 3, 4, 5]))
