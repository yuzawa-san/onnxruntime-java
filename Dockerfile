FROM eclipse-temurin:17-jdk-jammy as builder
WORKDIR /build
ADD https://github.com/llvm/llvm-project/releases/download/llvmorg-15.0.6/clang+llvm-15.0.6-x86_64-linux-gnu-ubuntu-18.04.tar.xz clang_llvm.tar.xz
RUN apt-get update && apt-get install -y -q \
  xz-utils \
&& apt-get clean
RUN tar xvf clang_llvm.tar.xz && rm clang_llvm.tar.xz && mv clang* clang_llvm
ADD https://download.java.net/java/GA/jdk22/830ec9fcccef480bb3e73fb7ecafe059/36/GPL/openjdk-22_linux-x64_bin.tar.gz openjdk.tar.gz
RUN tar xvxf openjdk.tar.gz && rm openjdk.tar.gz
ADD https://github.com/openjdk/jextract/archive/b9ec8879cff052b463237fdd76382b3a5cd8ff2b.tar.gz jextract.tar.gz
RUN tar xvzf jextract.tar.gz && \
	rm jextract.tar.gz && \
	mv jextract-* jextract
WORKDIR /build/jextract
RUN sh ./gradlew --version
RUN sh ./gradlew --no-daemon -Pjdk22_home=/build/jdk-22 -Pllvm_home=/build/clang_llvm clean verify


FROM eclipse-temurin:17-jre-jammy
RUN apt-get update && apt-get install -y -q \
  build-essential \
&& apt-get clean
WORKDIR /jextract
COPY --from=builder /build/jextract/build/jextract .
ENTRYPOINT ["/jextract/bin/jextract"]
CMD ["/bin/bash"]
WORKDIR /workdir