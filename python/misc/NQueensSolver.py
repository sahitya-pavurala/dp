import sys


def get_nqueens_solution(board):
    if solve_nqueens_recursive(board, 0):
        return board


def solve_nqueens_recursive(board, col):
    if col >= len(board):
        return True

    for i in range(n):
        if isValidPosition(board, i, col):
            board[i][col] = 1
            if solve_nqueens_recursive(board, col + 1):
                return True
            board[i][col] = 0
    return False


def isValidPosition(board, row, col):
    # check the left in the row
    for i in range(col):
        if board[row][i] == 1:
            return False

    # upper diagonal
    for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    # lower diagonal
    for i, j in zip(range(row, len(board)), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    return True


def print_board(board):
    if board is None:
        return None
    for i in range(len(board)):
        print(board[i])


if __name__ == "__main__":
    n = 3
    board = [[0 for j in range(n)] for i in range(n)]
    print_board(get_nqueens_solution(board))
