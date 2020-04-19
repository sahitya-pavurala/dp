def get_zigzag_str(word, n):
    sub_strs = ['' for i in range(n)]
    flag = True
    i = 0
    row = 0
    while i < len(word):

        if flag:
            sub_strs[row] += word[i]
            row += 1
            if row > n - 1:
                flag = not flag
                row -= 2

        else:
            sub_strs[row] += word[i]
            row -= 1
            if row < 0:
                flag = not flag
                row += 2

        i += 1

    return ''.join(sub_strs)


if __name__ == "__main__":
    print(get_zigzag_str("paribusishiring", 4))
