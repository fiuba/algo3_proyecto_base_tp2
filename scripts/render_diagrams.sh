#!/bin/sh

find diagrams/ -name '*.plantuml' -exec plantuml -v {} \;
