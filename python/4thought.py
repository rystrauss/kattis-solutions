import sys


def find_solution(x: int):
    operators = [" + ", " - ", " * ", " // "]
    for a in operators:
        for b in operators:
            for c in operators:
                temp = "4" + a + "4" + b + "4" + c + "4"
                if eval(temp) == x:
                    return temp.replace("//", "/") + " = " + str(x)
    return "no solution"


if __name__ == "__main__":
    sys.stdin.readline()
    for x in sys.stdin.readlines():
        x = int(x.strip())
        print(find_solution(x))
