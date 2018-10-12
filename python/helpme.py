import sys

COLUMN_NAMES = ["a", "b", "c", "d", "e", "f", "g", "h"]
PIECE_ORDER = ["K", "Q", "R", "B", "N", "P"]


def compare(o):
    c1 = PIECE_ORDER.index(o[0].upper()) * 100
    if o[0].isupper():
        c2 = o[2] * 10
    else:
        c2 = (8 - o[2]) * 10
    c3 = COLUMN_NAMES.index(o[1])
    return c1 + c2 + c3


def format_piece(t):
    return "{}{}{}".format(t[0].upper() if t[0].upper() != "P" else "", t[1], t[2])


def main():
    white = []
    black = []

    for i, row in enumerate(sys.stdin.readlines()[1::2]):
        for j, piece in enumerate(row[2::4]):
            if piece == ":" or piece == ".":
                continue
            if piece.isupper():
                white.append((piece, COLUMN_NAMES[j], 8 - i))
            else:
                black.append((piece, COLUMN_NAMES[j], 8 - i))

    white.sort(key=compare)
    black.sort(key=compare)

    print("White: {}".format(",".join([format_piece(p) for p in white])))
    print("Black: {}".format(",".join([format_piece(p) for p in black])))


if __name__ == '__main__':
    main()
