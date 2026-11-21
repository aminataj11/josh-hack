cat << 'EOF' > AGENTS.md
# AGENTS.md - JoshHack Project Rules

## Build and Testing
- This project uses Java 17 and Maven Wrapper (`./mvnw`).
- Run `./mvnw test` for JUnit 5 tests, `./mvnw spotbugs:spotbugs` for static analysis, and PIT for mutation testing before considering any task done.

## Rules for Changes
- Keep all game behavior the same unless I specifically ask to change it.
- Do not delete, disable (`@Disabled`) or weaken existing test assertions just to get a green build.
- Flag any changes made to `src/main/java` clearly so I can review them first.
- Never run `git push` or `git merge` automatically—stop after local verification so I can inspect the diff.
EOF