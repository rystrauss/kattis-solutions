import sys
import itertools


if __name__ == '__main__':
    cards = []
    valid_sets = []
    i = 1
    for line in sys.stdin:
        split = line.split()
        for card in split:
            cards.append((i, card))
            i += 1
    for c in itertools.combinations(cards, 3):
        card_nums = [str(i[0]) for i in c]
        nums = len(set([int(x[1][0]) for x in c]))
        if not (nums == 1 or nums == 3):
            continue
        shapes = len(set([x[1][1] for x in c]))
        if not (shapes == 1 or shapes == 3):
            continue
        patterns = len(set([x[1][2] for x in c]))
        if not (patterns == 1 or patterns == 3):
            continue
        colors = len(set([x[1][3] for x in c]))
        if not (colors == 1 or colors == 3):
            continue
        valid_sets.append(card_nums)
    if len(valid_sets) == 0:
        print("no sets")
    else:
        for set in valid_sets:
            print(" ".join(set))
