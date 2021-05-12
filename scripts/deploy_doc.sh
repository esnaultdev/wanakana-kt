#!/bin/bash

./gradlew dokkaHtmlMultiModule
git checkout gh-pages
rm -Rf docs/
mv build/docs/ .
git add docs
git commit -a -m "Update the docs"
git push origin gh-pages
git checkout master
