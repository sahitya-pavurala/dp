# find last element in a list
import sys


def find_last_recursive(lst):
    if len(lst) < 1:
        print('Invalid input. Cannot find the last element')
        sys.exit(1)

    if len(lst) == 1:
        return lst.pop()

    return find_last_recursive(lst[1:])


if __name__ == "__main__":
    print(find_last_recursive([1, 2, 3, 4, 5]))
