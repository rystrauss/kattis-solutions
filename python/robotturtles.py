"""
NOTE: While this solution provides the correct answer, it currently exceeds the time limit on Kattis and
needs further optimization and/or reformulating.
"""

import sys

X = 1
Y = 0
VALID_SPACES = [".", "I", "D"]

board = []
best_solution = None


def get_moves(turtle):
    moves = []
    if turtle[Y] - 1 >= 0 and board[turtle[Y] - 1][turtle[X]] in VALID_SPACES:
        moves.append([turtle[Y] - 1, turtle[X]])
    if turtle[Y] + 1 < 8 and board[turtle[Y] + 1][turtle[X]] in VALID_SPACES:
        moves.append([turtle[Y] + 1, turtle[X]])
    if turtle[X] - 1 >= 0 and board[turtle[Y]][turtle[X] - 1] in VALID_SPACES:
        moves.append([turtle[Y], turtle[X] - 1])
    if turtle[X] + 1 < 8 and board[turtle[Y]][turtle[X] + 1] in VALID_SPACES:
        moves.append([turtle[Y], turtle[X] + 1])
    return moves


def get_rotations(turtle, direction, destination):
    if destination[X] > turtle[X]:
        side = 1
    elif destination[X] < turtle[X]:
        side = 3
    elif destination[Y] > turtle[Y]:
        side = 2
    else:
        side = 0

    if side - direction == 3 or side - direction == -1:
        return "L", side
    else:
        return "R" * abs(side - direction), side


def traverse(turtle, direction, operations, visited):
    global best_solution
    if best_solution is not None and len(operations) >= len(best_solution):
        return False
    if board[turtle[Y]][turtle[X]] == "D":
        best_solution = operations
        return True

    visited.add(8 * turtle[Y] + turtle[X])

    moves = get_moves(turtle)

    for move in moves:
        if (8 * move[Y] + move[X]) in visited:
            continue
        rotations, d = get_rotations(turtle, direction, move)
        if board[move[Y]][move[X]] == "I":
            if traverse(move, d, operations + rotations + "XF", visited):
                break
        else:
            if traverse(move, d, operations + rotations + "F", visited):
                break

    visited.remove(8 * turtle[Y] + turtle[X])
    return False


if __name__ == '__main__':
    for line in sys.stdin:
        row = []
        for c in line.strip():
            row.append(c)
        board.append(row)

    turtle = [7, 0]
    direction = 1

    visited = set()

    traverse(turtle, direction, "", visited)

    print("no solution" if best_solution is None else best_solution)
