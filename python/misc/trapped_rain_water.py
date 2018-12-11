# Given n non-negative integers representing an elevation map where the width of each bar is 1,
# compute how much water it is able to trap after raining.
# For example,
# Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


def get_trapped_water(levels):
    trapped_water = 0

    if len(levels) < 3:
        return trapped_water

    left_max = 0
    right_max = 0

    left = 0
    right = len(levels) - 1

    while left <= right:

        if levels[left] < levels[right]:
            if levels[left] > left_max:
                left_max = levels[left]
            else:
                trapped_water += left_max - levels[left]
            left += 1
        else:
            if levels[right] > right_max:
                right_max = levels[right]
            else:
                trapped_water = right_max - levels[right]
            right -= 1

    return trapped_water


if __name__ == "__main__":
    print(get_trapped_water([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
