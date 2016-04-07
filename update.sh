#!/bin/bash

git checkout -b temp master
git branch -D master
git fetch origin master:master
git checkout master
git branch -D temp

git log -n1 