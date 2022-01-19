FROM debian:bullseye-slim

RUN apt-get update && apt-get install -y -q \
  curl \
  libc-dev \
&& apt-get clean

RUN curl -OL "https://download.java.net/java/early_access/panama/3/openjdk-17-panama+3-167_linux-x64_bin.tar.gz" && \
  tar xvzf openjdk-17-panama+3-167_linux-x64_bin.tar.gz

ENTRYPOINT ["/jdk-17/bin/jextract"]
CMD ["/bin/bash"]
WORKDIR /workdir