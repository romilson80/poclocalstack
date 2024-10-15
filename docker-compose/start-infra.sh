#!/usr/bin/env bash

COMPOSE_PROJECT_NAME=poc-localstack
export COMPOSE_PROJECT_NAME

BASE_DIR=$(dirname "$0")
cd "$BASE_DIR" || exit 1

set -x
podman-compose up -d

./bin/localstack/localstack-init.sh

echo "Execução de script finalizada"