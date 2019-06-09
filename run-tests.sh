#!/bin/env bash

RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m'

set -e

for dir in $(ls -d */); do
  pushd "$dir" > /dev/null

  name="$(basename "$dir")"
  output=$(lein test)

  if [[ $? -ne 0 ]]; then
    echo -e "${RED}Tests for $name failed!${NC}"
    echo
    echo -e "${RED}$output${NC}"
    exit 1
  else
    echo -e "${GREEN}Tests for $name passed.${NC}"
  fi

  popd > /dev/null
done
