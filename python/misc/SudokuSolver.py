board = [[0 for i in range(9)] for j in range(9)]


def solve_sudoku():
    if recurse_board():
        return board


def findNextCellToFill(i, j):
    for x in range(i, 9):
        for y in range(j, 9):
            if board[x][y] == 0:
                return x, y
    for x in range(0, 9):
        for y in range(0, 9):
            if board[x][y] == 0:
                return x, y
    return -1, -1


def recurse_board(row = 0, col = 0):
    i, j = findNextCellToFill(row, col)

    if i == -1:
        return True

    for num in range(1, 10):
        if is_valid_position(i, j, num):
            board[i][j] = num
            if recurse_board(i, j):
                return True

            board[i][j] = 0

    return False


def print_board():
    for i in range(len(board)):
        print board[i]


def is_valid_position(row_num, column_num, val):
    # check row
    for i in range(len(board)):
        if board[row_num][i] == val:
            return False

    # check column
    for i in range(len(board)):
        if board[i][column_num] == val:
            return False


    r1 = row_num
    c1 = column_num

    while r1 >= 0 and c1 >= 0:
        if board[r1][c1] == val:
            return False
        r1 -= 1
        c1 -= 1

    r1 = row_num
    c1 = column_num

    while r1 >= 0 and c1 < len(board):
        if board[r1][c1] == val:
            return False
        r1 -= 1
        c1 += 1

    r1 = row_num
    c1 = column_num

    while r1 < len(board) and c1 >= 0:
        if board[r1][c1] == val:
            return False
        r1 += 1
        c1 -= 1

    r1 = row_num
    c1 = column_num

    while r1 < len(board) and c1 < len(board):
        if board[r1][c1] == val:
            return False
        r1 += 1
        c1 += 1



    # check box
    r = row_num - row_num % 3
    c = column_num - column_num % 3

    for i in range(r, r + 3, 1):
        for j in range(c, c + 3, 1):
            if board[i][j] == val:
                return False

    return True


if __name__ == "__main__":
    solve_sudoku()
    print_board()
