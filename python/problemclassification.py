import sys

if __name__ == '__main__':
    n = int(sys.stdin.readline().strip())
    lookup = {}
    scores = {}
    for i in range(n):
        data = sys.stdin.readline().split()
        scores[data[0]] = 0
        for word in data[2:]:
            if word not in lookup:
                lookup[word] = set()
            lookup[word].add(data[0])
    text = sys.stdin.read().split()
    for word in text:
        for category in lookup.get(word, []):
            scores[category] += 1

    max_score = max(scores.values())
    results = sorted([i[0] for i in scores.items() if i[1] == max_score])
    print("\n".join(results))
