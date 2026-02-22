#!/bin/sh

docker ps > /dev/null 2>&1
[ $? -ne 0 ] && echo "please start docker desktop" && exit 1

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
git checkout ort/$NEW_VERSION
[ $? -ne 0 ] && echo "please delete existing branch ort/$NEW_VERSION" && exit 1

git checkout master && \
git pull && \
git checkout -b ort/$NEW_VERSION && \
sed -i '' "s/^com.jyuzawa.onnxruntime.library_version=.*/com.jyuzawa.onnxruntime.library_version=$NEW_VERSION/" gradle.properties && \
git commit -am "ORT v$NEW_VERSION bump" && \
./gradlew jextract && \
git add src/main/java/com/jyuzawa/onnxruntime_extern && \
git commit -am "ORT v$NEW_VERSION jextract"
./gradlew clean build