# Aku-Smartboard

Aku-Smartboard is a Kotlin Multiplatform (Kotlin/Native linuxX64) Smart TV classroom client.

## Prerequisites

- JDK 17+
- Linux x64 host

## Build

```bash
./gradlew build
```

This produces a native binary at:

`build/bin/linuxX64/releaseExecutable/akulearn-smartboard.kexe`

## Run locally

```bash
HUB_URL=http://hub.local:8000 LOG_LEVEL=INFO DISPLAY=:0 XAUTHORITY=/home/aku/.Xauthority \
./build/bin/linuxX64/releaseExecutable/akulearn-smartboard.kexe
```

## Package binary for systemd

```bash
./gradlew packageSystemdBinary
```

Packaged binary output:

`build/packaging/usr/local/bin/akulearn-smartboard`

## Install on target device

```bash
sudo ./scripts/install.sh
sudo systemctl daemon-reload
sudo systemctl enable --now akulearn-smartboard
```

The installation script installs:

- `/usr/local/bin/akulearn-smartboard`
- `/etc/systemd/system/akulearn-smartboard.service`
