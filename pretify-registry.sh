#!/usr/bin/env bash

for file in registry.dat.*
do
    cat $file | python -m json.tool > $file.pretty
done
