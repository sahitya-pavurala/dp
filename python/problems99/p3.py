# find kth element in a list
# 1,3,5,6,9,23,45 k = 5, 9 should be returned
import sys


def find_kth_element(lst, k):
    if len(lst) < k:
        print("Invalid input. Cannot find the %dth element"%k)
        sys.exit(1)

    if len(lst) == len(lst) - k + 1:
        return lst[0]

    return find_kth_element(lst[1:], k-1)


if __name__ == "__main__":
    print(find_kth_element([1,3,5,6,9,23,45], 5))
    print(find_kth_element([1,3,5,6,4,11], 1))
