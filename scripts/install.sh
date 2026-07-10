#!/usr/bin/env bash
set -euo pipefail

REPO_ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$REPO_ROOT"

./gradlew linkReleaseExecutableLinuxX64 --no-daemon

BINARY="$REPO_ROOT/build/bin/linuxX64/releaseExecutable/akulearn-smartboard.kexe"
if [[ ! -f "$BINARY" ]]; then
  echo "Binary not found: $BINARY" >&2
  exit 1
fi

install -Dm755 "$BINARY" /usr/local/bin/akulearn-smartboard
install -Dm644 "$REPO_ROOT/systemd/akulearn-smartboard.service" /etc/systemd/system/akulearn-smartboard.service

echo "Installed /usr/local/bin/akulearn-smartboard"
echo "Installed /etc/systemd/system/akulearn-smartboard.service"
echo "Run: sudo systemctl daemon-reload && sudo systemctl enable --now akulearn-smartboard"
