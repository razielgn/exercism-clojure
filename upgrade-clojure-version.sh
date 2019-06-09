#!/bin/env bash

set -xe

version=$1

if [[ -z $version ]]; then
  echo "Need toprovider version!"
  exit 1
fi

find . -name "project.clj" \
  | xargs sed -i "s/clojure \"[^\"]\+\"/clojure \"$version\"/g"
