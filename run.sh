#!/usr/bin/env bash
# Convenience wrapper around Maven for this DSA practice project.
#
# Usage:
#   ./run.sh list                 List every runnable class
#   ./run.sh run                  Run Main (the menu)
#   ./run.sh run MergeSort        Run a class by short name (fuzzy match)
#   ./run.sh run com.practice.algorithms.sorting.MergeSort   Run by full name
#   ./run.sh test                 Run the test suite
#   ./run.sh build                Compile only

set -euo pipefail

cd "$(dirname "${BASH_SOURCE[0]}")"

SRC_DIR="src/main/java"

find_main_classes() {
    grep -rl "public static void main" "$SRC_DIR" --include="*.java"
}

path_to_class() {
    # src/main/java/com/practice/Foo.java -> com.practice.Foo
    sed -e "s|^$SRC_DIR/||" -e 's|\.java$||' -e 's|/|.|g' <<< "$1"
}

cmd_list() {
    echo "Runnable classes:"
    find_main_classes | while read -r f; do
        echo "  $(path_to_class "$f")"
    done
}

cmd_run() {
    local query="${1:-}"

    if [[ -z "$query" ]]; then
        mvn -q compile exec:java -Dexec.mainClass="com.practice.Main"
        return
    fi

    # Already a full class name (contains a dot)?
    if [[ "$query" == *.* ]]; then
        mvn -q compile exec:java -Dexec.mainClass="$query"
        return
    fi

    # Fuzzy match by short class name against files on disk.
    local matches
    matches=$(find_main_classes | grep -i "/${query}\.java$" || true)

    if [[ -z "$matches" ]]; then
        echo "No runnable class matches '$query'." >&2
        cmd_list >&2
        exit 1
    fi

    local count
    count=$(wc -l <<< "$matches")
    if [[ "$count" -gt 1 ]]; then
        echo "Multiple classes match '$query':" >&2
        while read -r f; do
            echo "  $(path_to_class "$f")" >&2
        done <<< "$matches"
        exit 1
    fi

    local class_name
    class_name=$(path_to_class "$matches")
    echo "Running $class_name"
    mvn -q compile exec:java -Dexec.mainClass="$class_name"
}

cmd_test() {
    mvn test
}

cmd_build() {
    mvn compile
}

usage() {
    sed -n '2,10p' "$0"
}

case "${1:-}" in
    list)  cmd_list ;;
    run)   shift; cmd_run "${1:-}" ;;
    test)  cmd_test ;;
    build) cmd_build ;;
    *)     usage; exit 1 ;;
esac
