FROM eclipse-temurin:25-jdk-noble AS builder
WORKDIR /build
# https://documentation.ubuntu.com/ubuntu-for-developers/reference/availability/llvm/
RUN apt-get update && apt-get install -y -q \
  clang-18 \
  xz-utils \
&& apt-get clean
RUN ln -s /usr/lib/llvm-18/lib/libclang-18.so.18 /usr/lib/llvm-18/lib/libclang.so.18
ADD https://github.com/openjdk/jextract/archive/91fc954c46fac907cae6cd1417d835208c9df150.tar.gz jextract.tar.gz
RUN tar xvzf jextract.tar.gz && \
	rm jextract.tar.gz && \
	mv jextract-* jextract
WORKDIR /build/jextract
RUN sed -i 's/8.11.1/9.2.1/g' gradle/wrapper/gradle-wrapper.properties && sh ./gradlew wrapper -Pjdk_home= -Pllvm_home=
RUN sh ./gradlew --version
RUN sh ./gradlew --no-daemon -Pjdk_home=/opt/java/openjdk -Pllvm_home=/usr/lib/llvm-18 clean verify

FROM eclipse-temurin:25-jre-noble
RUN apt-get update && apt-get install -y -q \
  build-essential libedit2 libxml2 \
&& apt-get clean
WORKDIR /jextract
COPY --from=builder /build/jextract/build/jextract .
ENTRYPOINT ["/jextract/bin/jextract"]
CMD ["/bin/bash"]
WORKDIR /workdir