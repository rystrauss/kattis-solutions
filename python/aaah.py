import sys

if __name__ == "__main__":
    ability = sys.stdin.readline().strip()
    required = sys.stdin.readline().strip()
    print("no" if len(ability) < len(required) else "go")