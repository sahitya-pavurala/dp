# flatten a nested list

def flatten_lst(lst):

    result = []
    for item in lst:
        if type(item) == list:
            result.extend(item)
        else:
            result.append(item)

    return result


if __name__ == "__main__":
    print(flatten_lst([1, 3, [5, 6], [5, 3, 1], [0, 6]]))