#!/bin/sh

NEW_VERSION=$(curl -s https://api.github.com/repos/microsoft/onnxruntime/tags | jq -r ".[0].name" | sed 's/^v//g')
read -p "Use version $NEW_VERSION (y/n)? " answer
case ${answer:0:1} in
    y|Y )
        echo "Using version $NEW_VERSION"
    ;;
    * )
        exit 1;
    ;;
esac
git checkout master
git pull
sed -i '' "s/^com.jyuzawa.onnxruntime.library_version=.*/com.jyuzawa.onnxruntime.library_version=$NEW_VERSION/" gradle.properties
./gradlew clean build
git checkout -b ort/$NEW_VERSION
git commit -am "Bump upstream onnxruntime library to v$NEW_VERSION"